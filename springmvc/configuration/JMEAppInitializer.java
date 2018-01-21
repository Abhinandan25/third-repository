package com.jme.springmvc.configuration;
import javax.servlet.Filter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.jme.springmvc.filter.CORSFilter;

public class JMEAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { JMEAppConfig.class };
	}
 
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}
 
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
	 @Override
	    protected Filter[] getServletFilters() {
	        Filter [] singleton = { new CORSFilter()};
	        return singleton;
	    }

}
