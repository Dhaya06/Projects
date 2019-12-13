package com.csi.rcm.prognote.widgets.document;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class NurseNoteWidjet extends WidgetData{

    @NotNull(message = "Patient Id must not be null")
    @NotEmpty(message = "Patient Id cannot be empty")
    private int patient_id;
    private String date;
    private String nurseName;
    private String nurseNote;

    public NurseNoteWidjet(int patient_id, String date, String nurseName, String nurseNote) {
        this.patient_id = patient_id;
        this.date = date;
        this.nurseName = nurseName;
        this.nurseNote = nurseNote;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNurseName() {
        return nurseName;
    }

    public void setNurseName(String nurseName) {
        this.nurseName = nurseName;
    }

    public String getNurseNote() {
        return nurseNote;
    }

    public void setNurseNote(String nurseNote) {
        this.nurseNote = nurseNote;
    }
}
