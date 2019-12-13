
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
@Table(name = "appointments")
public class Appointment extends BaseEntity {

    @Column(name = "appointment_no")
    private String appointmentNo;

    @Min(value = 0)
    @Column(name = "appointment_gross")
    private Double grossAmount;

    @Min(value = 0)
    @Column(name = "appointment_net")
    private Double netAmount;

    @Min(value = 0)
    @Column(name = "appointment_discount")
    private Double discount;

    @Min(value = 0)
    @Column(name = "appointment_company_share")
    private Double companyShare;

    @Min(value = 0)
    @Column(name = "appointment_patient_share")
    private Double patientShare;

    @Column(name="quantity")
    private Double quantity;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="claim_id")
    private Claim claim;

    //@Valid
    //@NotEmpty(message = "At least one invoice is required for a claim")
    @Fetch(value = FetchMode.SELECT)
    @OneToMany(mappedBy = "appointment", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Invoice> invoices;

    public String getAppointmentNo() {
        return appointmentNo;
    }

    public void setAppointmentNo(String appointmentNo) {
        this.appointmentNo = appointmentNo;
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

    public Claim getClaim() {
        return claim;
    }

    public void setClaim(Claim claim) {
        this.claim = claim;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}

