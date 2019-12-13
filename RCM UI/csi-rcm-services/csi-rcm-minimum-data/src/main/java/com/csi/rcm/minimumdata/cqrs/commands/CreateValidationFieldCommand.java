package com.csi.rcm.minimumdata.cqrs.commands;

import java.util.List;

import com.csi.microservices.persistence.cqrs.BaseCqrsCommand;
import com.csi.rcm.minimumdata.model.FieldType;

/**
 * ValidationField create command class
 * 
 * @author Kasun
 * @version 1.0
 * @since 2018/01/23
 */
public class CreateValidationFieldCommand extends BaseCqrsCommand<String> {

	private Long id;

	private String fieldName;
	
	private Boolean mandatory;

	private String message;

	private List<String> allowableValues;

	private Boolean systemField;

	private FieldType type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Boolean getMandatory() {
		return mandatory;
	}

	public void setMandatory(Boolean mandatory) {
		this.mandatory = mandatory;
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

	public Boolean getSystemField() {
		return systemField;
	}

	public void setSystemField(Boolean systemField) {
		this.systemField = systemField;
	}

	public FieldType getType() {
		return type;
	}

	public void setType(FieldType type) {
		this.type = type;
	}

	
}
