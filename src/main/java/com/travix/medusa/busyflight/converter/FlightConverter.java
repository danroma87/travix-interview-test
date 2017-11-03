package com.travix.medusa.busyflight.converter;

import java.util.Collection;
import java.util.List;


public interface FlightConverter< FROM , TO extends List<?> >
{
	
public TO convert ( FROM aFromObject );
}
