package com.travix.medusa.busyflights.domain.busyflights;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travix.medusa.busyflight.converter.FlightConverter;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirService;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetService;

@RestController
public class BusyFlightRestController {

	
	
	@Autowired CrazyAirService crazyAirService;
	@Autowired ToughJetService toughJetService;

	@Qualifier("CrazyAirConverter")
	@Autowired FlightConverter<List<CrazyAirResponse>,List<BusyFlightsResponse>> crazyAirFlightConverter;

	@Qualifier("ToughJetFlightConverter")
	@Autowired FlightConverter<List<ToughJetResponse>,List<BusyFlightsResponse>> tughJetFlightConverter;

	
	
	
	@RequestMapping("/getFlights")
	public List<BusyFlightsResponse> getFlights(@ModelAttribute BusyFlightsRequest busyRequest) {
		
		List<BusyFlightsResponse> ret = new ArrayList<BusyFlightsResponse>();
		
		CrazyAirRequest  crazyRequest = composeCrazyAirRequest(busyRequest);
		List<CrazyAirResponse> crazyAirResponse = sendCrazyAirRequest(crazyRequest);
		
		ToughJetRequest  toughJetRequest = composeToughJetRequest(busyRequest);
		List<ToughJetResponse> toughJetResponse = sendToughJetRequest(toughJetRequest);

		ret.addAll(crazyAirFlightConverter.convert(crazyAirResponse));
		ret.addAll(tughJetFlightConverter.convert(toughJetResponse));
		
//	
		return ret;
	}





	private List<ToughJetResponse> sendToughJetRequest(ToughJetRequest toughJetRequest) {
		
		List<ToughJetResponse> ret = toughJetService.search(toughJetRequest);

	return ret;
	}


	private ToughJetRequest composeToughJetRequest(BusyFlightsRequest busyRequest) {
		ToughJetRequest ret = new ToughJetRequest();
		
		ret.setFrom(busyRequest.getOrigin());
		ret.setInboundDate(busyRequest.getDepartureDate());
		ret.setNumberOfAdults(busyRequest.getNumberOfPassengers());
		ret.setOutboundDate(busyRequest.getReturnDate());
		ret.setTo(busyRequest.getDestination());
		
		
		return ret;
	}


	private CrazyAirRequest composeCrazyAirRequest(BusyFlightsRequest busyRequest){
		CrazyAirRequest crazyRequest = new CrazyAirRequest();
		crazyRequest.setDepartureDate(busyRequest.getDepartureDate());
		crazyRequest.setReturnDate(busyRequest.getReturnDate());
		crazyRequest.setDestination(busyRequest.getDestination());
		crazyRequest.setOrigin(busyRequest.getOrigin());
		
		return crazyRequest;
	}

	private List<CrazyAirResponse> sendCrazyAirRequest(CrazyAirRequest crazyRequest) {
		List<CrazyAirResponse> crazyResponse = crazyAirService.search(crazyRequest);
		return crazyResponse;
	}
	
}
