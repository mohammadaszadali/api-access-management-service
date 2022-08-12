package com.dtag.bmp.service.api.access_management.util;

import java.util.Random;
import java.util.UUID;

import com.fasterxml.uuid.Generators;

public class IdGenerators {
	
	
	public String createId()
	{
	UUID uuid1 = Generators.timeBasedGenerator().generate();
	Long cid1 = uuid1.node();
	return cid1.toString();
		
	}
	public int userId() {
		Random r = new Random( System.currentTimeMillis() );
	    int contactId= ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
		return contactId;
	}
	
		
		
		
	

}
