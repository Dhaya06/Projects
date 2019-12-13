package com.csi.rcm.worklist.service.impl;

import java.util.List;
import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csi.rcm.worklist.cqrs.command.CreateWorkListCommand;
import com.csi.rcm.worklist.cqrs.command.DeleteWorklistCommand;
import com.csi.rcm.worklist.cqrs.command.UpdateWorkListCommand;
import com.csi.rcm.worklist.model.ClaimFilter;
import com.csi.rcm.worklist.model.WorkList;
import com.csi.rcm.worklist.model.type.Status;
import com.csi.rcm.worklist.repository.WorkListRepository;
import com.csi.rcm.worklist.repository.specification.WorklistSpecifications;
import com.csi.rcm.worklist.request.WorklistSearchModel;
import com.csi.rcm.worklist.service.ClaimFilterService;
import com.csi.rcm.worklist.service.WorkListService;

@Service
public class WorkListServiceImpl implements WorkListService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CommandGateway gateway;
	
	@Autowired
	private WorkListRepository repository;

	@Autowired
	private ClaimFilterService filterService;
	
	@Override
	public void save(WorkList workList) {
		
		logger.info("Creating new CreateWorkListCommand for worklist -" +workList.getName());
		
		CreateWorkListCommand command = new CreateWorkListCommand();
		command.setProcess(workList.getProcess());
		command.setReview(workList.getReview());
		command.setSubmission(workList.getSubmission());
		command.setReSubmission(workList.getReSubmission());
		command.setClaimFilters(workList.getClaimFilters());
		command.getProcess().forEach(pr->pr.setProcess(workList));
		command.getReview().forEach(pr->pr.setReview(workList));
		command.getSubmission().forEach(pr->pr.setSubmission(workList));
		command.getReSubmission().forEach(pr->pr.setReSubmission(workList));
		command.getClaimFilters().forEach(pr->pr.setWorkList(workList));
		command.getClaimFilters().forEach(pr->pr.getFilterValues().forEach(cval -> cval.setClaimFilter(pr)));
		
		BeanUtils.copyProperties(workList, command);
		
		command.setIdentifier(UUID.randomUUID().toString());
		
		logger.info("Created new worklist CreateWorkListCommand -"+ command.getIdentifier());
		
		gateway.send(command);
	}

	@Override
	public void update(WorkList workList) {
		
		logger.info("Creating new UpdateWorkListCommand for worklist -" +workList.getId());
		
		UpdateWorkListCommand command = new UpdateWorkListCommand();
		command.setProcess(workList.getProcess());
		command.setReview(workList.getReview());
		command.setSubmission(workList.getSubmission());
		command.setReSubmission(workList.getReSubmission());
		command.setClaimFilters(workList.getClaimFilters());
		command.getProcess().forEach(pr->pr.setProcess(workList));
		command.getReview().forEach(pr->pr.setReview(workList));
		command.getSubmission().forEach(pr->pr.setSubmission(workList));
		command.getReSubmission().forEach(pr->pr.setReSubmission(workList));
		command.getClaimFilters().forEach(pr->pr.setWorkList(workList));
		command.getClaimFilters().forEach(pr->pr.getFilterValues().forEach(cval -> cval.setClaimFilter(pr)));
		
		BeanUtils.copyProperties(workList, command);
		
		command.setIdentifier(UUID.randomUUID().toString());
		
		logger.info("Created new worklist UpdateWorkListCommand -"+ command.getIdentifier());
		
		gateway.send(command);
	}
	
	
	@Override
	public List<WorkList> getAll() {
		List<WorkList> workLists = repository.findByDeleted(Boolean.FALSE);
		for (WorkList workList : workLists) {
			List<ClaimFilter> filters = filterService.removeDuplicateAndreSort(workList.getClaimFilters());
			workList.setClaimFilters(filters);
		}
		return workLists;
	}

	
	@Override
	public WorkList getById(Long id) {
		WorkList workList = repository.findOne(id);
		List<ClaimFilter> filters = filterService.removeDuplicateAndreSort(workList.getClaimFilters());
		workList.setClaimFilters(filters);
		return workList;
	}
	
	
	@Override
	public void deleteById(Long id) {
		DeleteWorklistCommand command = new DeleteWorklistCommand();
		command.setId(id);
		command.setIdentifier(UUID.randomUUID().toString());
		gateway.send(command);
	}
	
	@Override
	public List<WorkList> search(WorklistSearchModel searchModel) {
		List<WorkList> workLists = repository.findAll(WorklistSpecifications.searchWorkList(searchModel));
		for (WorkList workList : workLists) {
			List<ClaimFilter> filters = filterService.removeDuplicateAndreSort(workList.getClaimFilters());
			workList.setClaimFilters(filters);
		}
		return workLists;
	}
	
	@Override
	public List<WorkList> getWorklistByName(String name) {
		return repository.findByNameAndDeleted(name,Boolean.FALSE);
	}
	
	@Override
	public List<WorkList> getActiveWorklist() {
		return repository.findByStatusAndDeleted(Status.Active, Boolean.FALSE);
	}
	
}
