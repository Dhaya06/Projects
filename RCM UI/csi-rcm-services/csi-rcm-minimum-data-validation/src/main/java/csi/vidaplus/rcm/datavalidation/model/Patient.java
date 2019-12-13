package csi.vidaplus.rcm.datavalidation.model;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class Patient {

	@ApiModelProperty("Patient id defined in the HIS system")
	private String patientId;
	@ApiModelProperty("Patient id defined in the HIS system")
	private String memberId;
	private String patientName;
	private Date dob;
	private String gender;

	
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

}
