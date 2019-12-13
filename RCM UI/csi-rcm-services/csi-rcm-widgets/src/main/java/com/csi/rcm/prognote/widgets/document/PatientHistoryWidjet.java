package com.csi.rcm.prognote.widgets.document;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class PatientHistoryWidjet extends WidgetData{

    @NotNull(message = "Patient Id must not be null")
    @NotEmpty(message = "Patient Id cannot be empty")
    private int patient_id;
    private String category;
    private String period;
    private String details;

    public PatientHistoryWidjet(int patient_id, String category, String period, String details) {
        this.patient_id = patient_id;
        this.category = category;
        this.period = period;
        this.details = details;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
