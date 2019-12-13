package com.csi.rcm.worklist.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.csi.rcm.worklist.model.FilterValues;

@Component
public class FilterValuesConverter implements Converter<String, FilterValues> {

	@Override
	public FilterValues convert(String source) {
		return new FilterValues(Long.parseLong(source));
	}

}
