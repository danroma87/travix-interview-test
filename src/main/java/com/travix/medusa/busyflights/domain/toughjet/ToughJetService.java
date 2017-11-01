package com.travix.medusa.busyflights.domain.toughjet;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface ToughJetService {
	
	public List<ToughJetResponse> search(ToughJetRequest request);
	
}
