package com.csi.rcm.worklist.cqrs.events;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.csi.microservices.persistence.cqrs.BaseCqrsCommand;
import com.csi.rcm.worklist.model.ClaimFilter;
import com.csi.rcm.worklist.model.MemberAssignment;
import com.csi.rcm.worklist.model.type.AssignPeriod;
import com.csi.rcm.worklist.model.type.Status;

public class UpdateWorkListEvent  extends BaseCqrsCommand<String>{

	private Long id;
	
	private String name;

	private AssignPeriod assignPeriod;

	private Set<MemberAssignment> process;

	private Set<MemberAssignment> review;

	private Set<MemberAssignment> submission;

	private Set<MemberAssignment> reSubmission;

	private List<ClaimFilter> claimFilters;

	private Status status;

	private Date activeFrom;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AssignPeriod getAssignPeriod() {
		return assignPeriod;
	}

	public void setAssignPeriod(AssignPeriod assignPeriod) {
		this.assignPeriod = assignPeriod;
	}

	public Set<MemberAssignment> getProcess() {
		return process;
	}

	public void setProcess(Set<MemberAssignment> process) {
		this.process = process;
	}

	public Set<MemberAssignment> getReview() {
		return review;
	}

	public void setReview(Set<MemberAssignment> review) {
		this.review = review;
	}

	public Set<MemberAssignment> getSubmission() {
		return submission;
	}

	public void setSubmission(Set<MemberAssignment> submission) {
		this.submission = submission;
	}

	public Set<MemberAssignment> getReSubmission() {
		return reSubmission;
	}

	public void setReSubmission(Set<MemberAssignment> reSubmission) {
		this.reSubmission = reSubmission;
	}

	public List<ClaimFilter> getClaimFilters() {
		return claimFilters;
	}

	public void setClaimFilters(List<ClaimFilter> claimFilters) {
		this.claimFilters = claimFilters;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getActiveFrom() {
		return activeFrom;
	}

	public void setActiveFrom(Date activeFrom) {
		this.activeFrom = activeFrom;
	}
	
	
	
}
