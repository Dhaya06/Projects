package com.csi.vidaplus.rcm.claim.entity;

/**
 * Created by Ahsan on 2/17/2018.
 */
public enum ClaimStage {
    NEW("NEW"),
    INPROGRESS("INPROGRESS"),
    COMPLETE("COMPLETE");

    private String stage;

    ClaimStage(String status) {
        this.stage = status;
    }

    @Override
    public String toString() {
        return stage;
    }

}
