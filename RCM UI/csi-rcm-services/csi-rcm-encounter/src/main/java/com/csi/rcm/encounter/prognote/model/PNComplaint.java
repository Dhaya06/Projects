package com.csi.rcm.encounter.prognote.model;

import javax.persistence.*;

@Entity
@Table(name = "his_prognotecomplaint")
public class PNComplaint {

    @EmbeddedId
    private PNComplaintKey complaintKey;

    @Column(name = "appointmentno")
    private int appointmentno;

    @Column(name = "patienttype")
    private byte PatientType;

    @Column(name = "patientid")
    private int PatientID;

    @Column(name = "nursecomment")
    private String NurseComment;

    @Column(name = "doctorcomment")
    private String DoctorComment;

    @Column(name = "status")
    private byte Status;

    @Column(name = "createdby")
    private int CreatedBy;

//    @Column(name = "createdon")
//    private smalldatetime CreatedOn;

    @Column(name = "editedby")
    private int EditedBy;

//    @Column(name = "editedon")
//    private smalldatetime EditedOn;
//
//    @Column(name = "rowver")
//    private timestamp RowVer;


    public int getAppointmentno() {
        return appointmentno;
    }

    public void setAppointmentno(int appointmentno) {
        this.appointmentno = appointmentno;
    }

    public PNComplaintKey getComplaintKey() {
        return complaintKey;
    }

    public void setComplaintKey(PNComplaintKey complaintKey) {
        this.complaintKey = complaintKey;
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

    public String getNurseComment() {
        return NurseComment;
    }

    public void setNurseComment(String nurseComment) {
        NurseComment = nurseComment;
    }

    public String getDoctorComment() {
        return DoctorComment;
    }

    public void setDoctorComment(String doctorComment) {
        DoctorComment = doctorComment;
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

}
