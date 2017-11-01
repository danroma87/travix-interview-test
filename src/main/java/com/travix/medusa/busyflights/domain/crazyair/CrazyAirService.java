package com.travix.medusa.busyflights.domain.crazyair;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface CrazyAirService {
	
	public List<CrazyAirResponse> search(CrazyAirRequest request);
	
}
