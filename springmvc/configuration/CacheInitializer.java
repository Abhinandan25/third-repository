package com.jme.springmvc.configuration;

import javax.annotation.PostConstruct;

public class CacheInitializer {

	@PostConstruct
	public void cacheDataSet()
	{
		System.out.println("inside cache....");
		
	}
}
