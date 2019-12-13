package csi.vidaplus.rcm.datavalidation.model;


public class EncounterDiagnosis extends BaseModel {

	private String diagnosisType; // Principal,Secondary,Admitting
	private String diagnosisCode; // ICD-10 code,
	private String remarks;
	
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
	
}
