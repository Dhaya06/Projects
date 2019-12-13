package com.csi.rcm.encounter.prognote.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "his_prognotevitalsign")
public class PNVitalSign {

    @EmbeddedId
    private PNVitalSignKey pnVitalSignKey;

    @Column(name = "appointmentno")
    private int appointmentno;

    @Column(name = "patienttype")
    private byte PatientType;

    @Column(name = "patientid")
    private int PatientID;

    @Column(name = "weightkg")
    private double WeightKg;

    @Column(name = "heightcm")
    private double HeightCm;

    @Column(name = "bodymassindex")
    private double BodyMassIndex;

    @Column(name = "headcircumcm")
    private double HeadCircumCm;

    @Column(name = "leanbodyweightlbs")
    private double LeanBodyWeightLbs;

    @Column(name = "idealbodyweightlbs")
    private double IdealBodyWeightLbs;

    @Column(name = "temperaturecelcius")
    private double TemperatureCelcius;

    @Column(name = "temperaturecelciusmethod")
    private Byte TemperatureCelciusMethod;

    @Column(name = "pulsebeatperminute")
    private Byte PulseBeatPerMinute;

    @Column(name = "pulserhythm")
    private Byte PulseRhythm;

    @Column(name = "respirationbeatperminute")
    private float RespirationBeatPerMinute;

    @Column(name = "respirationpattern")
    private Byte RespirationPattern;

    @Column(name = "bloodpressurelower")
    private short BloodPressureLower;

    @Column(name = "bloodpressurehigher")
    private short BloodPressureHigher;

    @Column(name = "bloodpressurecufflocation")
    private Byte BloodPressureCuffLocation;

    @Column(name = "bloodpressurecuffsize")
    private double BloodPressureCuffSize;

    @Column(name = "bloodpressurepatientposition")
    private Byte BloodPressurePatientPosition;

    @Column(name = "sao2")
    private Byte SAO2;

    @Column(name = "fio2")
    private Byte FIO2;

    @Column(name = "painscore")
    private Byte PainScore;

    @Column(name = "painlocation")
    private String PainLocation;

    @Column(name = "paincharacter")
    private String PainCharacter;

    @Column(name = "painfrequency")
    private String PainFrequency;

    @Column(name = "ispainmanagementdone")
    private boolean IsPainManagementDone;

    @Column(name = "status")
    private byte Status;

    @Column(name = "isvitalsrequired")
    private boolean IsVitalsRequired;

    @Column(name = "triagecategory")
    private Byte TriageCategory;

    @Column(name = "gcscore")
    private Integer GCScore;

    @Column(name = "createdby")
    private int CreatedBy;

    @Column(name = "createdon")
    private Date CreatedOn;

    @Column(name = "editedby")
    private Integer EditedBy;

    @Column(name = "editedon")
    private Date EditedOn;

//    @Column(name = "")
//    private timestamp RowVer;

    @Column(name = "painpolicyno")
    private Byte PainPolicyNo;

    @Column(name = "painscale", nullable = true)
    private Short PainScale;

    public PNVitalSignKey getPnVitalSignKey() {
        return pnVitalSignKey;
    }

    public void setPnVitalSignKey(PNVitalSignKey pnVitalSignKey) {
        this.pnVitalSignKey = pnVitalSignKey;
    }

    public int getAppointmentno() {
        return appointmentno;
    }

    public void setAppointmentno(int appointmentno) {
        this.appointmentno = appointmentno;
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

    public double getWeightKg() {
        return WeightKg;
    }

    public void setWeightKg(double weightKg) {
        WeightKg = weightKg;
    }

    public double getHeightCm() {
        return HeightCm;
    }

    public void setHeightCm(double heightCm) {
        HeightCm = heightCm;
    }

    public double getBodyMassIndex() {
        return BodyMassIndex;
    }

    public void setBodyMassIndex(double bodyMassIndex) {
        BodyMassIndex = bodyMassIndex;
    }

    public double getHeadCircumCm() {
        return HeadCircumCm;
    }

    public void setHeadCircumCm(double headCircumCm) {
        HeadCircumCm = headCircumCm;
    }

    public double getLeanBodyWeightLbs() {
        return LeanBodyWeightLbs;
    }

    public void setLeanBodyWeightLbs(double leanBodyWeightLbs) {
        LeanBodyWeightLbs = leanBodyWeightLbs;
    }

    public double getIdealBodyWeightLbs() {
        return IdealBodyWeightLbs;
    }

    public void setIdealBodyWeightLbs(double idealBodyWeightLbs) {
        IdealBodyWeightLbs = idealBodyWeightLbs;
    }

    public double getTemperatureCelcius() {
        return TemperatureCelcius;
    }

    public void setTemperatureCelcius(double temperatureCelcius) {
        TemperatureCelcius = temperatureCelcius;
    }

    public Byte getTemperatureCelciusMethod() {
        return TemperatureCelciusMethod;
    }

    public void setTemperatureCelciusMethod(Byte temperatureCelciusMethod) {
        TemperatureCelciusMethod = temperatureCelciusMethod;
    }

    public Byte getPulseBeatPerMinute() {
        return PulseBeatPerMinute;
    }

    public void setPulseBeatPerMinute(Byte pulseBeatPerMinute) {
        PulseBeatPerMinute = pulseBeatPerMinute;
    }

    public Byte getPulseRhythm() {
        return PulseRhythm;
    }

    public void setPulseRhythm(Byte pulseRhythm) {
        PulseRhythm = pulseRhythm;
    }

    public float getRespirationBeatPerMinute() {
        return RespirationBeatPerMinute;
    }

    public void setRespirationBeatPerMinute(float respirationBeatPerMinute) {
        RespirationBeatPerMinute = respirationBeatPerMinute;
    }

    public Byte getRespirationPattern() {
        return RespirationPattern;
    }

    public void setRespirationPattern(Byte respirationPattern) {
        RespirationPattern = respirationPattern;
    }

    public short getBloodPressureLower() {
        return BloodPressureLower;
    }

    public void setBloodPressureLower(short bloodPressureLower) {
        BloodPressureLower = bloodPressureLower;
    }

    public short getBloodPressureHigher() {
        return BloodPressureHigher;
    }

    public void setBloodPressureHigher(short bloodPressureHigher) {
        BloodPressureHigher = bloodPressureHigher;
    }

    public Byte getBloodPressureCuffLocation() {
        return BloodPressureCuffLocation;
    }

    public void setBloodPressureCuffLocation(Byte bloodPressureCuffLocation) {
        BloodPressureCuffLocation = bloodPressureCuffLocation;
    }

    public double getBloodPressureCuffSize() {
        return BloodPressureCuffSize;
    }

    public void setBloodPressureCuffSize(double bloodPressureCuffSize) {
        BloodPressureCuffSize = bloodPressureCuffSize;
    }

    public Byte getBloodPressurePatientPosition() {
        return BloodPressurePatientPosition;
    }

    public void setBloodPressurePatientPosition(Byte bloodPressurePatientPosition) {
        BloodPressurePatientPosition = bloodPressurePatientPosition;
    }

    public Byte getSAO2() {
        return SAO2;
    }

    public void setSAO2(Byte SAO2) {
        this.SAO2 = SAO2;
    }

    public Byte getFIO2() {
        return FIO2;
    }

    public void setFIO2(Byte FIO2) {
        this.FIO2 = FIO2;
    }

    public Byte getPainScore() {
        return PainScore;
    }

    public void setPainScore(Byte painScore) {
        PainScore = painScore;
    }

    public String getPainLocation() {
        return PainLocation;
    }

    public void setPainLocation(String painLocation) {
        PainLocation = painLocation;
    }

    public String getPainCharacter() {
        return PainCharacter;
    }

    public void setPainCharacter(String painCharacter) {
        PainCharacter = painCharacter;
    }

    public String getPainFrequency() {
        return PainFrequency;
    }

    public void setPainFrequency(String painFrequency) {
        PainFrequency = painFrequency;
    }

    public boolean isPainManagementDone() {
        return IsPainManagementDone;
    }

    public void setPainManagementDone(boolean painManagementDone) {
        IsPainManagementDone = painManagementDone;
    }

    public byte getStatus() {
        return Status;
    }

    public void setStatus(byte status) {
        Status = status;
    }

    public boolean isVitalsRequired() {
        return IsVitalsRequired;
    }

    public void setVitalsRequired(boolean vitalsRequired) {
        IsVitalsRequired = vitalsRequired;
    }

    public Byte getTriageCategory() {
        return TriageCategory;
    }

    public void setTriageCategory(Byte triageCategory) {
        TriageCategory = triageCategory;
    }

    public Integer getGCScore() {
        return GCScore;
    }

    public void setGCScore(Integer GCScore) {
        this.GCScore = GCScore;
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

    public Byte getPainPolicyNo() {
        return PainPolicyNo;
    }

    public void setPainPolicyNo(Byte painPolicyNo) {
        PainPolicyNo = painPolicyNo;
    }

    public Short getPainScale() {
        return PainScale;
    }

    public void setPainScale(Short painScale) {
        PainScale = painScale;
    }
}
