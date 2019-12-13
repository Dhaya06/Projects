package com.csi.rcm.worklist.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.csi.rcm.worklist.model.type.AssignPeriod;
import com.csi.rcm.worklist.model.type.Status;

/**
 * 
 * @author Kasun
 * @version 1.0
 * @since 2018/01/26
 *
 */
@Entity
@Table(name="work_list")
public class WorkList extends BaseModel {

	@NotBlank(message="Worklist name is required")
	@Column(name="work_list_name")
	private String name;
	
	@NotNull(message="Worklist assign period is required")
	@Enumerated(EnumType.ORDINAL)
	@Column(name="assign_period")
	private AssignPeriod assignPeriod;
	
	@Valid
	@OneToMany(mappedBy="process",fetch=FetchType.EAGER,cascade=CascadeType.ALL, orphanRemoval = true)
	private Set<MemberAssignment> process;
	
	@Valid
	@OneToMany(mappedBy="review",fetch=FetchType.EAGER,cascade=CascadeType.ALL, orphanRemoval = true)
	private Set<MemberAssignment> review;
	
	@Valid
	@OneToMany(mappedBy="submission",fetch=FetchType.EAGER,cascade=CascadeType.ALL, orphanRemoval = true)
	private Set<MemberAssignment> submission;
	
	@Valid
	@OneToMany(mappedBy="reSubmission",fetch=FetchType.EAGER,cascade=CascadeType.ALL, orphanRemoval = true)
	private Set<MemberAssignment> reSubmission;
	
	@Valid
	@NotEmpty(message="At least one filter criteria is required for worklist")
	@OneToMany(mappedBy="workList",fetch=FetchType.EAGER,cascade=CascadeType.ALL, orphanRemoval = true)
	@OrderBy("order")
	private List<ClaimFilter> claimFilters; 
	
	@NotNull(message="Worklist status is required")
	@Enumerated(EnumType.ORDINAL)
	@Column(name="worklist_status")
	private Status status;

	@NotNull(message="Work list active from date is required")
	@Temporal(TemporalType.DATE)
	@Column(name="activefrom")
	private Date activeFrom;
	
	@Column(name="deleted")
	private Boolean deleted = Boolean.FALSE;
	
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<ClaimFilter> getClaimFilters() {
		return claimFilters;
	}

	public void setClaimFilters(List<ClaimFilter> claimFilters) {
		this.claimFilters = claimFilters;
	}

	public Date getActiveFrom() {
		return activeFrom;
	}

	public void setActiveFrom(Date activeFrom) {
		this.activeFrom = activeFrom;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
	
}
