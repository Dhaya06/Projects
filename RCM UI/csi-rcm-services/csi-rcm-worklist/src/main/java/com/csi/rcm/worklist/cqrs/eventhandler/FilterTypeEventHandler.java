package com.csi.rcm.worklist.cqrs.eventhandler;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.csi.microservices.persistence.cqrs.BaseCqrsEvenHandler;
import com.csi.rcm.worklist.cqrs.events.CreateFilterTypeEvent;
import com.csi.rcm.worklist.cqrs.events.UpdateFilterTypeEvent;
import com.csi.rcm.worklist.model.FilterType;
import com.csi.rcm.worklist.repository.FilterTypeRepository;

/**
 * EventHandler class for FilterType
 * @author Kasun
 * @version 0.0.1
 * @since 2018/01/26
 */
@Component
public class FilterTypeEventHandler implements BaseCqrsEvenHandler {

	@Autowired
	private FilterTypeRepository repository;

	@EventHandler
	public void on(CreateFilterTypeEvent event) {

		FilterType filterType = new FilterType();
		BeanUtils.copyProperties(event, filterType);

		repository.save(filterType);
	}
	
	@EventHandler
	public void on(UpdateFilterTypeEvent event) {

		FilterType filterType = new FilterType();
		BeanUtils.copyProperties(event, filterType);

		repository.save(filterType);
	}

}
