package com.csi.rcm.encounter.prognote.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "his_prognoteorder")
public class PNOrder{

    @EmbeddedId
    private PNOrderKey pnOrderKey;

    @Column(name = "appointmentno")
    private int appointmentno;

    @Column(name = "orderno")
    private int orderNo;

    @Column(name = "ordertype")
    private byte orderType;

    @Column(name = "patienttype")
    private byte patientType;

    @Column(name = "patientid")
    private int patientID;

    @Column(name = "price")
    private float price;

    @Column(name = "orderstatus")
    private byte orderStatus;

    @Column(name = "isapprovalrequired")
    private boolean isApprovalRequired;

    @Column(name = "isapprovalcreated")
    private boolean isApprovalCreated;

    @Column(name = "isinvoiced")
    private boolean isInvoiced;

    @Column(name = "isreferralinvoiced")
    private boolean isReferralInvoiced;

    @Column(name = "iserorder")
    private boolean isEROrder;

    @Column(name = "iscash")
    private boolean isCash;

    @Column(name = "status")
    private byte status;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "iscovered")
    private boolean isCovered;

    @Column(name = "dentalestimationno")
    private Integer dentalEstimationNo;

    @Column(name = "dentalestimationlineitemno")
    private Short dentalEstimationLineItemNo;

    @Column(name = "createdby")
    private int createdBy;

    @Column(name = "createdon")
    private Date createdOn;

    @Column(name = "editedby")
    private Integer editedBy;

    @Column(name = "editedon")
    private Date editedOn;

//    @Column(name = "rowver")
//    private timestamp rowVer;

    @Column(name = "isuncoveredbydoctor")
    private Boolean isUncoveredByDoctor;

    @Column(name = "uniquerowid")
    private long uniqueRowID;

    @Column(name = "ordersource")
    private Integer orderSource;

    @Column(name = "isorderset")
    private Boolean isOrderSet;

    @Column(name = "isrefundable")
    private Boolean isRefundable;

    public PNOrderKey getPnOrderKey() {
        return pnOrderKey;
    }

    public void setPnOrderKey(PNOrderKey pnOrderKey) {
        this.pnOrderKey = pnOrderKey;
    }

    public int getAppointmentno() {
        return appointmentno;
    }

    public void setAppointmentno(int appointmentno) {
        this.appointmentno = appointmentno;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public byte getOrderType() {
        return orderType;
    }

    public void setOrderType(byte orderType) {
        this.orderType = orderType;
    }

    public byte getPatientType() {
        return patientType;
    }

    public void setPatientType(byte patientType) {
        this.patientType = patientType;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    public boolean isApprovalRequired() {
        return isApprovalRequired;
    }

    public void setApprovalRequired(boolean approvalRequired) {
        isApprovalRequired = approvalRequired;
    }

    public boolean isApprovalCreated() {
        return isApprovalCreated;
    }

    public void setApprovalCreated(boolean approvalCreated) {
        isApprovalCreated = approvalCreated;
    }

    public boolean isInvoiced() {
        return isInvoiced;
    }

    public void setInvoiced(boolean invoiced) {
        isInvoiced = invoiced;
    }

    public boolean isReferralInvoiced() {
        return isReferralInvoiced;
    }

    public void setReferralInvoiced(boolean referralInvoiced) {
        isReferralInvoiced = referralInvoiced;
    }

    public boolean isEROrder() {
        return isEROrder;
    }

    public void setEROrder(boolean EROrder) {
        isEROrder = EROrder;
    }

    public boolean isCash() {
        return isCash;
    }

    public void setCash(boolean cash) {
        isCash = cash;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public boolean isCovered() {
        return isCovered;
    }

    public void setCovered(boolean covered) {
        isCovered = covered;
    }

    public Integer getDentalEstimationNo() {
        return dentalEstimationNo;
    }

    public void setDentalEstimationNo(Integer dentalEstimationNo) {
        this.dentalEstimationNo = dentalEstimationNo;
    }

    public Short getDentalEstimationLineItemNo() {
        return dentalEstimationLineItemNo;
    }

    public void setDentalEstimationLineItemNo(Short dentalEstimationLineItemNo) {
        this.dentalEstimationLineItemNo = dentalEstimationLineItemNo;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Integer getEditedBy() {
        return editedBy;
    }

    public void setEditedBy(Integer editedBy) {
        this.editedBy = editedBy;
    }

    public Date getEditedOn() {
        return editedOn;
    }

    public void setEditedOn(Date editedOn) {
        this.editedOn = editedOn;
    }

    public Boolean getUncoveredByDoctor() {
        return isUncoveredByDoctor;
    }

    public void setUncoveredByDoctor(Boolean uncoveredByDoctor) {
        isUncoveredByDoctor = uncoveredByDoctor;
    }

    public long getUniqueRowID() {
        return uniqueRowID;
    }

    public void setUniqueRowID(long uniqueRowID) {
        this.uniqueRowID = uniqueRowID;
    }

    public Integer getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(Integer orderSource) {
        this.orderSource = orderSource;
    }

    public Boolean getOrderSet() {
        return isOrderSet;
    }

    public void setOrderSet(Boolean orderSet) {
        isOrderSet = orderSet;
    }

    public Boolean getRefundable() {
        return isRefundable;
    }

    public void setRefundable(Boolean refundable) {
        isRefundable = refundable;
    }
}
