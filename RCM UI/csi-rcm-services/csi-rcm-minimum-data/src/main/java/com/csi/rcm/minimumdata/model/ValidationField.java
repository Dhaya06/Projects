package com.csi.rcm.minimumdata.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.csi.rcm.minimumdata.util.validation.NotNullDependField;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author Kasun
 * @version 1.0
 * @since 2018/01/23
 *
 */
@Entity
@Table(name="validation_field")
@NotNullDependField.List({
	@NotNullDependField(
        fieldName = "mandatory",
        expectedValue="true",
        dependFieldName = "message",message="Message is required")
})
public class ValidationField {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull(message="Field Name is required")
	@Pattern(regexp="[a-zA-Z]*",message="Field Name should be alpha and without stapces")
	@Column(name="field_name",updatable=false)
	private String fieldName;
	
	@Column(name="mandatory")
	private Boolean mandatory = Boolean.FALSE;
	
	@Column(name="message")
	private String message;
	
	@Column(name="allowable_values")
	@ElementCollection
	private List<String> allowableValues;
	
	@Column(name="system_field")
	private Boolean systemField;
	
	@NotNull(message="Field Type is required")
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="field_type",nullable=false)
	private FieldType type;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="system_validation_class")
	private ValidationClass systemValidateionClass;

	@JsonIgnore
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="additional_validation_class")
	private ValidationClass additionalValidateionClass;

	@JsonIgnore
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="attachment_validation_class")
	private ValidationClass attachmentValidateionClass;
	
	
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

	public ValidationClass getSystemValidateionClass() {
		return systemValidateionClass;
	}

	public void setSystemValidateionClass(ValidationClass systemValidateionClass) {
		this.systemValidateionClass = systemValidateionClass;
	}

	public ValidationClass getAdditionalValidateionClass() {
		return additionalValidateionClass;
	}

	public void setAdditionalValidateionClass(ValidationClass additionalValidateionClass) {
		this.additionalValidateionClass = additionalValidateionClass;
	}

	public ValidationClass getAttachmentValidateionClass() {
		return attachmentValidateionClass;
	}

	public void setAttachmentValidateionClass(ValidationClass attachmentValidateionClass) {
		this.attachmentValidateionClass = attachmentValidateionClass;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ValidationField other = (ValidationField) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
