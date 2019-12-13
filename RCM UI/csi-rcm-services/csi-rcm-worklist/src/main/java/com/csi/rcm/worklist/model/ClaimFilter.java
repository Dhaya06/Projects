package com.csi.rcm.worklist.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.csi.rcm.worklist.util.validation.UniqueList;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author Kasun
 * @version 1.0
 * @since 2018/01/26
 *
 */
@Entity
@Table(name="claim_filter")
public class ClaimFilter extends BaseModel implements Comparable<ClaimFilter>{

	@NotNull(message="Filter Type is required")
	@ManyToOne
	@JoinColumn(name="filter_type")
	private FilterType filterType;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="work_list")
	private WorkList workList;
	
	@Valid
//	@NotEmpty(message="No filter values supplied")
//	@UniqueList(fieldToCheckUnique="filterId")
	@OneToMany(mappedBy="claimFilter",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<FilterValues> filterValues;
	
	@NotNull(message="Order is required")
	@Min(value=1,message="Order value cannot be less than 1")
	@Column(name="filter_order")
	private Integer order;

	public Set<FilterValues> getFilterValues() {
		System.out.println(filterType.getName());
		System.out.println(filterValues.size());
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

	@Override
	public int compareTo(ClaimFilter filter) {
		return this.order.compareTo(filter.order);
	}
	
}
