package com.csi.rcm.minimumdata.cqrs.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateLifecycle;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.csi.microservices.persistence.cqrs.BaseCqrsAggregate;
import com.csi.rcm.minimumdata.cqrs.commands.CreateValidationClassCommand;
import com.csi.rcm.minimumdata.cqrs.commands.UpdateValidationClassCommand;
import com.csi.rcm.minimumdata.cqrs.events.CreateValidationClassEvent;
import com.csi.rcm.minimumdata.cqrs.events.UpdateValidationClassEvent;

@Aggregate
public class ValidationClassAggregate  extends BaseCqrsAggregate<String>{

	@CommandHandler
	public ValidationClassAggregate(CreateValidationClassCommand command) {
		super(command);
		
		CreateValidationClassEvent event = new CreateValidationClassEvent();
		event.setSystemDefinedFields(command.getSystemDefinedFields());
		event.setAdditionalFields(command.getAdditionalFields());
		event.setAttachments(command.getAttachments());
		BeanUtils.copyProperties(command, event);
		
		AggregateLifecycle.apply(event);
	}
	
	
	@EventSourcingHandler
	public void on(CreateValidationClassEvent event) {
		super.setIdentifier(event.getIdentifier());
	}
	
	@CommandHandler
	public ValidationClassAggregate(UpdateValidationClassCommand command) {
		super(command);
		
		UpdateValidationClassEvent event = new UpdateValidationClassEvent();
		event.setSystemDefinedFields(command.getSystemDefinedFields());
		event.setAdditionalFields(command.getAdditionalFields());
		event.setAttachments(command.getAttachments());
		BeanUtils.copyProperties(command, event);
		
		AggregateLifecycle.apply(event);
	}
	
	
	@EventSourcingHandler
	public void on(UpdateValidationClassEvent event) {
		super.setIdentifier(event.getIdentifier());
	}
}
