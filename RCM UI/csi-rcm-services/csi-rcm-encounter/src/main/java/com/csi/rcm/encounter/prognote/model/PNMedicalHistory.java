package com.csi.rcm.encounter.prognote.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "his_prognotemedicalhistory")
public class PNMedicalHistory implements Serializable{

    @Id
    @Column(name = "projectid")
    private short projectID;

    @Column(name = "setupid")
    private Character setupID;

    @Column(name = "patientid")
    private int PatientID;

    @Column(name = "patienttype")
    private byte patientType;

    @Column(name = "historytype")
    private byte HistoryType;

    @Column(name = "historyid")
    private byte HistoryId;

    @Column(name = "appointmentno")
    private int AppointmentNo;

    @Column(name = "episodeid")
    private int EpisodeID;

    @Column(name = "ischecked")
    private boolean IsChecked;

    @Column(name = "remarks")
    private String Remarks;

    @Column(name = "status")
    private byte Status;

    @Column(name = "createdby")
    private int CreatedBy;

//    private smalldatetime CreatedOn

    @Column(name = "editedby")
    private int EditedBy;

//    private smalldatetime EditedOn
//    private timestamp RowVer

    public short getProjectID() {
        return projectID;
    }

    public void setProjectID(short projectID) {
        this.projectID = projectID;
    }

    public Character getSetupID() {
        return setupID;
    }

    public void setSetupID(Character setupID) {
        this.setupID = setupID;
    }

    public int getPatientID() {
        return PatientID;
    }

    public void setPatientID(int patientID) {
        PatientID = patientID;
    }

    public byte getPatientType() {
        return patientType;
    }

    public void setPatientType(byte patientType) {
        this.patientType = patientType;
    }

    public int getAppointmentNo() {
        return AppointmentNo;
    }

    public void setAppointmentNo(int appointmentNo) {
        AppointmentNo = appointmentNo;
    }

    public int getEpisodeID() {
        return EpisodeID;
    }

    public void setEpisodeID(int episodeID) {
        EpisodeID = episodeID;
    }

    public boolean isChecked() {
        return IsChecked;
    }

    public void setChecked(boolean checked) {
        IsChecked = checked;
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

    public int getEditedBy() {
        return EditedBy;
    }

    public void setEditedBy(int editedBy) {
        EditedBy = editedBy;
    }

    public byte getHistoryType() {
        return HistoryType;
    }

    public void setHistoryType(byte historyType) {
        HistoryType = historyType;
    }

    public byte getHistoryId() {
        return HistoryId;
    }

    public void setHistoryId(byte historyId) {
        HistoryId = historyId;
    }
}
