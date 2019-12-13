package csi.vidaplus.rcm.datavalidation.model;

import java.util.Date;
import java.util.List;

public class Encounter extends BaseModel {

	private String hospitalGroupId;
	private String invoiceNo; 
	private String encounterId;
	private Date invoiceDateTime;
	
	private Patient patient;
	
	private String companyId;
	private String payerId;
	private Double companyShare;

	private String clinicId;
	private String doctorId;
	private String facilityId;

	private String specialityId;
	private String transferedFromFacilityId;
	private String transferedToFacilityId;
	private Double invoiceGross;
	private Double invoiceNet;
	private Double patientShare;
	private Boolean patientPaid;

	private String visitType;
	private String department;
	private String appointmentNo;
	private String chiefComplaint;
	private String pregnancyLMP;
	private String estimatedLengthOfStay;
	private String expectedDateOfAdmission;
	private String bloodPressure;
	private String pulse;
	private String vitalSignId;

	private String approvalNo;
	private String encounterType;
	private String encounterStartType;
	private String encounterEndType;

	private Date serviceStartTime;
	private Date serviceEndTime;

	private String insuranceMemberId;
	private String memberRelation;

	private String memberRelationTo;
	private String patientIdentityNo;
	private String remarks;

	private List<EncounterDiagnosis> encounterDiagnosis;
	
	private List<EncounterActivity> encounterActivities;

	public String getHospitalGroupId() {
		return hospitalGroupId;
	}

	public void setHospitalGroupId(String hospitalGroupId) {
		this.hospitalGroupId = hospitalGroupId;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getEncounterId() {
		return encounterId;
	}

	public void setEncounterId(String encounterId) {
		this.encounterId = encounterId;
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

	public Double getInvoiceGross() {
		return invoiceGross;
	}

	public void setInvoiceGross(Double invoiceGross) {
		this.invoiceGross = invoiceGross;
	}

	public Double getInvoiceNet() {
		return invoiceNet;
	}

	public void setInvoiceNet(Double invoiceNet) {
		this.invoiceNet = invoiceNet;
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

	public String getAppointmentNo() {
		return appointmentNo;
	}

	public void setAppointmentNo(String appointmentNo) {
		this.appointmentNo = appointmentNo;
	}

	public String getChiefComplaint() {
		return chiefComplaint;
	}

	public void setChiefComplaint(String chiefComplaint) {
		this.chiefComplaint = chiefComplaint;
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

	public String getVitalSignId() {
		return vitalSignId;
	}

	public void setVitalSignId(String vitalSignId) {
		this.vitalSignId = vitalSignId;
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

	public String getInsuranceMemberId() {
		return insuranceMemberId;
	}

	public void setInsuranceMemberId(String insuranceMemberId) {
		this.insuranceMemberId = insuranceMemberId;
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

	public String getPatientIdentityNo() {
		return patientIdentityNo;
	}

	public void setPatientIdentityNo(String patientIdentityNo) {
		this.patientIdentityNo = patientIdentityNo;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public List<EncounterDiagnosis> getEncounterDiagnosis() {
		return encounterDiagnosis;
	}

	public void setEncounterDiagnosis(List<EncounterDiagnosis> encounterDiagnosis) {
		this.encounterDiagnosis = encounterDiagnosis;
	}

	public List<EncounterActivity> getEncounterActivities() {
		return encounterActivities;
	}

	public void setEncounterActivities(List<EncounterActivity> encounterActivities) {
		this.encounterActivities = encounterActivities;
	}

}
	

