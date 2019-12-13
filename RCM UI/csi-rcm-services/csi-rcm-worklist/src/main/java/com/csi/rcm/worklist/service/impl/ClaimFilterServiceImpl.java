package com.csi.rcm.worklist.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.csi.rcm.worklist.model.ClaimFilter;
import com.csi.rcm.worklist.service.ClaimFilterService;

@Service
public class ClaimFilterServiceImpl implements ClaimFilterService {

	@Override
	public List<ClaimFilter> removeDuplicateAndreSort(Collection<ClaimFilter> filters) {
		Set<ClaimFilter> uniqueFilters =  new HashSet<>(filters);
		List<ClaimFilter> sortedFilters =  new ArrayList<>();
		sortedFilters.addAll(uniqueFilters);
		Collections.sort(sortedFilters);
		return sortedFilters;
	}

}
