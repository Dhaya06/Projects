/*
package com.csi.vidaplus.rcm.claim.model;

import com.csi.vidaplus.rcm.claim.entity.*;

import java.util.Date;
import java.util.List;


public class Encounter extends BaseModel {

	private String hospitalGroupId;
	private String encounterId;
	private String referenceEncounterId;
	private Date invoiceDateTime;
	private Patient patient;
	private String companyId;
	private String payerId;
	private String policyType;
	private String policyNumber;
	private Double companyShare;
	private String clinicId;
	private String doctorId;
	private String facilityId;
	private String specialityId;
	private String transferedFromFacilityId;//
	private String transferedToFacilityId;
	private Double encounterGross;
	private Double encounterNet;
	private Double patientShare;
	private Boolean patientPaid;

	private String visitType;
	private String department;
	private String chiefComplaint;
	private String significant;
	private String otherConditionsDiagnosis;
	private String pregnancyLMP;
	private String estimatedLengthOfStay;
	private String expectedDateOfAdmission;
	private String bloodPressure;
	private String pulse;
	private String temperature;
	private String approvalNo;
	private String encounterType;
	private String encounterStartType;
	private String encounterEndType;
	private Date serviceStartTime;
	private Date serviceEndTime;
	private String memberRelation; // - Principal,Spouse,Child,Parent,Other
	private String memberRelationTo;
	private String remarks;
	private List<ClaimDiagnosis> encounterDiagnosis;
	private List<EncounterInvoice> encounterInvoices;
	private List<DoctorNotes> doctorNotes;
	private List<NurseNotes> nurseNotes;

	public String getHospitalGroupId() {
		return hospitalGroupId;
	}

	public void setHospitalGroupId(String hospitalGroupId) {
		this.hospitalGroupId = hospitalGroupId;
	}

	public String getEncounterId() {
		return encounterId;
	}

	public void setEncounterId(String encounterId) {
		this.encounterId = encounterId;
	}

	public String getReferenceEncounterId() {
		return referenceEncounterId;
	}

	public void setReferenceEncounterId(String referenceEncounterId) {
		this.referenceEncounterId = referenceEncounterId;
	}

	public Date getInvoiceDateTime() {
		return invoiceDateTime;
	}

	public void setInvoiceDateTime(Date invoiceDateTime) {
		this.invoiceDateTime = invoiceDateTime;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getPayerId() {
		return payerId;
	}

	public void setPayerId(String payerId) {
		this.payerId = payerId;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public Double getCompanyShare() {
		return companyShare;
	}

	public void setCompanyShare(Double companyShare) {
		this.companyShare = companyShare;
	}

	public String getClinicId() {
		return clinicId;
	}

	public void setClinicId(String clinicId) {
		this.clinicId = clinicId;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}

	public String getSpecialityId() {
		return specialityId;
	}

	public void setSpecialityId(String specialityId) {
		this.specialityId = specialityId;
	}

	public String getTransferedFromFacilityId() {
		return transferedFromFacilityId;
	}

	public void setTransferedFromFacilityId(String transferedFromFacilityId) {
		this.transferedFromFacilityId = transferedFromFacilityId;
	}

	public String getTransferedToFacilityId() {
		return transferedToFacilityId;
	}

	public void setTransferedToFacilityId(String transferedToFacilityId) {
		this.transferedToFacilityId = transferedToFacilityId;
	}

	public Double getEncounterGross() {
		return encounterGross;
	}

	public void setEncounterGross(Double encounterGross) {
		this.encounterGross = encounterGross;
	}

	public Double getEncounterNet() {
		return encounterNet;
	}

	public void setEncounterNet(Double encounterNet) {
		this.encounterNet = encounterNet;
	}

	public Double getPatientShare() {
		return patientShare;
	}

	public void setPatientShare(Double patientShare) {
		this.patientShare = patientShare;
	}

	public Boolean getPatientPaid() {
		return patientPaid;
	}

	public void setPatientPaid(Boolean patientPaid) {
		this.patientPaid = patientPaid;
	}

	public String getVisitType() {
		return visitType;
	}

	public void setVisitType(String visitType) {
		this.visitType = visitType;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getChiefComplaint() {
		return chiefComplaint;
	}

	public void setChiefComplaint(String chiefComplaint) {
		this.chiefComplaint = chiefComplaint;
	}

	public String getSignificant() {
		return significant;
	}

	public void setSignificant(String significant) {
		this.significant = significant;
	}

	public String getOtherConditionsDiagnosis() {
		return otherConditionsDiagnosis;
	}

	public void setOtherConditionsDiagnosis(String otherConditionsDiagnosis) {
		this.otherConditionsDiagnosis = otherConditionsDiagnosis;
	}

	public String getPregnancyLMP() {
		return pregnancyLMP;
	}

	public void setPregnancyLMP(String pregnancyLMP) {
		this.pregnancyLMP = pregnancyLMP;
	}

	public String getEstimatedLengthOfStay() {
		return estimatedLengthOfStay;
	}

	public void setEstimatedLengthOfStay(String estimatedLengthOfStay) {
		this.estimatedLengthOfStay = estimatedLengthOfStay;
	}

	public String getExpectedDateOfAdmission() {
		return expectedDateOfAdmission;
	}

	public void setExpectedDateOfAdmission(String expectedDateOfAdmission) {
		this.expectedDateOfAdmission = expectedDateOfAdmission;
	}

	public String getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public String getPulse() {
		return pulse;
	}

	public void setPulse(String pulse) {
		this.pulse = pulse;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getApprovalNo() {
		return approvalNo;
	}

	public void setApprovalNo(String approvalNo) {
		this.approvalNo = approvalNo;
	}

	public String getEncounterType() {
		return encounterType;
	}

	public void setEncounterType(String encounterType) {
		this.encounterType = encounterType;
	}

	public String getEncounterStartType() {
		return encounterStartType;
	}

	public void setEncounterStartType(String encounterStartType) {
		this.encounterStartType = encounterStartType;
	}

	public String getEncounterEndType() {
		return encounterEndType;
	}

	public void setEncounterEndType(String encounterEndType) {
		this.encounterEndType = encounterEndType;
	}

	public Date getServiceStartTime() {
		return serviceStartTime;
	}

	public void setServiceStartTime(Date serviceStartTime) {
		this.serviceStartTime = serviceStartTime;
	}

	public Date getServiceEndTime() {
		return serviceEndTime;
	}

	public void setServiceEndTime(Date serviceEndTime) {
		this.serviceEndTime = serviceEndTime;
	}

	public String getMemberRelation() {
		return memberRelation;
	}

	public void setMemberRelation(String memberRelation) {
		this.memberRelation = memberRelation;
	}

	public String getMemberRelationTo() {
		return memberRelationTo;
	}

	public void setMemberRelationTo(String memberRelationTo) {
		this.memberRelationTo = memberRelationTo;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public List<ClaimDiagnosis> getEncounterDiagnosis() {
		return encounterDiagnosis;
	}

	public void setEncounterDiagnosis(List<ClaimDiagnosis> encounterDiagnosis) {
		this.encounterDiagnosis = encounterDiagnosis;
	}

	public List<EncounterInvoice> getEncounterInvoices() {
		return encounterInvoices;
	}

	public void setEncounterInvoices(List<EncounterInvoice> encounterInvoices) {
		this.encounterInvoices = encounterInvoices;
	}

	public List<DoctorNotes> getDoctorNotes() {
		return doctorNotes;
	}

	public void setDoctorNotes(List<DoctorNotes> doctorNotes) {
		this.doctorNotes = doctorNotes;
	}

	public List<NurseNotes> getNurseNotes() {
		return nurseNotes;
	}

	public void setNurseNotes(List<NurseNotes> nurseNotes) {
		this.nurseNotes = nurseNotes;
	}
}
*/
