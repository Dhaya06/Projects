package csi.vidaplus.rcm.dataimport.model;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class NurseNotes extends BaseModel {

	@ApiModelProperty("Nurse Notes id defined in the HIS system")
	private String nurseNotesId;
	
	@ApiModelProperty("Nurse Name defined in the HIS system")
	private String nurseName;
	
	@ApiModelProperty("Nurse Notes defined in the HIS system")
	private String nurseNotes;
	
	@ApiModelProperty("Inspected Date Time defined in the HIS system")
	private Date inspectedDateTime;
	
	@ApiModelProperty(hidden=true)
	private String encounterId;

	public String getNurseNotesId() {
		return nurseNotesId;
	}

	public void setNurseNotesId(String nurseNotesId) {
		this.nurseNotesId = nurseNotesId;
	}

	public String getNurseName() {
		return nurseName;
	}

	public void setNurseName(String nurseName) {
		this.nurseName = nurseName;
	}

	public String getNurseNotes() {
		return nurseNotes;
	}

	public void setNurseNotes(String nurseNotes) {
		this.nurseNotes = nurseNotes;
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
