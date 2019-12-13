package com.csi.vidaplus.rcm.claim.model;

public class MemberAssignment extends BaseModel{

	private StaffMember staffMember;
	private WorkList process;
	private WorkList review;
	private WorkList submission;
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
}
