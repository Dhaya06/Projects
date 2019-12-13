package com.csi.rcm.minimumdata.service.impl;

import java.util.List;
import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.csi.rcm.minimumdata.cqrs.commands.CreateValidationClassCommand;
import com.csi.rcm.minimumdata.cqrs.commands.UpdateValidationClassCommand;
import com.csi.rcm.minimumdata.model.ValidationClass;
import com.csi.rcm.minimumdata.model.ValidationField;
import com.csi.rcm.minimumdata.repository.ValidationClassRepository;
import com.csi.rcm.minimumdata.service.ValidationClassService;
import com.csi.rcm.minimumdata.service.ValidationFieldService;
import com.google.common.base.Objects;

/**
 * 
 * @author Kasun
 * @version 1.0
 * @since 2018/01/23
 *
 */
@Service
public class ValidationClassServiceImpl implements ValidationClassService {

	@Autowired
	private CommandGateway gateway;

	@Autowired
	private ValidationFieldService fieldService;

	@Autowired
	private ValidationClassRepository repository;

	@Override
	public void save(ValidationClass validationClass) {

		List<ValidationField> additionalFields = validationClass.getAdditionalFields();
		List<ValidationField> systemDefinedFields = validationClass.getSystemDefinedFields();
		List<ValidationField> attachments = validationClass.getAttachments();
		// CreateValidationClassCommand for axon
		CreateValidationClassCommand createCommand = new CreateValidationClassCommand();
		createCommand.setAdditionalFields(additionalFields);
		createCommand.setSystemDefinedFields(systemDefinedFields);
		createCommand.setAttachments(attachments);

		createCommand.setIdentifier(UUID.randomUUID().toString());

		BeanUtils.copyProperties(validationClass, createCommand);

		gateway.sendAndWait(createCommand);
	}

	@Override
	public void update(ValidationClass validationClass) {
		List<ValidationField> additionalFields = validationClass.getAdditionalFields();
		List<ValidationField> systemDefinedFields = validationClass.getSystemDefinedFields();
		List<ValidationField> attachments = validationClass.getAttachments();
		// Get existing system defined fields check with the send system defined fields.
		List<ValidationField> oldSystemDefinedFields = fieldService.findAllBySystemValidateionClass(validationClass);
		Boolean systemFieldsRemoved = fieldService.systemFieldsRemoved(oldSystemDefinedFields, systemDefinedFields);

		// System defined fields are not allowed to remove
		Assert.isTrue(!systemFieldsRemoved, "Cannot remove system defined fields");

		UpdateValidationClassCommand createCommand = new UpdateValidationClassCommand();
		createCommand.setAdditionalFields(additionalFields);
		createCommand.setSystemDefinedFields(systemDefinedFields);
		createCommand.setAttachments(attachments);

		createCommand.setIdentifier(UUID.randomUUID().toString());

		BeanUtils.copyProperties(validationClass, createCommand);

		gateway.sendAndWait(createCommand);
	}

	@Override
	public List<ValidationClass> getAll() {
		return repository.findAll();
	}

	@Override
	public ValidationClass getByClassName(String className) {
		return repository.findOneByClassName(className);
	}

	@Override
	public boolean fieldValueExists(Object object, String fieldName) {

		if (object == null) {
			return false;
		}

		ValidationClass validationClass = (ValidationClass) object;

		ValidationClass byClassName = repository.findOneByClassName(fieldName);
		// if there is no value for given field name then its not a duplicate value
		if (byClassName == null) {
			return false;
		}
		// if there is a object for given field name and its not equals to the given
		// object then its a duplicate value. This happens for updates
		return !Objects.equal(validationClass, byClassName);
	}

}
