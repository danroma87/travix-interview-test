package com.travix.medusa.busyflights.domain.busyflights;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirService;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetService;
import com.travix.medusa.busyflights.service.BusyFlights;

@RestController
public class BusyFlightRestController implements BusyFlights {

	
	
	@Autowired CrazyAirService crazyAirService;
	@Autowired ToughJetService toughJetService;
	@Autowired Converter converter;

	
	@RequestMapping("/getFlight/{start}/{end}/{iataOrigin}/{iataDestination}")
	public List<BusyFlightsResponse> getFlight(@PathVariable String start, @PathVariable String end, 
											@PathVariable Integer pax,@PathVariable String from, 
											@PathVariable String to) {
		
		//TO-DO 
		return null;
	}
	
	
	@RequestMapping("/getFlights")
	public List<BusyFlightsResponse> getFlights(@ModelAttribute BusyFlightsRequest busyRequest) {
		
		List<BusyFlightsResponse> ret = new ArrayList<BusyFlightsResponse>();
		
		CrazyAirRequest  crazyRequest = composeCrazyAirRequest(busyRequest);
		List<CrazyAirResponse> crazyAirResponse = sendCrazyAirRequest(crazyRequest);
		
		ToughJetRequest  toughJetRequest = composeToughJetRequest(busyRequest);
		List<ToughJetResponse> toughJetResponse = sendToughJetRequest(toughJetRequest);

		ret.addAll(converter.convertCrazyFlights(crazyAirResponse));
		ret.addAll(converter.convertToughFlights(toughJetResponse));
		
	
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
