package com.senslytics.data.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelHelper {
	private static CamelHelper camelHelper;
	private static CamelContext context = null;
	
	public static synchronized CamelHelper getInstance() {
		if(camelHelper == null) 
			camelHelper = new CamelHelper();
		return camelHelper;
	}
	
	public CamelContext getCamelContext() {
		if(null == context) {
			context = new DefaultCamelContext();
		}
		return context;
	}
	
	public void buildRoute() throws Exception{
		CamelRouteBuilder camelRouteBuilder = new CamelRouteBuilder();
		if(null == context) {
			context = getCamelContext();
		}
		
		context.addRoutes(camelRouteBuilder);
		System.out.println("camel route builder : "+context.getRoutes());
	}
	
	public void camelBoot() throws Exception {
		System.out.println("Building rout");
		buildRoute();
		getCamelContext().start();
	}
	

}
