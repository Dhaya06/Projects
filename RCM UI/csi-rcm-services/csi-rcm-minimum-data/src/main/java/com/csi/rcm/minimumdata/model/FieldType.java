package com.csi.rcm.minimumdata.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 
 * @author Kasun
 * @version 1.0
 * @since 2018/01/23
 *
 */
@Entity
@Table(name="field_type")
public class FieldType {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull(message="Name is required")
	@Pattern(regexp="[a-zA-Z]*",message="Name should be alpha and without stapces")
	@Column(name="type_name")
	private String name;

	public FieldType() {}
	
	public FieldType(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
