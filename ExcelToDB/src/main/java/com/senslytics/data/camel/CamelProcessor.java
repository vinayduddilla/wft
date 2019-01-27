package com.senslytics.data.camel;

import java.io.File;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import com.senslytics.data.manager.util.ExcelFileReader;

public class CamelProcessor implements Processor{

	public void process(Exchange exchange) {
		try {
		File file = exchange.getIn().getBody(File.class);
		ExcelFileReader.readFile(file.getAbsolutePath());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
