package com.csi.vidaplus.rcm.claim.service;

import com.csi.vidaplus.rcm.claim.entity.Claim;
import com.csi.vidaplus.rcm.claim.request.ClaimSearchModel;

import java.util.List;

/**
 * Created by Ahsan on 2/4/2018.
 */
public interface ClaimService {
    void add(Claim claim);

    void addAll(List<Claim> claimList);

    void edit(Claim claim);

    void editAll(List<Claim> claimList);

    List<Claim> getAll();

    Claim getById(String id);

    void deleteById(String id);

    void deleteAll();
    
    List<Claim> search(ClaimSearchModel searchModel);

}
