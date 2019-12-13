package com.csi.vidaplus.rcm.claim.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.*;

/**
 * Created by Ahsan on 2/4/2018.
 */
@Entity
@Table(name = "claims")
public class Claim extends BaseEntity {

	// this is external claim id
	// @NotBlank(message="claim id is required")
	@Column(name = "encounter_id")
	private String encounterId;

	@Column(name = "reference_encounter_id")
	private String referenceEncounterId;

	@Column(name = "processed")
	private boolean processed;

	//@NotNull(message = "Claim Status is required")
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "claim_status")
	private ClaimStatus claimStatus;

	//@NotNull(message = "Claim Status is required")
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "claim_stage")
	private ClaimStage claimStage;

	// this contains the ids of staff members
	@ElementCollection(targetClass = Long.class)
	@Column(name = "process")
	private Set<Long> process;

	@ElementCollection(targetClass = Long.class)
	@Column(name = "review")
	private Set<Long> review;

	@ElementCollection(targetClass = Long.class)
	@Column(name = "submission")
	private Set<Long> submission;

	@ElementCollection(targetClass = Long.class)
	@Column(name = "reSubmission")
	private Set<Long> reSubmission;

	//@NotBlank(message = "invoice no is required")
	@Column(name = "invoice_no")
	private String invoiceNo; //

	// @NotNull(message="invoice date time is required")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "invoice_date_time")
	private Date invoiceDateTime;

	//@NotBlank(message = "payer id is required")
	@Column(name = "payerId")
	private String payerId;

	@Column(name = "policy_type")
	private String policyType;

	@Column(name = "policy_number")
	private String policyNumber;

	// @NotBlank(message="hospital group id is required")
	@Column(name = "hospital_group_id")
	private String hospitalGroupId;

	@Column(name = "clinic_id")
	private String clinicId;
	@Column(name = "doctor_id")
	private String doctorId;
	@Column(name = "facility_id")
	private String facilityId;

	@Column(name = "company_id")
	private String companyId;

	@Column(name = "speciality_id")
	private String specialityId;// Urology,Cardiology

	@Column(name = "transferred_from_facility_id")
	private String transferedFromFacilityId;//

	@Column(name = "transferred_to_facility_id")
	private String transferedToFacilityId;

	//@Min(value = 0)
	@Column(name = "encounter_gross_amount")
	private Double grossAmount;

	//@Min(value = 0)
	@Column(name = "encounter_net_amount")
	private Double netAmount;

	//@Min(value = 0)
	@Column(name = "encounter_discount")
	private Double discount;

	//@Min(value = 0)
	@Column(name = "encounter_company_share")
	private Double companyShare;

	//@Min(value = 0)
	@Column(name = "encounter_patient_share")
	private Double patientShare;

	@Column(name = "patient_paid")
	private Boolean patientPaid;

	@Column(name = "approval_no")
	private String approvalNo;

	@Column(name = "encounter_type")
	private String encounterType;

	//@NotBlank(message = "encounter start type is required")
	@Column(name = "encounter_start_type")
	private String encounterStartType;

	//@NotBlank(message = "encounter end type is required")
	@Column(name = "encounter_end_type")
	private String encounterEndType;

	// @NotNull(message="builder start time is required")
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "service_start_time")
	private Date serviceStartTime;

	// @NotNull(message="builder end time is required")
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "service_end_time")
	private Date serviceEndTime;

	// @NotBlank(message="member_relation is required")
	@Column(name = "member_relation")
	private String memberRelation; // - Principal,Spouse,Child,Parent,Other

	@Column(name = "member_relation_to")
	private String memberRelationTo;

	@Column(name = "company_approval_no")
	private String companyApprovalNo;

	@Column(name = "remarks")
	private String remarks;

	@Column(name = "visit_type")
	private String visitType;

	@Column(name = "department")
	private String department;

	@Column(name = "appointment_no")
	private String appointmentNo;

	@Column(name = "chief_complaint")
	private String chiefComplaint;

	@Column(name = "significant")
	private String significant ;

	@Column(name = "other_conditions_diagnosis")
	private String otherConditionsDiagnosis ;

	@Column(name = "pregnancy_lmp")
	private String pregnancyLMP;

	@Column(name = "estimated_length_stay")
	private String estimatedLengthOfStay;

	@Column(name = "expected_date_admission")
	private String expectedDateOfAdmission;

	@Column(name = "blood_pressure")
	private String bloodPressure;

	@Column(name = "pulse")
	private String pulse;

	@Column(name = "vital_sign_Id")
	private String vitalSignId;

	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "patient_id")
	private Patient patient;

	@Fetch(value = FetchMode.SELECT)
	@OneToMany(mappedBy = "claim", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DoctorNotes> doctorNotesList;

	@Fetch(value = FetchMode.SELECT)
	@OneToMany(mappedBy = "claim", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<NurseNotes> nurseNotesList;

	//@Valid
	//@NotEmpty(message = "At least one appointment is required for a claim")
	@Fetch(value = FetchMode.SELECT)
	@OneToMany(mappedBy = "claim", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Appointment> appointments;

	/*@Fetch(value = FetchMode.SELECT)
	@OneToMany(mappedBy = "claim", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Invoice> encounterInvoices;*/

	//@Valid
	//@NotEmpty(message = "At least one diagnosis is required for a claim")
	@Fetch(value = FetchMode.SELECT)
	@OneToMany(mappedBy = "claim", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ClaimDiagnosis> encounterDiagnosis;

	@Column(name = "tech_error_map",length =16777210 )
	private HashMap<String,List<String>> techErrorMap;

	@Column(name = "med_error_map",length =16777210 )
	//@ElementCollection(targetClass = String.class)
	private HashMap<String,List<String>> medErrorMap;

	@Column(name="claim_lable")
	private Integer claimLable;
	
	@Column(name="claim_lable_type")
	private Integer claimLableType;

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

	public boolean isProcessed() {
		return processed;
	}

	public void setProcessed(boolean processed) {
		this.processed = processed;
	}

	public ClaimStatus getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(ClaimStatus claimStatus) {
		this.claimStatus = claimStatus;
	}

	public Set<Long> getProcess() {
		return process;
	}

	public void setProcess(Set<Long> process) {
		this.process = process;
	}

	public Set<Long> getReview() {
		return review;
	}

	public void setReview(Set<Long> review) {
		this.review = review;
	}

	public Set<Long> getSubmission() {
		return submission;
	}

	public void setSubmission(Set<Long> submission) {
		this.submission = submission;
	}

	public Set<Long> getReSubmission() {
		return reSubmission;
	}

	public void setReSubmission(Set<Long> reSubmission) {
		this.reSubmission = reSubmission;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public Date getInvoiceDateTime() {
		return invoiceDateTime;
	}

	public void setInvoiceDateTime(Date invoiceDateTime) {
		this.invoiceDateTime = invoiceDateTime;
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

	public String getHospitalGroupId() {
		return hospitalGroupId;
	}

	public void setHospitalGroupId(String hospitalGroupId) {
		this.hospitalGroupId = hospitalGroupId;
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

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
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

	public Double getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(Double netAmount) {
		this.netAmount = netAmount;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getCompanyShare() {
		return companyShare;
	}

	public void setCompanyShare(Double companyShare) {
		this.companyShare = companyShare;
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

	public String getCompanyApprovalNo() {
		return companyApprovalNo;
	}

	public void setCompanyApprovalNo(String companyApprovalNo) {
		this.companyApprovalNo = companyApprovalNo;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public List<DoctorNotes> getDoctorNotesList() {
		return doctorNotesList;
	}

	public void setDoctorNotesList(List<DoctorNotes> doctorNotesList) {
		this.doctorNotesList = doctorNotesList;
	}

	public List<NurseNotes> getNurseNotesList() {
		return nurseNotesList;
	}

	public void setNurseNotesList(List<NurseNotes> nurseNotesList) {
		this.nurseNotesList = nurseNotesList;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public List<ClaimDiagnosis> getEncounterDiagnosis() {
		return encounterDiagnosis;
	}

	public void setEncounterDiagnosis(List<ClaimDiagnosis> encounterDiagnosis) {
		this.encounterDiagnosis = encounterDiagnosis;
	}

	public HashMap<String, List<String>> getTechErrorMap() {
		return techErrorMap;
	}

	public void setTechErrorMap(HashMap<String, List<String>> techErrorMap) {
		this.techErrorMap = techErrorMap;
	}

	public HashMap<String, List<String>> getMedErrorMap() {
		return medErrorMap;
	}

	public void setMedErrorMap(HashMap<String, List<String>> medErrorMap) {
		this.medErrorMap = medErrorMap;
	}

	public Integer getClaimLable() {
		return claimLable;
	}

	public void setClaimLable(Integer claimLable) {
		this.claimLable = claimLable;
	}

	public Integer getClaimLableType() {
		return claimLableType;
	}

	public void setClaimLableType(Integer claimLableType) {
		this.claimLableType = claimLableType;
	}

	public ClaimStage getClaimStage() {
		return claimStage;
	}

	public void setClaimStage(ClaimStage claimStage) {
		this.claimStage = claimStage;
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

	public Double getGrossAmount() {
		return grossAmount;
	}

	public void setGrossAmount(Double grossAmount) {
		this.grossAmount = grossAmount;
	}

	/*public List<Invoice> getEncounterInvoices() {
		return encounterInvoices;
	}

	public void setEncounterInvoices(List<Invoice> encounterInvoices) {
		this.encounterInvoices = encounterInvoices;
	}*/
}
