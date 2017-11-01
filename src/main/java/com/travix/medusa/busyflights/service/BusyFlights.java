package com.travix.medusa.busyflights.service;

import java.util.List;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;

public interface BusyFlights {

	
	public List<BusyFlightsResponse> getFlight( String start, String end, 
											 Integer pax, String from, 
											 String to);
}
