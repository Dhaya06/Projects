package com.csi.rcm.encounter.prognote.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "his_prognotepatientallergydisease")
public class PNAllergyDisease {

    @Id
    @Column(name = "appointmentno")
    private Integer appointmentno;

    @Column(name = "setupid")
    private Character SetupID;

    @Column(name = "projectid")
    private short ProjectID;

    @Column(name = "patienttype")
    private byte PatientType;

    @Column(name = "patientid")
    private int PatientID;

    @Column(name = "allergydiseasetype")
    private byte AllergyDiseaseType;

    @Column(name = "allergydiseaseid")
    private short AllergyDiseaseID;

    @Column(name = "episodeid")
    private Integer EpisodeID;

    @Column(name = "severity")
    private Byte Severity;

    @Column(name = "ischecked")
    private boolean IsChecked;

    @Column(name = "isupdatedbynurse")
    private boolean IsUpdatedByNurse;

    @Column(name = "remarks")
    private String Remarks;

    @Column(name = "status")
    private byte Status;

    @Column(name = "createdby")
    private int CreatedBy;

    @Column(name = "createdon")
    private Date CreatedOn;

    @Column(name = "editedby")
    private Integer EditedBy;

    @Column(name = "editedon")
    private Date EditedOn;

//    private Date RowVer;

    public Integer getAppointmentno() {
        return appointmentno;
    }

    public void setAppointmentno(Integer appointmentno) {
        this.appointmentno = appointmentno;
    }

    public Character getSetupID() {
        return SetupID;
    }

    public void setSetupID(Character setupID) {
        SetupID = setupID;
    }

    public short getProjectID() {
        return ProjectID;
    }

    public void setProjectID(short projectID) {
        ProjectID = projectID;
    }

    public byte getPatientType() {
        return PatientType;
    }

    public void setPatientType(byte patientType) {
        PatientType = patientType;
    }

    public int getPatientID() {
        return PatientID;
    }

    public void setPatientID(int patientID) {
        PatientID = patientID;
    }

    public byte getAllergyDiseaseType() {
        return AllergyDiseaseType;
    }

    public void setAllergyDiseaseType(byte allergyDiseaseType) {
        AllergyDiseaseType = allergyDiseaseType;
    }

    public short getAllergyDiseaseID() {
        return AllergyDiseaseID;
    }

    public void setAllergyDiseaseID(short allergyDiseaseID) {
        AllergyDiseaseID = allergyDiseaseID;
    }

    public Integer getEpisodeID() {
        return EpisodeID;
    }

    public void setEpisodeID(Integer episodeID) {
        EpisodeID = episodeID;
    }

    public Byte getSeverity() {
        return Severity;
    }

    public void setSeverity(Byte severity) {
        Severity = severity;
    }

    public boolean isChecked() {
        return IsChecked;
    }

    public void setChecked(boolean checked) {
        IsChecked = checked;
    }

    public boolean isUpdatedByNurse() {
        return IsUpdatedByNurse;
    }

    public void setUpdatedByNurse(boolean updatedByNurse) {
        IsUpdatedByNurse = updatedByNurse;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String remarks) {
        Remarks = remarks;
    }

    public byte getStatus() {
        return Status;
    }

    public void setStatus(byte status) {
        Status = status;
    }

    public int getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(int createdBy) {
        CreatedBy = createdBy;
    }

    public Date getCreatedOn() {
        return CreatedOn;
    }

    public void setCreatedOn(Date createdOn) {
        CreatedOn = createdOn;
    }

    public Integer getEditedBy() {
        return EditedBy;
    }

    public void setEditedBy(Integer editedBy) {
        EditedBy = editedBy;
    }

    public Date getEditedOn() {
        return EditedOn;
    }

    public void setEditedOn(Date editedOn) {
        EditedOn = editedOn;
    }
}
