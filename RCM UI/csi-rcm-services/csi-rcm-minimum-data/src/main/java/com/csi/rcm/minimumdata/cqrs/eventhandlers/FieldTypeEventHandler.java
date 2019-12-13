package com.csi.rcm.minimumdata.cqrs.eventhandlers;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.csi.microservices.persistence.cqrs.BaseCqrsEvenHandler;
import com.csi.rcm.minimumdata.cqrs.events.CreateFieldTypeEvent;
import com.csi.rcm.minimumdata.cqrs.events.UpdateFieldTypeEvent;
import com.csi.rcm.minimumdata.model.FieldType;
import com.csi.rcm.minimumdata.repository.FieldTypeRepository;
/**
 * 
 * @author Kasun
 * @version 1.0
 * @since 2018/01/23
 *
 */
@Component
public class FieldTypeEventHandler implements BaseCqrsEvenHandler  {

	@Autowired
	private FieldTypeRepository repository;
	
	@EventHandler
	public FieldType on(CreateFieldTypeEvent command) {
		
		FieldType type = new FieldType();
		BeanUtils.copyProperties(command, type);
		
		return repository.save(type);
	}
	
	@EventHandler
	public FieldType on(UpdateFieldTypeEvent command) {
		
		FieldType type = new FieldType();
		BeanUtils.copyProperties(command, type);
		
		return repository.save(type);
	}
}
