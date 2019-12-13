package csi.vidaplus.rcm.dataimport.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Document(collection = "encounter_activity")
@ApiModel(description = "This model represent a activity performed in the encounter ")
public class EncounterActivity extends BaseModel {

	@ApiModelProperty("activityType should be a defined value in the RCM system")
	private String activityType;
	@ApiModelProperty("activityCode should be a defined value in the RCM system")
	private String activityCode;
	@ApiModelProperty(value = "Activity ordered date, format should be yyyy-MM-dd hh:mm:ss")
	@JsonFormat(pattern = "")
	private Date orderDate;
	@ApiModelProperty(value = "Activity performed or not", allowableValues = "PERFORMED,NOTPERFORMED")
	private String performedStatus;
	@ApiModelProperty(value = "Service peformed date, format should be yyyy-MM-dd hh:mm:ss")
	private Date servicePerformedDate;
	@ApiModelProperty(value = "Ordered quantity")
	private Double quantity;
	@ApiModelProperty(value = "Gross amount of the activity")
	private Double grossAmount;
	@ApiModelProperty(value = "Discount percentage of the activity")
	private Double discountPercentage;
	@ApiModelProperty(value = "Discount amount of the activity")
	private Double discount;
	@ApiModelProperty(value = "Net amount of the activity")
	private Double netAmount;
	@ApiModelProperty(value = "Patient share of the activity")
	private Double patientShare;
	@ApiModelProperty(value = "Company share of the activity")
	private Double companyShare;
	@ApiModelProperty(value = "Company share Percentage of the activity")
	private Double companySharePercentage;
	@ApiModelProperty(value = "Patient share Percentage of the activity")
	private Double patientSharePercentage;
	@ApiModelProperty(value = "License number of the clinician who ordered the service or referred the patient for the service")
	private String orderingClinician;
	@ApiModelProperty("The Prior Authorization ID")
	private String approvalCode;

	private String observationRemarks;
	private String userRemarks;
	private String procedureDescription;
	private String serviceCategory;

	@ApiModelProperty(hidden = true)
	private String encounterInvoiceNo;

	/**
	 * @return the activityType
	 */
	public String getActivityType() {
		return activityType;
	}

	/**
	 * @param activityType the activityType to set
	 */
	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	/**
	 * @return the activityCode
	 */
	public String getActivityCode() {
		return activityCode;
	}

	/**
	 * @param activityCode the activityCode to set
	 */
	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}

	/**
	 * @return the orderDate
	 */
	public Date getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @return the performedStatus
	 */
	public String getPerformedStatus() {
		return performedStatus;
	}

	/**
	 * @param performedStatus the performedStatus to set
	 */
	public void setPerformedStatus(String performedStatus) {
		this.performedStatus = performedStatus;
	}

	/**
	 * @return the servicePerformedDate
	 */
	public Date getServicePerformedDate() {
		return servicePerformedDate;
	}

	/**
	 * @param servicePerformedDate the servicePerformedDate to set
	 */
	public void setServicePerformedDate(Date servicePerformedDate) {
		this.servicePerformedDate = servicePerformedDate;
	}

	/**
	 * @return the quantity
	 */
	public Double getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getGrossAmount() {
		return grossAmount;
	}

	public void setGrossAmount(Double grossAmount) {
		this.grossAmount = grossAmount;
	}

	public Double getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(Double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public Double getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(Double netAmount) {
		this.netAmount = netAmount;
	}

	public Double getCompanySharePercentage() {
		return companySharePercentage;
	}

	public void setCompanySharePercentage(Double companySharePercentage) {
		this.companySharePercentage = companySharePercentage;
	}

	public Double getPatientSharePercentage() {
		return patientSharePercentage;
	}

	public void setPatientSharePercentage(Double patientSharePercentage) {
		this.patientSharePercentage = patientSharePercentage;
	}

	/**
	 * @return the discount
	 */
	public Double getDiscount() {
		return discount;
	}

	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(Double discount) {
		this.discount = discount;
	}



	/**
	 * @return the patientShare
	 */
	public Double getPatientShare() {
		return patientShare;
	}

	/**
	 * @param patientShare the patientShare to set
	 */
	public void setPatientShare(Double patientShare) {
		this.patientShare = patientShare;
	}

	/**
	 * @return the companyShare
	 */
	public Double getCompanyShare() {
		return companyShare;
	}

	/**
	 * @param companyShare the companyShare to set
	 */
	public void setCompanyShare(Double companyShare) {
		this.companyShare = companyShare;
	}

	/**
	 * @return the orderingClinician
	 */
	public String getOrderingClinician() {
		return orderingClinician;
	}

	/**
	 * @param orderingClinician the orderingClinician to set
	 */
	public void setOrderingClinician(String orderingClinician) {
		this.orderingClinician = orderingClinician;
	}

	/**
	 * @return the approvalCode
	 */
	public String getApprovalCode() {
		return approvalCode;
	}

	/**
	 * @param approvalCode the approvalCode to set
	 */
	public void setApprovalCode(String approvalCode) {
		this.approvalCode = approvalCode;
	}

	/**
	 * @return the observationRemarks
	 */
	public String getObservationRemarks() {
		return observationRemarks;
	}

	/**
	 * @param observationRemarks the observationRemarks to set
	 */
	public void setObservationRemarks(String observationRemarks) {
		this.observationRemarks = observationRemarks;
	}

	/**
	 * @return the userRemarks
	 */
	public String getUserRemarks() {
		return userRemarks;
	}

	/**
	 * @param userRemarks the userRemarks to set
	 */
	public void setUserRemarks(String userRemarks) {
		this.userRemarks = userRemarks;
	}

	/**
	 * @return the encounterInvoiceNo
	 */
	public String getEncounterInvoiceNo() {
		return encounterInvoiceNo;
	}

	/**
	 * @param encounterInvoiceNo the encounterInvoiceNo to set
	 */
	public void setEncounterInvoiceNo(String encounterInvoiceNo) {
		this.encounterInvoiceNo = encounterInvoiceNo;
	}

	public String getProcedureDescription() {
		return procedureDescription;
	}

	public void setProcedureDescription(String procedureDescription) {
		this.procedureDescription = procedureDescription;
	}

	public String getServiceCategory() {
		return serviceCategory;
	}

	public void setServiceCategory(String serviceCategory) {
		this.serviceCategory = serviceCategory;
	}
}
