
package com.csi.vidaplus.rcm.claim.service.impl;

import com.csi.vidaplus.rcm.claim.entity.Claim;
import com.csi.vidaplus.rcm.claim.model.response.ClaimResponse;
import com.csi.vidaplus.rcm.claim.repository.ClaimRepository;
import com.csi.vidaplus.rcm.claim.repository.specification.ClaimSpecification;
import com.csi.vidaplus.rcm.claim.request.ClaimSearchModel;
import com.csi.vidaplus.rcm.claim.service.ClaimService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by Ahsan on 2/4/2018.
 */
@Service
public class ClaimServiceImpl implements ClaimService {
    private static Logger logger = LogManager.getLogger(ClaimServiceImpl.class);

    @Autowired
    private ClaimRepository claimRepository;

    public void add(Claim claim){
        claimRepository.save(claim);
    }

    public void addAll(List<Claim> claimList){
        claimRepository.save(claimList);
    }

    public void editAll(List<Claim> claimList){
        claimRepository.save(claimList);
    }

    public void edit(Claim claim){
        claimRepository.save(claim);
    }

    @Override
    public List<Claim> getAll() {
        return claimRepository.findAll();
    }

    @Override
    public Claim getById(String id) {
        return claimRepository.findOne(id);
    }

    @Override
    public void deleteById(String id) {
        claimRepository.delete(id);
    }

    @Override
    public void deleteAll() {
        claimRepository.deleteAll();
    }
    
    @Override
    public List<Claim> search(ClaimSearchModel searchModel) {
    	return claimRepository.findAll(ClaimSpecification.searchClaim(searchModel));
    }
    
}
