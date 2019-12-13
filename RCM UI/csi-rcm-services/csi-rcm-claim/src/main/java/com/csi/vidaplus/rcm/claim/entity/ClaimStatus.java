package com.csi.vidaplus.rcm.claim.entity;

/**
 * Created by Ahsan on 2/4/2018.
 */
public enum ClaimStatus {
    NEW("NEW"),
    REVIEW("REVIEW"),
    SUBMITTED("SUBMISSION"),
    RESUBMITTED("RESUBMISSION");

    private String status;

    ClaimStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }
}
