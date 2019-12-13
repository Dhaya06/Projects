package com.csi.vidaplus.rcm.claim.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Ahsan on 2/17/2018.
 */
@Entity
@Table(name = "nurse_notes")
public class NurseNotes extends BaseEntity {
    @Column(name = "nurse_notes_id")
    private String nurseNotesId;
    @Column(name = "nurse_name")
    private String nurseName;
    @Column(name = "nurse_notes")
    private String nurseNotes;
    @Column(name = "inspectedDateTime")
    private Date inspectedDateTime;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="claim_id")
    private Claim claim;

    public String getNurseNotesId() {
        return nurseNotesId;
    }

    public void setNurseNotesId(String nurseNotesId) {
        this.nurseNotesId = nurseNotesId;
    }

    public String getNurseNotes() {
        return nurseNotes;
    }

    public void setNurseNotes(String nurseNotes) {
        this.nurseNotes = nurseNotes;
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

    public String getNurseName() {
        return nurseName;
    }

    public void setNurseName(String nurseName) {
        this.nurseName = nurseName;
    }
}
