package com.travix.medusa.busyflights.domain.busyflights;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;

@Component
public class Converter {
	

	
	public List<BusyFlightsResponse> convertCrazyFlights(List<CrazyAirResponse> crazyList) {
		List<BusyFlightsResponse> ret = new ArrayList<BusyFlightsResponse>();
		
		for (CrazyAirResponse c : crazyList) {
			BusyFlightsResponse b = new BusyFlightsResponse();
			b.setAirline(c.getAirline());
			b.setDepartureDate(c.getDepartureDate());
			b.setDestination(c.getDestinationAirportCode());
			b.setOrigin(c.getDepartureAirportCode());
			b.setReturnDate(c.getDepartureDate());
		
			ret.add(b);
		}
			
		
		return ret;
		
	}

	public List<BusyFlightsResponse> convertToughFlights(List<ToughJetResponse> toughJetResponse) {
		List<BusyFlightsResponse> ret = new ArrayList<BusyFlightsResponse>();
		
		for (ToughJetResponse c : toughJetResponse) {
			BusyFlightsResponse b = new BusyFlightsResponse();
			b.setAirline(c.getCarrier());
			b.setDepartureDate(c.getInboundDateTime());
			b.setDestination(c.getArrivalAirportName());
			b.setOrigin(c.getDepartureAirportName());
			b.setReturnDate(c.getOutboundDateTime());
		
			ret.add(b);
		}
		
		return ret;
	}

}
