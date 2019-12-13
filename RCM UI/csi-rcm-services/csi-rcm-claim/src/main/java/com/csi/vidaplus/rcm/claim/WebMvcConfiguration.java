package com.csi.vidaplus.rcm.claim;

import com.csi.vidaplus.rcm.claim.converters.DateRangeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

	@Autowired
	private DateRangeConverter dateRaneConverter;
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(dateRaneConverter);
	}
}
