package com.csi.vidaplus.rcm.claim.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "patient")
public class Patient extends BaseEntity {

	@ApiModelProperty("Patient id defined in the HIS system")
	@Column(name = "patient_id")
	private String patientId;
	@ApiModelProperty("Patient id defined in the HIS system")
	@Column(name = "member_id")
	private String memberId;
	@Column(name = "patient_name")
	private String patientName;
	@Temporal(TemporalType.DATE)
	@Column(name = "dob")
	private Date dob;
	@Column(name = "gender")
	private String gender;
	@Column(name = "patientIdentityNo")
	private String patientIdentityNo;

	@JsonIgnore
	@OneToOne
	private Claim claim;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPatientIdentityNo() {
		return patientIdentityNo;
	}

	public void setPatientIdentityNo(String patientIdentityNo) {
		this.patientIdentityNo = patientIdentityNo;
	}

	public Claim getClaim() {
		return claim;
	}

	public void setClaim(Claim claim) {
		this.claim = claim;
	}
}
