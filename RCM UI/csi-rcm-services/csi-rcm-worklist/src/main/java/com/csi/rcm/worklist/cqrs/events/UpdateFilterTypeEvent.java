package com.csi.rcm.worklist.cqrs.events;

import com.csi.microservices.persistence.cqrs.BaseCqrsCommand;

public class UpdateFilterTypeEvent extends BaseCqrsCommand<String> {

	private Long id;

	private String name;

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
