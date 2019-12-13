package com.csi.vidaplus.rcm.claim.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class DateRangeConverter implements Converter<String, Date> {

	private Map<String, String> dateFormatmap = new HashMap<>();
	
	@PostConstruct
	private void init() {
		dateFormatmap.put("\\d{4}-\\d{2}-\\d{2}", "yyyy-MM-dd");
		dateFormatmap.put("\\d{4}/\\d{2}/\\d{2}", "yyyy/MM/dd");
		dateFormatmap.put("\\d{2}/\\d{2}/\\d{4}", "dd/MM/YYYY");
		dateFormatmap.put("\\d{2}-\\d{2}-\\d{4}", "dd-MM-YYYY");
	}
	
	@Override
	public Date convert(String source) {
		
		SimpleDateFormat formta = new SimpleDateFormat("yyyy/MM/dd");
		Set<String> regexFormats = dateFormatmap.keySet();
		
		try {
			for (String regexFormat : regexFormats) {
				if (source.matches(regexFormat)) {
					return formta.parse(source);
				}
			}
		} catch (ParseException e) {
			throw new IllegalArgumentException("Worng date value "+source+ " Expected format "+regexFormats);
		}
		throw new IllegalArgumentException("Worng date value "+source+ " Expected format "+regexFormats);
	}

}
