package csi.vidaplus.rcm.datavalidation.model;

import java.util.Date;

public class EncounterActivity extends BaseModel {

	private String activityType;
	private String activityCode;
	private Date orderDate;
	private String performedStatus;
	private Date servicePerformedDate;
	private Double quantity;
	private Double activityNet;
	private Double activityGross;
	private Double patientShare;
	private Double paymentAmount;
	private String orderingClinician;// License number of the clinician
	private String priorAuthorizationID;

	private Double discountPrecentage;
	private Double discount;

	private String approvalCode;
	private String observationRemarks;
	private String userRemarks;
	
	private String encounterId;

	public String getEncounterId() {
		return encounterId;
	}

	public void setEncounterId(String encounterId) {
		this.encounterId = encounterId;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public String getActivityCode() {
		return activityCode;
	}

	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getPerformedStatus() {
		return performedStatus;
	}

	public void setPerformedStatus(String performedStatus) {
		this.performedStatus = performedStatus;
	}

	public Date getServicePerformedDate() {
		return servicePerformedDate;
	}

	public void setServicePerformedDate(Date servicePerformedDate) {
		this.servicePerformedDate = servicePerformedDate;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getActivityNet() {
		return activityNet;
	}

	public void setActivityNet(Double activityNet) {
		this.activityNet = activityNet;
	}

	public Double getActivityGross() {
		return activityGross;
	}

	public void setActivityGross(Double activityGross) {
		this.activityGross = activityGross;
	}

	public Double getPatientShare() {
		return patientShare;
	}

	public void setPatientShare(Double patientShare) {
		this.patientShare = patientShare;
	}

	public Double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(Double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getOrderingClinician() {
		return orderingClinician;
	}

	public void setOrderingClinician(String orderingClinician) {
		this.orderingClinician = orderingClinician;
	}

	public String getPriorAuthorizationID() {
		return priorAuthorizationID;
	}

	public void setPriorAuthorizationID(String priorAuthorizationID) {
		this.priorAuthorizationID = priorAuthorizationID;
	}

	public Double getDiscountPrecentage() {
		return discountPrecentage;
	}

	public void setDiscountPrecentage(Double discountPrecentage) {
		this.discountPrecentage = discountPrecentage;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public String getApprovalCode() {
		return approvalCode;
	}

	public void setApprovalCode(String approvalCode) {
		this.approvalCode = approvalCode;
	}

	public String getObservationRemarks() {
		return observationRemarks;
	}

	public void setObservationRemarks(String observationRemarks) {
		this.observationRemarks = observationRemarks;
	}

	public String getUserRemarks() {
		return userRemarks;
	}

	public void setUserRemarks(String userRemarks) {
		this.userRemarks = userRemarks;
	}

}
