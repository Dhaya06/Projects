package com.csi.rcm.minimumdata.cqrs.events;

import com.csi.microservices.persistence.cqrs.BaseCqrsCommand;

/**
 * 
 * @author Kasun
 * @version 1.0
 * @since 2018/01/23
 *
 */
public class CreateFieldTypeEvent extends BaseCqrsCommand<String>{

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
