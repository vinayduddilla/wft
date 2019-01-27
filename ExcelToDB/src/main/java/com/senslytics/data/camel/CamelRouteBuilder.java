package com.senslytics.data.camel;

import org.apache.camel.builder.RouteBuilder;

public class CamelRouteBuilder extends RouteBuilder{

	public void configure() throws Exception{
		CamelProcessor camelProcessor = new CamelProcessor();
		from("file:C:\\files?noop=true")
		.process(camelProcessor)
		.to("file:C:\\files\\BackUpFiles");
	}

}
