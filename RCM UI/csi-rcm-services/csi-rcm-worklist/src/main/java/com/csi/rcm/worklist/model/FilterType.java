package com.csi.rcm.worklist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Kasun
 * @version 1.0
 * @since 2018/01/26
 *
 */
@Entity
@Table(name = "filter_type")
public class FilterType extends BaseModel {

	@NotNull(message="Filter Type is required")
	@Column(name = "filter_type_name")
	private String name;

	@Column(name="field_name")
	private String filedName;
	
	public FilterType() {}
	
	public FilterType(Long id) {
		super();
		super.setId(id);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFiledName() {
		return filedName;
	}

	public void setFiledName(String filedName) {
		this.filedName = filedName;
	}

	
}
