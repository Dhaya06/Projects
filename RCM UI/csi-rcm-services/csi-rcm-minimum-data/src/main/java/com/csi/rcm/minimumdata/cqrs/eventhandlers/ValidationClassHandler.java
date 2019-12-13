package com.csi.rcm.minimumdata.cqrs.eventhandlers;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.csi.microservices.persistence.cqrs.BaseCqrsEvenHandler;
import com.csi.rcm.minimumdata.cqrs.events.CreateValidationClassEvent;
import com.csi.rcm.minimumdata.cqrs.events.UpdateValidationClassEvent;
import com.csi.rcm.minimumdata.model.ValidationClass;
import com.csi.rcm.minimumdata.repository.ValidationClassRepository;

/**
 * 
 * @author Kasun
 * @version 1.0
 * @since 2018/01/23
 *
 */
@Component
public class ValidationClassHandler implements BaseCqrsEvenHandler {

	@Autowired
	private ValidationClassRepository repository;
	
	@EventHandler
	public ValidationClass on(CreateValidationClassEvent event) {
		ValidationClass validationClass = new ValidationClass();
		BeanUtils.copyProperties(event, validationClass);
		
		validationClass.setAdditionalFields(event.getAdditionalFields());
		validationClass.getAdditionalFields().forEach(ad -> ad.setAdditionalValidateionClass(validationClass));
		
		validationClass.setSystemDefinedFields(event.getSystemDefinedFields());
		validationClass.getSystemDefinedFields().forEach(sys -> sys.setSystemValidateionClass(validationClass));
		
		validationClass.setAttachments(event.getAttachments());
		validationClass.getAttachments().forEach(att -> att.setAttachmentValidateionClass(validationClass));
		
		return repository.save(validationClass);
	}
	
	@EventHandler
	public ValidationClass on(UpdateValidationClassEvent event) {
		ValidationClass validationClass = new ValidationClass();
		BeanUtils.copyProperties(event, validationClass);
		
		validationClass.setAdditionalFields(event.getAdditionalFields());
		validationClass.getAdditionalFields().forEach(ad -> ad.setAdditionalValidateionClass(validationClass));
		
		validationClass.setSystemDefinedFields(event.getSystemDefinedFields());
		validationClass.getSystemDefinedFields().forEach(sys -> sys.setSystemValidateionClass(validationClass));
		
		validationClass.setAttachments(event.getAttachments());
		validationClass.getAttachments().forEach(att -> att.setAttachmentValidateionClass(validationClass));
		
		return repository.save(validationClass);
	}
	
}
