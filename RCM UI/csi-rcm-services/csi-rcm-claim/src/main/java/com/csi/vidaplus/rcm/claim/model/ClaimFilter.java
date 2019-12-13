package com.csi.vidaplus.rcm.claim.model;

import java.util.Objects;
import java.util.Set;

public class ClaimFilter extends BaseModel{

	private FilterType filterType;
	private WorkList workList;
	private Set<FilterValues> filterValues;
	private Integer order;

	public Set<FilterValues> getFilterValues() {
		return filterValues;
	}

	public void setFilterValues(Set<FilterValues> filterValues) {
		this.filterValues = filterValues;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public FilterType getFilterType() {
		return filterType;
	}

	public void setFilterType(FilterType filterType) {
		this.filterType = filterType;
	}

	public WorkList getWorkList() {
		return workList;
	}

	public void setWorkList(WorkList workList) {
		this.workList = workList;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof ClaimFilter) {
			ClaimFilter otherFilter = (ClaimFilter)obj;
			if(getId() == null && otherFilter.getId() == null) {
				return Objects.equals(filterType, otherFilter.filterType);
			}
			
			return super.equals(obj);
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		if(getId() == null) {
			return filterType.hashCode();
		}
		return super.hashCode();
	}
	
}
