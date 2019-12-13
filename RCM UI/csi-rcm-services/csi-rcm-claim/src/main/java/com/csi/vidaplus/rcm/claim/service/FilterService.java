package com.csi.vidaplus.rcm.claim.service;

import com.csi.vidaplus.rcm.claim.entity.Claim;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Created by Ahsan on 2/15/2018.
 */
public interface FilterService {

    String assignClaimsToWorkList(List<Claim> claimList);
}
