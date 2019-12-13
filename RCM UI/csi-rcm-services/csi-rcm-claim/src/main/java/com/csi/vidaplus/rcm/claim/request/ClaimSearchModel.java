package com.csi.vidaplus.rcm.claim.request;

import java.util.Date;
import java.util.List;

public class ClaimSearchModel {

	private List<String> facilities;
	private List<String> claimLabels;
	private List<String> claimLabelTypes;
	private List<String> claimStatus;
	private List<String> insuranceGroups;
	private List<String> companyIDs;
	private List<String> companyNames;
	private List<String> memberID;
	private List<String> encounterTypes;
	private List<String> clinics;
	private List<String> assignees;
	private List<String> policies;
	
	private Date dateFrom;
	private Date dateTo;
	private String dateFilterField;

	public List<String> getFacilities() {
		return facilities;
	}

	public void setFacilities(List<String> facilities) {
		this.facilities = facilities;
	}

	public List<String> getClaimLabels() {
		return claimLabels;
	}

	public void setClaimLabels(List<String> claimLabels) {
		this.claimLabels = claimLabels;
	}

	public List<String> getClaimLabelTypes() {
		return claimLabelTypes;
	}

	public void setClaimLabelTypes(List<String> claimLabelTypes) {
		this.claimLabelTypes = claimLabelTypes;
	}

	public List<String> getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(List<String> claimStatus) {
		this.claimStatus = claimStatus;
	}

	public List<String> getInsuranceGroups() {
		return insuranceGroups;
	}

	public void setInsuranceGroups(List<String> insuranceGroups) {
		this.insuranceGroups = insuranceGroups;
	}

	public List<String> getCompanyIDs() {
		return companyIDs;
	}

	public void setCompanyIDs(List<String> companyIDs) {
		this.companyIDs = companyIDs;
	}

	public List<String> getCompanyNames() {
		return companyNames;
	}

	public void setCompanyNames(List<String> companyNames) {
		this.companyNames = companyNames;
	}

	public List<String> getMemberID() {
		return memberID;
	}

	public void setMemberID(List<String> memberID) {
		this.memberID = memberID;
	}


	public List<String> getEncounterTypes() {
		return encounterTypes;
	}

	public void setEncounterTypes(List<String> encounterTypes) {
		this.encounterTypes = encounterTypes;
	}

	public List<String> getClinics() {
		return clinics;
	}

	public void setClinics(List<String> clinics) {
		this.clinics = clinics;
	}


	public List<String> getAssignees() {
		return assignees;
	}

	public void setAssignees(List<String> assignees) {
		this.assignees = assignees;
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

	public String getDateFilterField() {
		return dateFilterField;
	}

	public void setDateFilterField(String dateFilterField) {
		this.dateFilterField = dateFilterField;
	}

	public List<String> getPolicies() {
		return policies;
	}

	public void setPolicies(List<String> policies) {
		this.policies = policies;
	}
	
}
