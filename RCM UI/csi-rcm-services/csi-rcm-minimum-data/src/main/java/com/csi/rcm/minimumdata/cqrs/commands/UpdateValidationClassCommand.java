package com.csi.rcm.minimumdata.cqrs.commands;

import java.util.List;

import com.csi.microservices.persistence.cqrs.BaseCqrsCommand;
import com.csi.rcm.minimumdata.model.ValidationField;

/**
 * ValidationClass update command class
 * 
 * @author Kasun
 * @version 1.0
 * @since 2018/01/23
 */
public class UpdateValidationClassCommand extends BaseCqrsCommand<String> {

	private Long id;

	private String className;

	private List<ValidationField> systemDefinedFields;

	private List<ValidationField> additionalFields;

	private List<ValidationField> attachments;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
