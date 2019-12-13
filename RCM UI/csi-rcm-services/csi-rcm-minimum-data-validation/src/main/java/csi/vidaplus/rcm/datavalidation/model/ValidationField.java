package csi.vidaplus.rcm.datavalidation.model;

import java.util.List;

public class ValidationField {

	private String field;
	private String message;
	private Boolean isMandotory;
	private List<String> allowableValues;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Boolean getIsMandotory() {
		return isMandotory;
	}

	public void setIsMandotory(Boolean isMandotory) {
		this.isMandotory = isMandotory;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getAllowableValues() {
		return allowableValues;
	}

	public void setAllowableValues(List<String> allowableValues) {
		this.allowableValues = allowableValues;
	}

}
