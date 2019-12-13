package com.csi.rcm.worklist.cqrs.command;

import com.csi.microservices.persistence.cqrs.BaseCqrsCommand;

public class CreateFilterTypeCommand extends BaseCqrsCommand<String>{

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
