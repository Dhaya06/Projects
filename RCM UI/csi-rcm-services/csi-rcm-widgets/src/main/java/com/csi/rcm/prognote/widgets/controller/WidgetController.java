package com.csi.rcm.prognote.widgets.controller;


import com.csi.rcm.prognote.widgets.document.EncounterSummaryWidjet;
import com.csi.rcm.prognote.widgets.document.NurseNoteWidjet;
import com.csi.rcm.prognote.widgets.document.PatientHistoryWidjet;
import io.swagger.annotations.Api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin
@Api(basePath = "/ ", value = "Widget Data", description = "All services related to Widget Data", produces = "application/json")
@RestController

public class WidgetController {

	@CrossOrigin
    @GetMapping("/encounterSummeryWidgetData/{patientId}")
    public EncounterSummaryWidjet getEncounterSummeryWidgetData(@PathVariable int patientId){

        String[] vitalSigns = new String[3];
        vitalSigns[0] = "vitalSigns1";
        vitalSigns[1] = "vitalSigns2";
        vitalSigns[2] = "vitalSigns3";

        String[] primaryDiagnosis = new String[3];
        primaryDiagnosis[0] = "primaryDiagnosis1";
        primaryDiagnosis[1] = "primaryDiagnosis2";
        primaryDiagnosis[2] = "primaryDiagnosis3";

        String[] secondaryDiagnosis = new String[3];
        secondaryDiagnosis[0] = "secondaryDiagnosis1";
        secondaryDiagnosis[1] = "secondaryDiagnosis2";
        secondaryDiagnosis[2] = "secondaryDiagnosis3";

        String[] medications = new String[3];
        medications[0] = "medications1";
        medications[1] = "medications2";
        medications[2] = "medications3";

        String[] doctorNotes = new String[3];
        doctorNotes[0] = "doctorNotes1";
        doctorNotes[1] = "doctorNotes2";
        doctorNotes[2] = "doctorNotes3";

        String[] orders = new String[3];
        orders[0] = "orders1";
        orders[1] = "orders2";
        orders[2] = "orders3";

        if (patientId == 1) {
            EncounterSummaryWidjet encounterSummaryWidjet1 =
                    new EncounterSummaryWidjet(
                            1,
                            "encounter status1",
                            "patientname1",
                            "patientgender1",
                            30,
                            "insuarancedetails1",
                            "encounterdetails1",
                            vitalSigns,
                            "ChiefComplaint1",
                            primaryDiagnosis,
                            secondaryDiagnosis,
                            medications,
                            doctorNotes,
                            orders,
                            "allergies1"
                    );

            return encounterSummaryWidjet1;
        } else if(patientId == 2){
            EncounterSummaryWidjet encounterSummaryWidjet2 =
                    new EncounterSummaryWidjet(
                            2,
                            "encounter status2",
                            "patientname2",
                            "patientgender2",
                            30,
                            "insuarancedetails2",
                            "encounterdetails2",
                            vitalSigns,
                            "ChiefComplaint2",
                            primaryDiagnosis,
                            secondaryDiagnosis,
                            medications,
                            doctorNotes,
                            orders,
                            "allergies2"
                    );

            return encounterSummaryWidjet2;
        } else if (patientId == 3){
            EncounterSummaryWidjet encounterSummaryWidjet3 =
                    new EncounterSummaryWidjet(
                            3,
                            "encounter status3",
                            "patientname3",
                            "patientgender3",
                            30,
                            "insuarancedetails3",
                            "encounterdetails3",
                            vitalSigns,
                            "",
                            primaryDiagnosis,
                            secondaryDiagnosis,
                            medications,
                            doctorNotes,
                            orders,
                            "allergies3"
                    );

            return encounterSummaryWidjet3;
        }
        return null;
    }

	@CrossOrigin
    @GetMapping("/nurseNoteWidgetData/{patientId}")
    public NurseNoteWidjet getNurseNoteWidgetData(@PathVariable int patientId){
        if (patientId == 1){
            NurseNoteWidjet nurseNoteWidjet1 = new NurseNoteWidjet(
                    1,
                    "2018-10-10",
                    "nurseName1",
                    "nurseNote1"
            );
            return nurseNoteWidjet1;

        } else if (patientId == 2) {
            NurseNoteWidjet nurseNoteWidjet2 = new NurseNoteWidjet(
                    1,
                    "2018-10-10",
                    "nurseName2",
                    "nurseNote2"
            );
            return nurseNoteWidjet2;

        } else if (patientId == 3) {
            NurseNoteWidjet nurseNoteWidjet3 = new NurseNoteWidjet(
                    1,
                    "2018-10-10",
                    "nurseName3",
                    "nurseNote3"
            );
            return nurseNoteWidjet3;

        }

        return null;
    }

	@CrossOrigin
    @GetMapping("/patientHistoryWidgetData/{patientId}")
    public PatientHistoryWidjet getPatientHistoryWidgetData(@PathVariable int patientId){

        if (patientId == 1){
            PatientHistoryWidjet patientHistoryWidjet1 = new PatientHistoryWidjet(
                    1,
                    "2018-10-10",
                    "patientHistory1",
                    "patientHistory1"
            );

            return patientHistoryWidjet1;

        } else if (patientId == 2) {
            PatientHistoryWidjet patientHistoryWidjet2 = new PatientHistoryWidjet(
                    1,
                    "2018-10-10",
                    "patientHistory2",
                    "patientHistory2"
            );
            return patientHistoryWidjet2;

        } else if (patientId == 3) {
            PatientHistoryWidjet patientHistoryWidjet3 = new PatientHistoryWidjet(
                    1,
                    "2018-10-10",
                    "patientHistory3",
                    "patientHistory3"
            );
            return patientHistoryWidjet3;

        }

        return null;
    }


}
