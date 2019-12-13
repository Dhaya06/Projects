package csi.vidaplus.rcm.dataimport.model;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class DoctorNotes extends BaseModel {

	@ApiModelProperty("Doctor Notes id defined in the HIS system")
	private String doctorNotesId;
	
	@ApiModelProperty("Doctor Name defined in the HIS system")
	private String doctorName;
	
	@ApiModelProperty("Doctor Notes defined in the HIS system")
	private String doctorNotes;
	
	@ApiModelProperty("Inspected Date Time defined in the HIS system")
	private Date inspectedDateTime;
	
	@ApiModelProperty(hidden=true)
	private String encounterId;

	public String getDoctorNotesId() {
		return doctorNotesId;
	}

	public void setDoctorNotesId(String doctorNotesId) {
		this.doctorNotesId = doctorNotesId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorNotes() {
		return doctorNotes;
	}

	public void setDoctorNotes(String doctorNotes) {
		this.doctorNotes = doctorNotes;
	}

	public Date getInspectedDateTime() {
		return inspectedDateTime;
	}

	public void setInspectedDateTime(Date inspectedDateTime) {
		this.inspectedDateTime = inspectedDateTime;
	}

	public String getEncounterId() {
		return encounterId;
	}

	public void setEncounterId(String encounterId) {
		this.encounterId = encounterId;
	}
	
}
