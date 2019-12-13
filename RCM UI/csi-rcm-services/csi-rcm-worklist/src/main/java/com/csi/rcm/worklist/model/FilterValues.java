package com.csi.rcm.worklist.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author Kasun
 * @version 1.0
 * @since 2018/01/26
 *
 */
@Entity
@Table(name = "filter_value")
public class FilterValues extends BaseModel {

//	@NotBlank(message="Filter name is required")
	@Column(name = "filter_name")
	private String name;

//	@NotBlank(message="Filter id is required")
	@Column(name = "filter_id")
	private String filterId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_from")
	private Date dateFrom;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_to")
	private Date dateTo;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "claim_filter")
	private ClaimFilter claimFilter;

	public FilterValues() {
		
	}
	
	public FilterValues(Long id) {
		super();
		super.setId(id);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFilterId() {
		return filterId;
	}

	public void setFilterId(String filterId) {
		this.filterId = filterId;
	}

	public ClaimFilter getClaimFilter() {
		return claimFilter;
	}

	public void setClaimFilter(ClaimFilter claimFilter) {
		this.claimFilter = claimFilter;
	}
	

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((filterId == null) ? 0 : filterId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		FilterValues other = (FilterValues) obj;
		if (filterId == null) {
			if (other.filterId != null)
				return false;
		} else if (!filterId.equals(other.filterId))
			return false;
		return true;
	}

	
}
