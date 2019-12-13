package com.csi.rcm.worklist.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.Objects;

/**
 * 
 * @author Kasun
 * @version 1.0
 * @since 2018/01/26
 *
 */
@Entity
@Table(name = "member_assignment")
public class MemberAssignment extends BaseModel {

	@NotNull(message = "Staff Member is required")
	@ManyToOne
	@JoinColumn(name = "staff_member")
	private StaffMember staffMember;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "process")
	private WorkList process;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "review")
	private WorkList review;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "submission")
	private WorkList submission;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "re_submission")
	private WorkList reSubmission;

	public StaffMember getStaffMember() {
		return staffMember;
	}

	public void setStaffMember(StaffMember staffMember) {
		this.staffMember = staffMember;
	}

	public WorkList getProcess() {
		return process;
	}

	public void setProcess(WorkList process) {
		this.process = process;
	}

	public WorkList getReview() {
		return review;
	}

	public void setReview(WorkList review) {
		this.review = review;
	}

	public WorkList getSubmission() {
		return submission;
	}

	public void setSubmission(WorkList submission) {
		this.submission = submission;
	}

	public WorkList getReSubmission() {
		return reSubmission;
	}

	public void setReSubmission(WorkList reSubmission) {
		this.reSubmission = reSubmission;
	}

	@Override
	public int hashCode() {
		if (getId() == null) {
			return staffMember.hashCode();
		}
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof MemberAssignment) {
			if (getId() == null) {
				MemberAssignment assignment = (MemberAssignment) obj;
				return Objects.equal(staffMember, assignment.getStaffMember());
			}

			return super.equals(obj);

		} else {
			return false;
		}

	}

}
