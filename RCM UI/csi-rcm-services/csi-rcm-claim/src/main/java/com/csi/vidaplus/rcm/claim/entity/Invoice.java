
package com.csi.vidaplus.rcm.claim.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Table(name = "invoices")
public class Invoice extends BaseEntity{

    @Column(name = "invoice_no")
    private String invoiceNo;

    //@Min(value = 0)
    @Column(name = "invoice_gross_amount")
    private Double grossAmount;

    //@Min(value = 0)
    @Column(name = "invoice_net_amount")
    private Double netAmount;

    //@Min(value = 0)
    @Column(name = "invoice_discount")
    private Double discount;

    //@Min(value = 0)
    @Column(name = "invoice_company_share")
    private Double companyShare;

    //@Min(value = 0)
    @Column(name = "invoice_patient_share")
    private Double patientShare;

    @Column(name="quantity")
    private Double quantity;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="appointment_id")
    private Appointment appointment;

    //@Valid
    //@NotEmpty(message = "At least one activity is required for a claim")
    @Fetch(value = FetchMode.SELECT)
    @OneToMany(mappedBy = "activities", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ClaimActivity> encounterActivities;

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public Double getGrossAmount() {
        return grossAmount;
    }

    public void setGrossAmount(Double grossAmount) {
        this.grossAmount = grossAmount;
    }

    public Double getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(Double netAmount) {
        this.netAmount = netAmount;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getCompanyShare() {
        return companyShare;
    }

    public void setCompanyShare(Double companyShare) {
        this.companyShare = companyShare;
    }

    public Double getPatientShare() {
        return patientShare;
    }

    public void setPatientShare(Double patientShare) {
        this.patientShare = patientShare;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public List<ClaimActivity> getEncounterActivities() {
        return encounterActivities;
    }

    public void setEncounterActivities(List<ClaimActivity> encounterActivities) {
        this.encounterActivities = encounterActivities;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}

