package com.csi.rcm.prognote.widgets.document;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class EncounterSummaryWidjet extends WidgetData{

    @NotNull(message = "Patient Id must not be null")
    @NotEmpty(message = "Patient Id cannot be empty")
    private int patient_id;

    private String encounterStatus;
    private String patientName;
    private String patientGender;
    private int patientAge;
    private String insuvaraneDetails;
    private String encounterDetails;
    private String[] vitalSigns;
    private String cheifComplaint;
    private String[] primaryDiagnosis;
    private String[] secondaryDiagnosis;
    private String[] medications;
    private String[] doctorNotes;
    private String[] orders;
    private String allergies;

    public EncounterSummaryWidjet(int patient_id, String encounterStatus, String patientName, String patientGender, int patientAge, String insuvaraneDetails, String encounterDetails, String[] vitalSigns, String cheifComplaint, String[] primaryDiagnosis, String[] secondaryDiagnosis, String[] medications, String[] doctorNotes, String[] orders, String allergies) {
        this.patient_id = patient_id;
        this.encounterStatus = encounterStatus;
        this.patientName = patientName;
        this.patientGender = patientGender;
        this.patientAge = patientAge;
        this.insuvaraneDetails = insuvaraneDetails;
        this.encounterDetails = encounterDetails;
        this.vitalSigns = vitalSigns;
        this.cheifComplaint = cheifComplaint;
        this.primaryDiagnosis = primaryDiagnosis;
        this.secondaryDiagnosis = secondaryDiagnosis;
        this.medications = medications;
        this.doctorNotes = doctorNotes;
        this.orders = orders;
        this.allergies = allergies;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getEncounterStatus() {
        return encounterStatus;
    }

    public void setEncounterStatus(String encounterStatus) {
        this.encounterStatus = encounterStatus;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public String getInsuvaraneDetails() {
        return insuvaraneDetails;
    }

    public void setInsuvaraneDetails(String insuvaraneDetails) {
        this.insuvaraneDetails = insuvaraneDetails;
    }

    public String getEncounterDetails() {
        return encounterDetails;
    }

    public void setEncounterDetails(String encounterDetails) {
        this.encounterDetails = encounterDetails;
    }

    public String[] getVitalSigns() {
        return vitalSigns;
    }

    public void setVitalSigns(String[] vitalSigns) {
        this.vitalSigns = vitalSigns;
    }

    public String getCheifComplaint() {
        return cheifComplaint;
    }

    public void setCheifComplaint(String cheifComplaint) {
        this.cheifComplaint = cheifComplaint;
    }

    public String[] getPrimaryDiagnosis() {
        return primaryDiagnosis;
    }

    public void setPrimaryDiagnosis(String[] primaryDiagnosis) {
        this.primaryDiagnosis = primaryDiagnosis;
    }

    public String[] getSecondaryDiagnosis() {
        return secondaryDiagnosis;
    }

    public void setSecondaryDiagnosis(String[] secondaryDiagnosis) {
        this.secondaryDiagnosis = secondaryDiagnosis;
    }

    public String[] getMedications() {
        return medications;
    }

    public void setMedications(String[] medications) {
        this.medications = medications;
    }

    public String[] getDoctorNotes() {
        return doctorNotes;
    }

    public void setDoctorNotes(String[] doctorNotes) {
        this.doctorNotes = doctorNotes;
    }

    public String[] getOrders() {
        return orders;
    }

    public void setOrders(String[] orders) {
        this.orders = orders;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }
}
