package com.csi.rcm.worklist.cqrs.command;

import com.csi.microservices.persistence.cqrs.BaseCqrsCommand;

public class DeleteWorklistCommand extends BaseCqrsCommand<String> {

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
