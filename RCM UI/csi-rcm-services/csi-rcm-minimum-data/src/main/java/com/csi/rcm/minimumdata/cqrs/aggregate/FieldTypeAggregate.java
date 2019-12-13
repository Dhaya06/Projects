package com.csi.rcm.minimumdata.cqrs.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateLifecycle;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.csi.microservices.persistence.cqrs.BaseCqrsAggregate;
import com.csi.rcm.minimumdata.cqrs.commands.CreateFieldTypeCommand;
import com.csi.rcm.minimumdata.cqrs.commands.UpdateFieldTypeCommand;
import com.csi.rcm.minimumdata.cqrs.events.CreateFieldTypeEvent;
import com.csi.rcm.minimumdata.cqrs.events.UpdateFieldTypeEvent;
/**
 * Aggregate class for FieldType
 * @author Kasun
 * @version 0.0.1
 * @since 2018/01/23
 */
@Aggregate
public class FieldTypeAggregate extends BaseCqrsAggregate<String> {

	
	@CommandHandler
	public FieldTypeAggregate(CreateFieldTypeCommand command) {
		super(command);
		CreateFieldTypeEvent event = new CreateFieldTypeEvent();
		BeanUtils.copyProperties(command, event);
		
		AggregateLifecycle.apply(event);
	}
	
	@EventSourcingHandler
	public void on(CreateFieldTypeEvent event) {
		super.setIdentifier(event.getIdentifier());
	}
	
	@CommandHandler
	public FieldTypeAggregate(UpdateFieldTypeCommand command) {
		super(command);
		UpdateFieldTypeEvent event = new UpdateFieldTypeEvent();
		BeanUtils.copyProperties(command, event);
		
		AggregateLifecycle.apply(event);
	}
	
	@EventSourcingHandler
	public void on(UpdateFieldTypeEvent event) {
		super.setIdentifier(event.getIdentifier());
	}
}
