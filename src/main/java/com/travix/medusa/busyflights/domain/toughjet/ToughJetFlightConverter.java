package com.travix.medusa.busyflights.domain.toughjet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.travix.medusa.busyflight.converter.FlightConverter;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;

@Component
@Qualifier("ToughJetFlightConverter")
public class ToughJetFlightConverter implements FlightConverter< List<ToughJetResponse>, List<BusyFlightsResponse>> {
	

	@Override
	public List<BusyFlightsResponse> convert(List<ToughJetResponse> toughList) {
		List<BusyFlightsResponse> ret = new ArrayList<BusyFlightsResponse>();
		
		for (ToughJetResponse c : toughList) {
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
