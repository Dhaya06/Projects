package com.csi.rcm.worklist.cqrs.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateLifecycle;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.csi.microservices.persistence.cqrs.BaseCqrsAggregate;
import com.csi.rcm.worklist.cqrs.command.CreateFilterTypeCommand;
import com.csi.rcm.worklist.cqrs.command.UpdateFilterTypeCommand;
import com.csi.rcm.worklist.cqrs.events.CreateFilterTypeEvent;
import com.csi.rcm.worklist.cqrs.events.UpdateFilterTypeEvent;

/**
 * Aggregate class for FiterType
 * @author Kasun
 * @version 0.0.1
 * @since 2018/01/26
 */
@Aggregate
public class FilterTypeAggregate extends BaseCqrsAggregate<String>  {

	@CommandHandler
	public FilterTypeAggregate(CreateFilterTypeCommand command) {
		super(command);
		
		CreateFilterTypeEvent event = new CreateFilterTypeEvent();
		
		BeanUtils.copyProperties(command, event);
		
		AggregateLifecycle.apply(event);
	}
	
	@EventSourcingHandler
	public void on(CreateFilterTypeEvent event) {
		super.setIdentifier(event.getIdentifier());
	}
	
	
	@CommandHandler
	public FilterTypeAggregate(UpdateFilterTypeCommand command) {
		super(command);
		
		UpdateFilterTypeEvent event = new UpdateFilterTypeEvent();
		
		BeanUtils.copyProperties(command, event);
		
		AggregateLifecycle.apply(event);
	}
	
	@EventSourcingHandler
	public void on(UpdateFilterTypeEvent event) {
		super.setIdentifier(event.getIdentifier());
	}
	
}
