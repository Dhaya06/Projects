package com.csi.vidaplus.rcm.claim.controller;

import java.util.*;

import com.csi.vidaplus.rcm.claim.entity.ClaimStatus;
import com.csi.vidaplus.rcm.claim.service.FilterService;
import com.csi.vidaplus.rcm.claim.service.RuleExecutorService;
import com.csi.vidaplus.rcm.claim.util.Constants;
import com.csi.vidaplus.rcm.claim.util.Mapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.csi.vidaplus.rcm.claim.entity.Claim;
import com.csi.vidaplus.rcm.claim.request.ClaimSearchModel;
import com.csi.vidaplus.rcm.claim.service.ClaimService;

@RestController
@CrossOrigin
public class ClaimController {
    private static Logger logger = LogManager.getLogger(ClaimController.class);

    @Autowired
    private FilterService filterService;
    @Autowired
    private ClaimService claimService;
    @Autowired
    private RuleExecutorService ruleExecutorService;

    @PostMapping("/validateAssignClaims")
    public ResponseEntity<String> validateAndAssignClaims(@RequestBody List<Claim> claimList) {
        claimList.forEach(claim -> {
            Mapper.mapClaim(claim);
            claim.setClaimStatus(ClaimStatus.NEW);
        });
        List<Claim> processedClaims=ruleExecutorService.validateClaims(claimList);
        String response=filterService.assignClaimsToWorkList(processedClaims);
        if(response== Constants.CLAIM_SUCCESS_RESPONSE){
            return new ResponseEntity<String>(response,new HttpHeaders(),HttpStatus.OK);
        }
        else{
            return new ResponseEntity<String>(response,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/validateClaims")
    public ResponseEntity<List<Claim>> validateClaims(@RequestBody List<Claim> claimList) {
        claimList.forEach(claim -> {
            Mapper.mapClaim(claim);
        });
        List<Claim> processedClaims=ruleExecutorService.validateClaims(claimList);
        if(processedClaims.size()>0){
            claimService.editAll(claimList);
            return new ResponseEntity<>(processedClaims,new HttpHeaders(),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/validateClaim")
    public ResponseEntity<Claim> validateClaim(@RequestBody Claim claim) {
        Mapper.mapClaim(claim);
        Claim processedClaim=ruleExecutorService.validateClaim(claim);
        if(processedClaim!=null){
            claimService.edit(processedClaim);
            return new ResponseEntity<>(processedClaim,new HttpHeaders(),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/runSystemValidation")
    public ResponseEntity<Claim> runSystemValidation(@RequestBody Claim claim) {
        Mapper.mapClaim(claim);
        Claim processedClaim=ruleExecutorService.validateClaim(claim);
        if(processedClaim!=null){
            return new ResponseEntity<>(processedClaim,new HttpHeaders(),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/validateEncounters")
    public ResponseEntity<String> validateEncounters(@RequestBody List<Claim> claimList) {
        claimList.forEach(claim -> {
            Mapper.mapClaim(claim);
            claim.setClaimStatus(ClaimStatus.NEW);
        });
        List<Claim> processedClaims=ruleExecutorService.validateClaims(claimList);
        String response=filterService.assignClaimsToWorkList(processedClaims);
        if(response== Constants.CLAIM_SUCCESS_RESPONSE){
            return new ResponseEntity<String>(response,new HttpHeaders(),HttpStatus.OK);
        }
        else{
            return new ResponseEntity<String>(response,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/add")
    public ResponseEntity<HttpStatus> add(@RequestBody Claim claim) {
        Mapper.mapClaim(claim);
        claim.setClaimStatus(ClaimStatus.NEW);
        logger.info("Add claims");
        claimService.add(claim);
        return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
    }

    @PostMapping("/addAll")
    public ResponseEntity<HttpStatus> addAll(@RequestBody List<Claim> claimList) {
        claimList.forEach(claim -> {
            Mapper.mapClaim(claim);
            claim.setClaimStatus(ClaimStatus.NEW);
        });
        claimService.addAll(claimList);
        return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<HttpStatus> edit(@RequestBody Claim claim) {
        Mapper.mapClaim(claim);
        claimService.edit(claim);
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }

    @PutMapping("/updateAll")
    public ResponseEntity<HttpStatus> editAll(@RequestBody List<Claim> claimList) {
        claimList.forEach(claim -> {
            Mapper.mapClaim(claim);
        });
        claimService.editAll(claimList);
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }

    @PutMapping("/updateClaimStatus")
    public ResponseEntity<HttpStatus> edit(@RequestBody List<Claim> claimList) {

        claimList.forEach(claim -> {
            Mapper.mapClaim(claim);
            claim.setClaimStatus(ClaimStatus.SUBMITTED);
            claimService.edit(claim);
        });
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Claim>> getAll() {
        List<Claim> claimList=claimService.getAll();

        System.out.println("All claims");
       return new ResponseEntity<>(claimList, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Claim> getById(@PathVariable("id") String id) {
        logger.info("Get claim by id="+id);
        Claim claim=claimService.getById(id);
        logger.info("Claim="+claim);
        return new ResponseEntity<>(claim, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") String id) {
        logger.info("Delete claim by id="+id);
        claimService.deleteById(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }

    @DeleteMapping("deleteAll")
    public ResponseEntity<HttpStatus> deleteAll() {
        logger.info("Delete All Claims");
        claimService.deleteAll();
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }

    @GetMapping("/getStatus")
    public ResponseEntity<String> getStatus() {
        System.out.println("request received");
        return new ResponseEntity<>("success", new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("search")
    public ResponseEntity<List<Claim>> searchClaims(ClaimSearchModel searchModel){
    	List<Claim> search = claimService.search(searchModel);
    	return new ResponseEntity<List<Claim>>(claimService.search(searchModel),HttpStatus.OK);
    }
    
    /*@PostMapping("/mergeClaims")
    public ResponseEntity<Claim> mergeClaims(@RequestBody Claim claim) {
    	if(claim.getEncounterActivities().size() < 2) {
    		return handleError(claim, "In order to merge, there should be at least two activities");
    	}
    	ClaimActivity firstClaimActivity = claim.getEncounterActivities().get(0);
    	ClaimActivity newClaimActivity = new ClaimActivity();
    	String activityCode = firstClaimActivity.getActivityCode();
    	String activityType = firstClaimActivity.getActivityType();
    	Date servicePerforemedDate = firstClaimActivity.getServicePerformedDate();
    	for(ClaimActivity claimActivity : claim.getEncounterActivities()) {
    		if(!claimActivity.getActivityCode().equals(activityCode)) {
    			return handleError(claim, "Activity code doesn't match : code1 - " + activityCode + ", code2 - " + claimActivity.getActivityCode());
    		}
    		if(!claimActivity.getActivityType().equals(activityType)) {
    			return handleError(claim, "Activity type doesn't match : type1 - " + activityType + ", type2 - " + claimActivity.getActivityType());
    		}
    		if(!claimActivity.getServicePerformedDate().equals(servicePerforemedDate)) {
    			return handleError(claim, "Service performed date doesn't match : date1 - " + servicePerforemedDate + ", date2 - " + claimActivity.getServicePerformedDate());
    		}
    	}
    	
    	Double activityGross = 0.0;
    	Double activityNet = 0.0;
    	Double discount = 0.0;
    	Double patientShare = 0.0;
    	Double quantity = 0.0;
    	String observationRemarks = "";
    	for(ClaimActivity claimActivity : claim.getEncounterActivities()) {
    		activityGross += claimActivity.getActivityGross();
    		activityNet += claimActivity.getActivityNet();
    		discount += claimActivity.getDiscount();
    		patientShare += claimActivity.getPatientShare();
    		quantity += claimActivity.getQuantity();
    		observationRemarks += claimActivity.getObservationRemarks() + ",";
    	}
    	newClaimActivity.setActivityGross(activityGross);
    	newClaimActivity.setActivityNet(activityNet);
    	newClaimActivity.setDiscount(discount);
    	newClaimActivity.setPatientShare(patientShare);
    	newClaimActivity.setQuantity(quantity);
    	newClaimActivity.setDiscountPrecentage((discount / activityGross) * 100);
    	newClaimActivity.setActivityCode(activityCode);
    	newClaimActivity.setActivityType(activityType);
    	newClaimActivity.setApprovalCode(firstClaimActivity.getApprovalCode());
    	newClaimActivity.setEncounterId(firstClaimActivity.getEncounterId());
    	newClaimActivity.setObservationRemarks(firstClaimActivity.getObservationRemarks());
    	newClaimActivity.setApprovalCode(firstClaimActivity.getApprovalCode());
    	newClaimActivity.setApprovalCode(firstClaimActivity.getApprovalCode());
    	newClaimActivity.setApprovalCode(firstClaimActivity.getApprovalCode());
    	newClaimActivity.setApprovalCode(firstClaimActivity.getApprovalCode());
    	newClaimActivity.setApprovalCode(firstClaimActivity.getApprovalCode());
    	claim.setEncounterActivities(Arrays.asList(newClaimActivity));
    	claimService.add(claim);
    	return new ResponseEntity<Claim>(claim, HttpStatus.CREATED);
    }*/
    
    private ResponseEntity<Claim> handleError(Claim claim, String errorMessage) {
		logger.error(errorMessage);
		//claim.setErrorList(Arrays.asList(errorMessage));
		return new ResponseEntity<Claim>(claim, HttpStatus.BAD_REQUEST);
    }

}
