package com.csi.rcm.worklist.model.type;

public enum AssignPeriod {

	ONEDAY("1 Day"),
	ONEWEEK("1 Week"),
	ONEMONTH("1 Month"),
	SIXMONTH("6 Month"),
	ONEYEAR("1 Year");
	
	private String name;
	
	AssignPeriod(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name; 
	}
}
