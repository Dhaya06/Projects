package com.csi.rcm.worklist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * @author Kasun
 * @version 1.0
 * @since 2018/01/26
 *
 */
@Entity
@Table(name="staff_member")
public class StaffMember extends BaseModel{

	@Column(name="staff_memeber_name")
	private String name;
	
	public StaffMember() {}
	
	public StaffMember(Long id) {
		super();
		super.setId(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
