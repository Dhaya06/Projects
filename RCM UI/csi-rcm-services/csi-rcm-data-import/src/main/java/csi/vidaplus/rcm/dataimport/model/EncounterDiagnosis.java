package csi.vidaplus.rcm.dataimport.model;

import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Document(collection = "encounter_diagnosis")
@ApiModel(description="This model represent a diagnosis information in a claim")
public class EncounterDiagnosis extends BaseModel {

	@ApiModelProperty(value="Diagnosis Type",allowableValues="Principal,Secondary,Admitting")
	private String diagnosisType; // Principal,Secondary,Admitting
	@ApiModelProperty("ICD-xx diagnosis code")
	private String diagnosisCode; // ICD-10 code,
	private String remarks;
	private String description;
	
	@ApiModelProperty(hidden=true)
	private String encounterId;
	
	
	public String getDiagnosisType() {
		return diagnosisType;
	}

	public void setDiagnosisType(String diagnosisType) {
		this.diagnosisType = diagnosisType;
	}

	public String getDiagnosisCode() {
		return diagnosisCode;
	}

	public void setDiagnosisCode(String diagnosisCode) {
		this.diagnosisCode = diagnosisCode;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getEncounterId() {
		return encounterId;
	}

	public void setEncounterId(String encounterId) {
		this.encounterId = encounterId;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
