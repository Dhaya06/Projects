package com.csi.rcm.worklist.converters;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@ConfigurationProperties("csi.rcm.worklist")
@Component
public class DateToStringConverter implements Converter<Date, String>{

	private String dateformat;
	
	private SimpleDateFormat dateFormatter ;
	
	@PostConstruct
	private void init() {
		dateFormatter = new SimpleDateFormat(dateformat);
	}
	
	@Override
	public String convert(Date source) {
		return dateFormatter.format(source);
	}

	public String getDateformat() {
		return dateformat;
	}

	public void setDateformat(String dateformat) {
		this.dateformat = dateformat;
	}

	public SimpleDateFormat getDateFormatter() {
		return dateFormatter;
	}

	public void setDateFormatter(SimpleDateFormat dateFormatter) {
		this.dateFormatter = dateFormatter;
	}

}


