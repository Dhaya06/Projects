package com.csi.rcm.minimumdata.service.impl;

import java.util.List;
import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csi.rcm.minimumdata.cqrs.commands.CreateFieldTypeCommand;
import com.csi.rcm.minimumdata.cqrs.commands.UpdateFieldTypeCommand;
import com.csi.rcm.minimumdata.model.FieldType;
import com.csi.rcm.minimumdata.repository.FieldTypeRepository;
import com.csi.rcm.minimumdata.service.FieldTypeService;

/**
 * 
 * @author Kasun
 * @version 1.0
 * @since 2018/01/23
 *
 */
@Service
public class FieldTypeServiceImpl implements FieldTypeService {

	@Autowired
	private CommandGateway gateway;
	
	@Autowired
	private FieldTypeRepository repository;
	
	@Override
	public void save(FieldType fieldType) {
		CreateFieldTypeCommand  command = new CreateFieldTypeCommand();
		BeanUtils.copyProperties(fieldType, command);
		
		command.setIdentifier(UUID.randomUUID().toString());
		
		gateway.send(command);
	}
	
	@Override
	public void update(FieldType fieldType) {
		UpdateFieldTypeCommand  command = new UpdateFieldTypeCommand();
		BeanUtils.copyProperties(fieldType, command);
		
		command.setIdentifier(UUID.randomUUID().toString());
		
		gateway.send(command);
	}
	
	@Override
	public List<FieldType> getAll() {
		return repository.findAll();
	}

}
