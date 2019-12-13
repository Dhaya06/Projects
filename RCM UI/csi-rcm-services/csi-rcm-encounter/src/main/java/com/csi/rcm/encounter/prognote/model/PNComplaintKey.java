package com.csi.rcm.encounter.prognote.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;

@Embeddable
public class PNComplaintKey implements Serializable{

    @Column(name = "setupid")
    private Character SetupID;

    @Column(name = "projectid")
    private short ProjectID;

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
