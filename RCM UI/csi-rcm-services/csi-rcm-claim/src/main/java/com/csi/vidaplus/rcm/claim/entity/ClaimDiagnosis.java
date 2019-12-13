package com.csi.vidaplus.rcm.claim.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Ahsan on 2/4/2018.
 */
@Entity
@Table(name="claim_diagnosis")
public class ClaimDiagnosis extends BaseEntity {
    //@NotBlank(message="diagnosis type is required")
    //@NotNull(message="diagnosis type is required")
    @Column(name="diagnosis_type")
    private String diagnosisType; // Principal,Secondary,Admitting

    //@NotBlank(message="diagnosis code is required")
    //@NotNull(message="diagnosis code is required")
    @Column(name="diagnosis_code")
    private String diagnosisCode; // ICD-10 code,

    @Column(name="reference_no")
    private String referenceNo;

    @Column(name="description")
    private String description;

    @Column(name="processed")
    private boolean processed;

    @Column(name="remarks")
    private String remarks;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="claim_id")
    //@JsonBackReference(value = "diagnosis")
    private Claim claim;

    //@NotBlank(message="encounter id is required")
    //@NotNull(message="encounter id is required")
    @Column(name="encounter_id")
    private String encounterId;

    public String getDiagnosisType() {
        return diagnosisType;
    }

    public void setDiagnosisType(String diagnosisType) {
        this.diagnosisType = diagnosisType;
    }

    public String getDiagnosisCode() {
        return diagnosisCode;
    }

    public void setDiagnosisCode(String diagnosisCode) {
        this.diagnosisCode = diagnosisCode;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getEncounterId() {
        return encounterId;
    }

    public void setEncounterId(String encounterId) {
        this.encounterId = encounterId;
    }

    public Claim getClaim() {
        return claim;
    }

    public void setClaim(Claim claim) {
        this.claim = claim;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
