package com.csi.vidaplus.rcm.claim.entity;

/**
 * Created by Ahsan on 2/14/2018.
 */
public enum ClaimLabel {
    CLEAN(0),
    ERROR(1);

    private Integer claimlabel;

    ClaimLabel(Integer claimlabel) {
        this.claimlabel = claimlabel;
    }

    public Integer getCode() {
        return claimlabel;
    }
}
