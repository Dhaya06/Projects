package csi.vidaplus.rcm.datavalidation.model;

import java.util.List;

public class ValidationClass {

	private String className;

	private List<ValidationField> systemDefinedFields;
	private List<ValidationField> additionalFields;
	private List<ValidationField> attachments;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<ValidationField> getSystemDefinedFields() {
		return systemDefinedFields;
	}

	public void setSystemDefinedFields(List<ValidationField> systemDefinedFields) {
		this.systemDefinedFields = systemDefinedFields;
	}

	public List<ValidationField> getAdditionalFields() {
		return additionalFields;
	}

	public void setAdditionalFields(List<ValidationField> additionalFields) {
		this.additionalFields = additionalFields;
	}

	public List<ValidationField> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<ValidationField> attachments) {
		this.attachments = attachments;
	}

}
