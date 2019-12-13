package com.csi.rcm.minimumdata.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csi.rcm.minimumdata.cqrs.commands.CreateValidationFieldCommand;
import com.csi.rcm.minimumdata.model.ValidationClass;
import com.csi.rcm.minimumdata.model.ValidationField;
import com.csi.rcm.minimumdata.repository.ValidationFieldRepository;
import com.csi.rcm.minimumdata.service.ValidationFieldService;

/**
 * 
 * @author Kasun
 * @version 1.0
 * @since 2018/01/23
 *
 */
@Service
public class ValidationFieldServiceImpl implements ValidationFieldService {

	@Autowired
	private CommandGateway gateway;
	
	@Autowired
	private ValidationFieldRepository fieldRepository;
	
	@Override
	public void saveValidationField(ValidationField validationField) {
		CreateValidationFieldCommand createValidationFieldCommand = new CreateValidationFieldCommand();
		createValidationFieldCommand.setIdentifier(UUID.randomUUID().toString());
		BeanUtils.copyProperties(validationField, createValidationFieldCommand);
		
		gateway.send(createValidationFieldCommand);
	}
	
	@Override
	public List<CreateValidationFieldCommand> getCreateValidationFieldCommands(List<ValidationField> fields) {
		
		List<CreateValidationFieldCommand> commands = new LinkedList<>();
		
		for (ValidationField validationField : fields) {
			CreateValidationFieldCommand command = new CreateValidationFieldCommand();
			BeanUtils.copyProperties(validationField, command);
			commands.add(command);
		}
		
		return commands;
	}
	
	@Override
	public List<ValidationField> findAllBySystemValidateionClass(ValidationClass systemValidateionClass) {
		return fieldRepository.findAllBySystemValidateionClass(systemValidateionClass);
	}

	
	@Override
	public Boolean systemFieldsRemoved(List<ValidationField> fields, List<ValidationField> currentFields) {
		fields.removeAll(currentFields);
		// if list is empty that means all the system fields are exist. else some of the system fields are removed
		return !fields.isEmpty();
	}
	
}
