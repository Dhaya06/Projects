package com.csi.vidaplus.rcm.claim.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Ahsan on 2/17/2018.
 */
@Entity
@Table(name = "doctor_notes")
public class DoctorNotes extends BaseEntity {

    @Column(name = "doctor_notes_id")
    private String doctorNotesId;
    @Column(name = "doctor_name")
    private String doctorName;
    @Column(name = "doctor_notes")
    private String doctorNotes;
    @Column(name = "inspectedDateTime")
    private Date inspectedDateTime;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="claim_id")
    private Claim claim;

    public String getDoctorNotesId() {
        return doctorNotesId;
    }

    public void setDoctorNotesId(String doctorNotesId) {
        this.doctorNotesId = doctorNotesId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorNotes() {
        return doctorNotes;
    }

    public void setDoctorNotes(String doctorNotes) {
        this.doctorNotes = doctorNotes;
    }

    public Date getInspectedDateTime() {
        return inspectedDateTime;
    }

    public void setInspectedDateTime(Date inspectedDateTime) {
        this.inspectedDateTime = inspectedDateTime;
    }

    public Claim getClaim() {
        return claim;
    }

    public void setClaim(Claim claim) {
        this.claim = claim;
    }
}
