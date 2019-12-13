
package com.csi.vidaplus.rcm.claim.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="claim_activity")
public class ClaimActivity extends BaseEntity{
    //@NotBlank(message="activity type is required")
    @Column(name="activity_type")
    private String activityType;

    //@NotBlank(message="activity code is required")
    //@NotNull(message="activity code is required")
    @Column(name="activity_code")
    private String activityCode;

    //@NotNull(message="active order date is required")
    @Temporal(TemporalType.DATE)
    @Column(name="order_date")
    private Date orderDate;

    //@NotNull(message="active order date is required")
    @Column(name="performed_status")
    private String performedStatus;

    //@NotNull(message="activity performed date is required")
    @Temporal(TemporalType.DATE)
    @Column(name="service_performed_date")
    private Date servicePerformedDate;

    //@Min(value = 0)
    @Column(name="procedure_price")
    private Double procedurePrice;

    @Column(name="quantity")
    private Double quantity;

    //@Min(value = 0)
    @Column(name="activity_net")
    private Double netAmount;

    //@Min(value = 0)
    @Column(name="activity_gross")
    private Double grossAmount;

    //@Min(value = 0)
    @Column(name="patient_share")
    private Double patientShare;

    //@Min(value = 0)
    @Column(name="company_share_percentage")
    private Double companySharePercentage;

    @Column(name="patient_share_percentage")
    private Double patientSharePercentage;

    //@Min(value = 0)
    @Column(name="company_share")
    private Double companyShare;

    @Column(name="ordering_clinician")
    private String orderingClinician;// License number of the clinicians
    @Column(name="is_covered")
    private String isCovered;

    @Column(name="is_approved")
    private String isApproved;

    //@Min(value = 0)
    //@Max(value = 100)
    @Column(name="discount_percentage")
    private Double discountPercentage;

    //@Min(value = 0)
    @Column(name="discount")
    private Double discount;

    @Column(name="approval_code")
    private String approvalCode;

    @Column(name="observation_remarks")
    private String observationRemarks;

    @Column(name="user_remarks")
    private String userRemarks;

    @Column(name="encounter_invoice_no")
    private String encounterInvoiceNo;

    @Column(name="procedure_description")
    private String procedureDescription;

    @Column(name="serviceCategory")
    private String serviceCategory;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="invoice_id")
    private Invoice activities;

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

    public Double getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(Double netAmount) {
        this.netAmount = netAmount;
    }

    public Double getGrossAmount() {
        return grossAmount;
    }

    public void setGrossAmount(Double grossAmount) {
        this.grossAmount = grossAmount;
    }

    public Double getPatientShare() {
        return patientShare;
    }

    public void setPatientShare(Double patientShare) {
        this.patientShare = patientShare;
    }

    public Double getCompanyShare() {
        return companyShare;
    }

    public void setCompanyShare(Double companyShare) {
        this.companyShare = companyShare;
    }

    public String getOrderingClinician() {
        return orderingClinician;
    }

    public void setOrderingClinician(String orderingClinician) {
        this.orderingClinician = orderingClinician;
    }

    public String getIsCovered() {
        return isCovered;
    }

    public void setIsCovered(String isCovered) {
        this.isCovered = isCovered;
    }

    public String getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(String isApproved) {
        this.isApproved = isApproved;
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
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

    public Invoice getActivities() {
        return activities;
    }

    public void setActivities(Invoice activities) {
        this.activities = activities;
    }

    public String getEncounterInvoiceNo() {
        return encounterInvoiceNo;
    }

    public void setEncounterInvoiceNo(String encounterInvoiceNo) {
        this.encounterInvoiceNo = encounterInvoiceNo;
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

    public Double getProcedurePrice() {
        return procedurePrice;
    }

    public void setProcedurePrice(Double procedurePrice) {
        this.procedurePrice = procedurePrice;
    }
}

