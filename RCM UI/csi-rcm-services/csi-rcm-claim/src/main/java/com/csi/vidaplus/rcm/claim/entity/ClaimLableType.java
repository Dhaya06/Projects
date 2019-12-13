package com.csi.vidaplus.rcm.claim.entity;

/**
 * Created by Ahsan on 2/16/2018.
 */
public enum ClaimLableType {
    TECHNICAL_ERROR(1),
    MEDICAL_ERROR(2),
    BOTH_ERROR(3);

    private Integer claimLableType;

    ClaimLableType(Integer claimlabel) {
        this.claimLableType = claimlabel;
    }

    public Integer getCode() {
        return claimLableType;
    }
}
