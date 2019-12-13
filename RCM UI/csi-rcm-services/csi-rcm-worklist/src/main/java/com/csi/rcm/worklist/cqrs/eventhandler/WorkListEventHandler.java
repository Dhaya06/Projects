package com.csi.rcm.worklist.cqrs.eventhandler;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.csi.microservices.persistence.cqrs.BaseCqrsEvenHandler;
import com.csi.rcm.worklist.cqrs.events.CreateWorkListEvent;
import com.csi.rcm.worklist.cqrs.events.DeleteWorkListEvent;
import com.csi.rcm.worklist.cqrs.events.UpdateWorkListEvent;
import com.csi.rcm.worklist.model.WorkList;
import com.csi.rcm.worklist.repository.WorkListRepository;

/**
 * EventHandler class for WorkList
 * @author Kasun
 * @version 0.0.1
 * @since 2018/01/26
 */
@Component
public class WorkListEventHandler implements BaseCqrsEvenHandler {

	@Autowired
	private WorkListRepository repository;

	@EventHandler
	public void on(CreateWorkListEvent event) {

		WorkList workList = new WorkList();
		workList.setProcess(event.getProcess());
		workList.setReview(event.getReview());
		workList.setSubmission(event.getSubmission());
		workList.setReSubmission(event.getReSubmission());
		workList.setClaimFilters(event.getClaimFilters());
		
		workList.getProcess().forEach(pr->pr.setProcess(workList));
		workList.getReview().forEach(pr->pr.setReview(workList));
		workList.getSubmission().forEach(pr->pr.setSubmission(workList));
		workList.getReSubmission().forEach(pr->pr.setReSubmission(workList));
		workList.getClaimFilters().forEach(pr->pr.setWorkList(workList));
		
		BeanUtils.copyProperties(event, workList);

		repository.save(workList);
	}
	
	@EventHandler
	public void on(UpdateWorkListEvent event) {

		WorkList workList = new WorkList();
		workList.setProcess(event.getProcess());
		workList.setReview(event.getReview());
		workList.setSubmission(event.getSubmission());
		workList.setReSubmission(event.getReSubmission());
		workList.setClaimFilters(event.getClaimFilters());
		
		workList.getProcess().forEach(pr->pr.setProcess(workList));
		workList.getReview().forEach(pr->pr.setReview(workList));
		workList.getSubmission().forEach(pr->pr.setSubmission(workList));
		workList.getReSubmission().forEach(pr->pr.setReSubmission(workList));
		workList.getClaimFilters().forEach(pr->pr.setWorkList(workList));
		workList.getClaimFilters().forEach(pr->pr.getFilterValues().forEach(cval -> cval.setClaimFilter(pr)));
		
		BeanUtils.copyProperties(event, workList);

		repository.save(workList);
	}
	
	@EventHandler
	public void on(DeleteWorkListEvent event) {

		WorkList worklist = repository.findOne(event.getId());
		worklist.setDeleted(Boolean.TRUE);
		repository.save(worklist);
	}

}
