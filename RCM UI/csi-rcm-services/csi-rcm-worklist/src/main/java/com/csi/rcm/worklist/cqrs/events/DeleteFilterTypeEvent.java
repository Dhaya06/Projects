package com.csi.rcm.worklist.cqrs.events;

import com.csi.microservices.persistence.cqrs.BaseCqrsCommand;

public class DeleteFilterTypeEvent  extends BaseCqrsCommand<String>{

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
