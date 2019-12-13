package com.csi.rcm.worklist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.csi.rcm.worklist.converters.DateRangeConverter;
import com.csi.rcm.worklist.converters.DateToStringConverter;
import com.csi.rcm.worklist.converters.FilterValuesConverter;

@Configuration
@ComponentScan
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

	@Autowired
	private FilterValuesConverter filterValueConverter;
	
	@Autowired
	private DateRangeConverter dateRaneConverter;
	
	@Autowired
	private DateToStringConverter dateToStringConverter;
	
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(filterValueConverter);
		registry.addConverter(dateRaneConverter);
		registry.addConverter(dateToStringConverter);
	}

}
