package com.csi.rcm.worklist.cqrs.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateLifecycle;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.csi.microservices.persistence.cqrs.BaseCqrsAggregate;
import com.csi.rcm.worklist.cqrs.command.CreateWorkListCommand;
import com.csi.rcm.worklist.cqrs.command.DeleteWorklistCommand;
import com.csi.rcm.worklist.cqrs.command.UpdateWorkListCommand;
import com.csi.rcm.worklist.cqrs.events.CreateWorkListEvent;
import com.csi.rcm.worklist.cqrs.events.DeleteWorkListEvent;
import com.csi.rcm.worklist.cqrs.events.UpdateWorkListEvent;

/**
 * Aggregate class for WorkList
 * @author Kasun
 * @version 0.0.1
 * @since 2018/01/26
 */
@Aggregate
public class WorkListAggregate extends BaseCqrsAggregate<String> {

	@CommandHandler
	public WorkListAggregate(CreateWorkListCommand command) {
		super(command);
		
		CreateWorkListEvent event = new CreateWorkListEvent();
		event.setProcess(command.getProcess());
		event.setReview(command.getReview());
		event.setSubmission(command.getSubmission());
		event.setReSubmission(command.getReSubmission());
		event.setClaimFilters(command.getClaimFilters());
		
		BeanUtils.copyProperties(command, event);
		
		AggregateLifecycle.apply(event);
	}
	
	@EventSourcingHandler
	public void on(CreateWorkListEvent event) {
		super.setIdentifier(event.getIdentifier());
	}
	
	
	@CommandHandler
	public WorkListAggregate(UpdateWorkListCommand command) {
		super(command);
		
		UpdateWorkListEvent event = new UpdateWorkListEvent();
		event.setProcess(command.getProcess());
		event.setReview(command.getReview());
		event.setSubmission(command.getSubmission());
		event.setReSubmission(command.getReSubmission());
		event.setClaimFilters(command.getClaimFilters());
		
		BeanUtils.copyProperties(command, event);
		
		AggregateLifecycle.apply(event);
	}
	
	@EventSourcingHandler
	public void on(UpdateWorkListEvent event) {
		super.setIdentifier(event.getIdentifier());
	}
	
	@CommandHandler
	public WorkListAggregate(DeleteWorklistCommand command) {
		super(command);
		
		DeleteWorkListEvent event = new DeleteWorkListEvent();
		BeanUtils.copyProperties(command, event);
		
		AggregateLifecycle.apply(event);
	}
	
	@EventSourcingHandler
	public void on(DeleteWorkListEvent event) {
		super.setIdentifier(event.getIdentifier());
	}
	
}
