package com.csi.vidaplus.rcm.claim.service;

import com.csi.vidaplus.rcm.claim.entity.Claim;

import java.util.List;

/**
 * Created by Ahsan on 2/4/2018.
 */
public interface RuleExecutorService {

    List<Claim> validateClaims(List<Claim> claimList);

    Claim validateClaim(Claim claim);
}
