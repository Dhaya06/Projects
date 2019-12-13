package com.csi.rcm.worklist.service.impl;

import java.util.List;
import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csi.rcm.worklist.cqrs.command.CreateFilterTypeCommand;
import com.csi.rcm.worklist.cqrs.command.UpdateFilterTypeCommand;
import com.csi.rcm.worklist.model.FilterType;
import com.csi.rcm.worklist.repository.FilterTypeRepository;
import com.csi.rcm.worklist.service.FilterTypeService;

@Service
public class FilterTypeServiceImpl implements FilterTypeService {

	@Autowired
	private CommandGateway gateway;
	
	@Autowired
	private FilterTypeRepository repository;
	
	@Override
	public void save(FilterType filterType) {
		CreateFilterTypeCommand command = new CreateFilterTypeCommand();
		command.setIdentifier(UUID.randomUUID().toString());
		
		BeanUtils.copyProperties(filterType, command);
		gateway.send(command);
	}

	@Override
	public void update(FilterType filterType) {
		UpdateFilterTypeCommand command = new UpdateFilterTypeCommand();
		command.setIdentifier(UUID.randomUUID().toString());
		
		BeanUtils.copyProperties(filterType, command);
		gateway.send(command);
	}

	@Override
	public List<FilterType> getAll() {
		return repository.findAll();
	}

	@Override
	public FilterType getById(Long id) {
		return repository.findOne(id);
	}

}
