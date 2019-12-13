package com.csi.vidaplus.rcm.claim.model;

public class FilterType extends BaseModel {

	private String name;
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
