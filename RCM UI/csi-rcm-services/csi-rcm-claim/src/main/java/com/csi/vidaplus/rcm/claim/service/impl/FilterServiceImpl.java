package com.csi.vidaplus.rcm.claim.service.impl;

import com.csi.vidaplus.rcm.claim.entity.Claim;
import com.csi.vidaplus.rcm.claim.feign.WorkListService;
import com.csi.vidaplus.rcm.claim.model.ClaimFilter;
import com.csi.vidaplus.rcm.claim.model.FilterValues;
import com.csi.vidaplus.rcm.claim.model.WorkList;
import com.csi.vidaplus.rcm.claim.model.type.Status;
import com.csi.vidaplus.rcm.claim.service.ClaimService;
import com.csi.vidaplus.rcm.claim.service.FilterService;
import com.csi.vidaplus.rcm.claim.util.Constants;
import com.csi.vidaplus.rcm.claim.util.Mapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Ahsan on 2/15/2018.
 */
@Service
public class FilterServiceImpl implements FilterService {
    private static Logger logger = LogManager.getLogger(ClaimServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ClaimService claimService;
    @Autowired
    private WorkListService workListService;

    public String assignClaimsToWorkList(List<Claim> claimList){

        List<WorkList> workLists = getAllActiveWorkList();
        if(workLists.size()==0){
            return Constants.CLAIM_NO_ACTIVE_WORKLIST;
        }

        for (WorkList workList : workLists) {
            // worklist should be active before today and worklist should not be expired by today
            if(workList.getStatus()== Status.Active && workList.getActiveFrom().before(new Date()) && Mapper.getExpireDate(workList.getAssignPeriod(),workList.getActiveFrom()).after(new Date())){
                List<Claim> workListClaims=new ArrayList<>();
                List<Claim> wholeClaims = claimList;
                for (ClaimFilter claimFilter : workList.getClaimFilters()) {
                    String fieldName = claimFilter.getFilterType().getFiledName();
                    // if filter fieldName is null, skip the filter
                    if(fieldName!=null && !"".equals(fieldName)){
                        Set<FilterValues> filterValues = claimFilter.getFilterValues();

                        /*for first claim filter whole claims are considered. from 2 onwards  results of previous filter
                        is considered */
                        if(claimFilter.getOrder()!=1){
                            wholeClaims=workListClaims;
                            workListClaims=new ArrayList<>();
                        }

                        for (FilterValues filterValue : filterValues) {
                            try {
                                // if filtervalue is null or empty its date range filter, else its a normal filter
                                if("".equals(filterValue.getFilterId().trim()) || filterValue.getFilterId()==null){
                                    Date fromDate=filterValue.getDateFrom();
                                    Date toDate=filterValue.getDateTo();

                                    List<Claim> filteredClaims = wholeClaims.stream()
                                            .filter(claim -> claim.getServiceStartTime().after(fromDate) && claim.getServiceEndTime().before(toDate))
                                            .collect(Collectors.toList());
                                    System.out.println("adding date claims to worklist claims");
                                    workListClaims.addAll(filteredClaims);
                                }else{
                                    List<Claim> filteredClaims = wholeClaims.stream()
                                            .filter(claim -> filterValue.getFilterId().equals(getFieldValue(fieldName, claim, Claim.class)))
                                            .collect(Collectors.toList());
                                    System.out.println("adding to worklist claims");
                                    workListClaims.addAll(filteredClaims);
                                }
                            } catch (Exception e) {
                                logger.error("Error in filtering claims",e);
                                e.printStackTrace();
                            }
                        }
                    }

                }

                //assign staff memebers to claims
                for (Claim claim : workListClaims) {
                    claim.setProcess(Mapper.memberSetAssignmentMapper(workList.getProcess()));
                    claim.setReview(Mapper.memberSetAssignmentMapper(workList.getReview()));
                    claim.setSubmission(Mapper.memberSetAssignmentMapper(workList.getSubmission()));
                    claim.setReSubmission(Mapper.memberSetAssignmentMapper(workList.getReSubmission()));
                }

                try {
                    if(workListClaims.size()>0){
                        // persisit assign clailms  and remove them from claim list
                        claimService.addAll(workListClaims);
                        claimList.removeAll(workListClaims);
                    }
                } catch (Exception e) {
                    logger.error("Error in persisting assigned claims",e);
                    e.printStackTrace();
                    return Constants.CLAIM_ASSIGNED_PERSIST_ERROR;
                }
            }
        }

        // persist remaining unassigned claims
        try {
            if(claimList.size()>0){
                claimService.addAll(claimList);
            }
        } catch (Exception e) {
            logger.error("Error in persisting unassigned claims",e);
            e.printStackTrace();
            return Constants.CLAIM_UNASSIGNED_PERSIST_ERROR;
        }
        return Constants.CLAIM_SUCCESS_RESPONSE;
    }

    private List<WorkList> getAllActiveWorkList(){
        List<WorkList> workLists=workListService.getAll();
       /* try{
            ResponseEntity<List<WorkList>> response = restTemplate.exchange(Constants.WORKLIST_URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<WorkList>>() {});
            if(response.getStatusCode()==HttpStatus.OK){
                workLists = response.getBody();
            }
        }catch (Exception e){
            logger.error("Error in getting active worklists",e);
            e.printStackTrace();
        }*/
        return workLists;
    }

    private String getFieldValue(String fieldName,Claim claim,Class encounterClass){
        Field field = null;
        Object value=null;
        try {
            field = encounterClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            value = field.get(claim);
            System.out.println(value.toString());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return  value.toString();
    }
}
