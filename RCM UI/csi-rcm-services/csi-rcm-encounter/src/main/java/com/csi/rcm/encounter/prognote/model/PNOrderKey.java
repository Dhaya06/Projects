package com.csi.rcm.encounter.prognote.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class PNOrderKey implements Serializable{

    @Column(name = "setupid")
    private Character setupID;

    @Column(name = "projectid")
    private short projectID;

    @Column(name = "episodeid")
    private int episodeID;

    @Column(name = "procedureid")
    private String procedureId;

    @Column(name = "lineitemno")
    private short lineItemNo;

    @Column(name = "orderdate")
    private Date orderDate;

    public Character getSetupID() {
        return setupID;
    }

    public void setSetupID(Character setupID) {
        this.setupID = setupID;
    }

    public short getProjectID() {
        return projectID;
    }

    public void setProjectID(short projectID) {
        this.projectID = projectID;
    }

    public int getEpisodeID() {
        return episodeID;
    }

    public void setEpisodeID(int episodeID) {
        this.episodeID = episodeID;
    }

    public String getProcedureId() {
        return procedureId;
    }

    public void setProcedureId(String procedureId) {
        this.procedureId = procedureId;
    }

    public short getLineItemNo() {
        return lineItemNo;
    }

    public void setLineItemNo(short lineItemNo) {
        this.lineItemNo = lineItemNo;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
