package com.csi.rcm.encounter.prognote.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PNVitalSignKey implements Serializable{

    @Column(name = "setupid")
    private Character setupid;

    @Column(name = "projectid")
    private short projectid;

    public Character getSetupid() {
        return setupid;
    }

    public void setSetupid(Character setupid) {
        this.setupid = setupid;
    }

    public short getProjectid() {
        return projectid;
    }

    public void setProjectid(short projectid) {
        this.projectid = projectid;
    }
}
