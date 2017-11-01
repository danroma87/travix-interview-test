package com.travix.medusa.busyflights.domain.toughjet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ToughJetServiceImpl implements ToughJetService {
	
	public List<ToughJetResponse> search(ToughJetRequest request) {
		
		List<ToughJetResponse> ret = null;
		try {
			
			ret = getAvailable(request);
			
			
		} catch (Exception e) {
			System.out.println("Error "+e.getMessage());
		}
		
		return ret;
		
	}

	private List<ToughJetResponse> getAvailable(ToughJetRequest request) {
		List<ToughJetResponse> ret = new ArrayList<ToughJetResponse>();
		String carrier= "ToughJet";
		ToughJetResponse t1 = new ToughJetResponse();
		t1.setArrivalAirportName("GATWICK");
		t1.setBasePrice(75.5);
		t1.setCarrier(carrier);
		t1.setDepartureAirportName("FIUMICINO");
		t1.setDiscount(11);
		t1.setInboundDateTime("10/10/2017 18:34");
		t1.setOutboundDateTime("10/10/2017 15:34");
		ret.add(t1);

		
		ToughJetResponse t2 = new ToughJetResponse();
		t2.setArrivalAirportName("CIAMPINO");
		t2.setBasePrice(25.5);
		t2.setCarrier(carrier);
		t2.setDepartureAirportName("LUTON");
		t2.setDiscount(0);
		t2.setInboundDateTime("11/10/2017 13:34");
		t2.setOutboundDateTime("11/10/2017 9:34");
		ret.add(t2);
		
		
		ToughJetResponse t3 = new ToughJetResponse();
		t3.setArrivalAirportName("GATWICK");
		t3.setBasePrice(175.5);
		t3.setCarrier(carrier);
		t3.setDepartureAirportName("FIUMICINO");
		t3.setDiscount(11);
		t3.setInboundDateTime("11/10/2017 19:34");
		t3.setOutboundDateTime("11/10/2017 17:34");
		ret.add(t3);

		
		
		ToughJetResponse t4 = new ToughJetResponse();
		t4.setArrivalAirportName("LUTON");
		t4.setBasePrice(125.5);
		t4.setCarrier(carrier);
		t4.setDepartureAirportName("FIUMICINO");
		t4.setDiscount(13);
		t4.setInboundDateTime("10/10/2017 10:34");
		t4.setOutboundDateTime("10/10/2017 6:34");
		ret.add(t4);
		
		
		return ret;
	}
	
}
