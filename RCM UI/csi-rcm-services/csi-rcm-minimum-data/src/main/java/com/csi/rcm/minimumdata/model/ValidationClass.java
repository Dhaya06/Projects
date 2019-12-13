package com.csi.rcm.minimumdata.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.csi.rcm.minimumdata.service.ValidationClassService;
import com.csi.rcm.minimumdata.util.validation.Unique;

/**
 * 
 * @author Kasun
 * @version 1.0
 * @since 2018/01/23
 *
 */
@Entity
@Table(name = "validation_class")
@Unique(service = ValidationClassService.class,fieldName="className", message = "Class Name must be unique")
public class ValidationClass {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull(message = "Class name is required")
	@Pattern(regexp="[a-zA-Z]*",message="Class Name should be alpha and without stapces")
	@Column(name = "class_name",unique=true,updatable=false)
	private String className;

	@Valid
	@OneToMany(mappedBy = "systemValidateionClass", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ValidationField> systemDefinedFields;

	@Valid
	@OneToMany(mappedBy = "additionalValidateionClass", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ValidationField> additionalFields;

	@Valid
	@OneToMany(mappedBy = "attachmentValidateionClass", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ValidationField> attachments;

	public ValidationClass() {}
	
	public ValidationClass(Long id) {
		this.id = id;
	}
	
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
		ValidationClass other = (ValidationClass) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
