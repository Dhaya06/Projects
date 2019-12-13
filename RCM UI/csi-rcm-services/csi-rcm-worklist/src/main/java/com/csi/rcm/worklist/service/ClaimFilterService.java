package com.csi.rcm.worklist.service;

import java.util.Collection;
import java.util.List;

import com.csi.rcm.worklist.model.ClaimFilter;

public interface ClaimFilterService {

	public List<ClaimFilter> removeDuplicateAndreSort(Collection<ClaimFilter> filters);
	
}
