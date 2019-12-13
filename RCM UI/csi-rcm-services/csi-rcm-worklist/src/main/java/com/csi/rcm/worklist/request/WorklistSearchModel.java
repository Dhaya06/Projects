package com.csi.rcm.worklist.request;

import java.util.Date;
import java.util.List;

public class WorklistSearchModel {

	private String name;
	private List<String> facilities;
	private List<String> insuranceGroup;
	private List<String> company;
	private Date dateFrom;
	private Date dateTo;
	private List<String> assignee;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getFacilities() {
		return facilities;
	}

	public void setFacilities(List<String> facilities) {
		this.facilities = facilities;
	}

	public List<String> getInsuranceGroup() {
		return insuranceGroup;
	}

	public void setInsuranceGroup(List<String> insuranceGroup) {
		this.insuranceGroup = insuranceGroup;
	}

	public List<String> getCompany() {
		return company;
	}

	public void setCompany(List<String> company) {
		this.company = company;
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

	public List<String> getAssignee() {
		return assignee;
	}

	public void setAssignee(List<String> assignee) {
		this.assignee = assignee;
	}

}
