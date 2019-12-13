package com.csi.rcm.encounter.prognote.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "his_prognotemedicine")
public class PNMedicine {

    @Id
    @Column(name = "appointmentno")
    private int AppointmentNo;

    @Column(name = "patientid")
    private int PatientID;

    public PNMedicine() {
    }

    public PNMedicine(int appointmentNo, int patientID) {
        AppointmentNo = appointmentNo;
        PatientID = patientID;
    }

    public int getAppointmentNo() {
        return AppointmentNo;
    }

    public void setAppointmentNo(int appointmentNo) {
        AppointmentNo = appointmentNo;
    }

    public int getPatientID() {
        return PatientID;
    }

    public void setPatientID(int patientID) {
        PatientID = patientID;
    }
}
