package com.travix.medusa.busyflights.domain.crazyair;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class CrazyAirImpl implements CrazyAirService {

	public List<CrazyAirResponse> search(CrazyAirRequest request) {

		List<CrazyAirResponse> ret = null;
		try {
			
			ret = getAvailable(request);
			
			
		} catch (Exception e) {
			System.out.println("Error "+e.getMessage());
		}
		
		return ret;
	}
	
	
	private List<CrazyAirResponse> getAvailable(CrazyAirRequest request) {
		
		List<CrazyAirResponse> ret = new ArrayList<CrazyAirResponse>();
		
		CrazyAirResponse r1 = new CrazyAirResponse();
		r1.setAirline("CrazyAir");
		r1.setArrivalDate("31/10/2017 12:00");
		r1.setCabinclass(CabinClassEnum.B.name());
		r1.setDepartureAirportCode("FCO");
		r1.setDepartureDate("31/10/2017 10:00");
		r1.setDestinationAirportCode("LGW");
		r1.setPrice(145.5);
		ret.add(r1);
		
		CrazyAirResponse r2 = new CrazyAirResponse();
		r1.setAirline("CrazyAir");
		r1.setArrivalDate("30/10/2017 14:00");
		r1.setCabinclass(CabinClassEnum.E.name());
		r1.setDepartureAirportCode("FCO");
		r1.setDepartureDate("3/10/2017 12:00");
		r1.setDestinationAirportCode("LGW");
		r1.setPrice(115);
		ret.add(r2);
		
		CrazyAirResponse r3 = new CrazyAirResponse();
		r1.setAirline("CrazyAir");
		r1.setArrivalDate("31/10/2017 19:00");
		r1.setCabinclass(CabinClassEnum.B.name());
		r1.setDepartureAirportCode("LGW");
		r1.setDepartureDate("31/10/2017 17:00");
		r1.setDestinationAirportCode("FCO");
		r1.setPrice(145.5);
		ret.add(r3);
		
		CrazyAirResponse r4 = new CrazyAirResponse();
		r1.setAirline("CrazyAirResponse");
		r1.setArrivalDate("31/10/2017 08:00");
		r1.setCabinclass(CabinClassEnum.E.name());
		r1.setDepartureAirportCode("FCO");
		r1.setDepartureDate("31/10/2017 4:30:00");
		r1.setDestinationAirportCode("LGW");
		r1.setPrice(145.5);
		ret.add(r4);
		
		return ret;
		
	}

}
