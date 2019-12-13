package com.csi.rcm.encounter.prognote.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "his_prognotecheifcomplaint")
public class PNChiefComplaint {

    @Column(name = "setupid")
    private Character SetupID;

    @Column(name = "projectid")
    private short ProjectID;

    @Id
    @Column(name = "appointmentno")
    private int appointmentno;

    @Column(name = "episodeid")
    private int EpisodeID;

    @Column(name = "patienttype")
    private byte PatientType;

    @Column(name = "patientid")
    private int PatientID;

    @Column(name = "ccdate")
    private Date CCDate;

    @Column(name = "chiefcomplaint")
    private String ChiefComplaint;

    @Column(name = "hopi")
    private String HOPI;

    @Column(name = "currentmedication")
    private String CurrentMedication;

    @Column(name = "status")
    private byte status;

    @Column(name = "createdby")
    private int createdBy;

    @Column(name = "createdon")
    private Date createdOn;

    @Column(name = "editedby")
    private Integer editedBy;

    @Column(name = "editedon")
    private Date editedOn;

//    @Column(name = "rowver")
//    private timestamp RowVer;


    public int getEpisodeID() {
        return EpisodeID;
    }

    public void setEpisodeID(int episodeID) {
        EpisodeID = episodeID;
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

    public Date getCCDate() {
        return CCDate;
    }

    public void setCCDate(Date CCDate) {
        this.CCDate = CCDate;
    }

    public String getHOPI() {
        return HOPI;
    }

    public void setHOPI(String HOPI) {
        this.HOPI = HOPI;
    }

    public String getCurrentMedication() {
        return CurrentMedication;
    }

    public void setCurrentMedication(String currentMedication) {
        CurrentMedication = currentMedication;
    }

    public int getAppointmentno() {
        return appointmentno;
    }

    public void setAppointmentno(int appointmentno) {
        this.appointmentno = appointmentno;
    }

    public void setEditedBy(Integer editedBy) {
        this.editedBy = editedBy;
    }

    public String getChiefComplaint() {
        return ChiefComplaint;
    }

    public void setChiefComplaint(String chiefComplaint) {
        ChiefComplaint = chiefComplaint;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
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

    public int getEditedBy() {
        return editedBy;
    }

    public void setEditedBy(int editedBy) {
        this.editedBy = editedBy;
    }

    public Date getEditedOn() {
        return editedOn;
    }

    public void setEditedOn(Date editedOn) {
        this.editedOn = editedOn;
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
}
