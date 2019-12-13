package com.csi.vidaplus.rcm.claim.model.type;

public enum Status {

	Active("Active"),
	Inactive("Inactive");
	
	Status(String name) {
		this.name = name;
	}
	
	private String name;
	
	@Override
	public String toString() {
		return name;
	}
}
