package com.csi.vidaplus.rcm.claim.service.impl;

import com.csi.vidaplus.rcm.claim.entity.Claim;
import com.csi.vidaplus.rcm.claim.entity.ClaimLabel;
import com.csi.vidaplus.rcm.claim.entity.ClaimLableType;
import com.csi.vidaplus.rcm.claim.feign.RuleExecutorFeignService;
import com.csi.vidaplus.rcm.claim.service.RuleExecutorService;
import com.csi.vidaplus.rcm.claim.util.Constants;
import com.csi.vidaplus.rcm.claim.util.Mapper;
import com.csi.vidaplus.rcm.claim.util.PropertyBuilder;
import com.csi.vidaplus.rulesengine.client.dto.RuleExecutionRequest;
import com.csi.vidaplus.rulesengine.client.dto.RuleExecutionResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
/*import com.csi.vidaplus.rulesengine.client.delegate.RuleExecutor;
import com.csi.vidaplus.rulesengine.client.dto.ExecutionContext;
import com.csi.vidaplus.rulesengine.client.dto.RuleContext;
import com.csi.vidaplus.rulesengine.client.dto.RuleExecutionRequest;
import com.csi.vidaplus.rulesengine.client.dto.RuleExecutionResponse;
import org.springframework.beans.factory.annotation.Autowired;*/

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ahsan on 2/4/2018.
 */
@Service
public class RuleExecutorServiceImpl implements RuleExecutorService {
    private static Logger logger = LogManager.getLogger(ClaimServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private RuleExecutorFeignService ruleExecutorFeignService;

    public List<Claim> validateClaims(List<Claim> claimList){
        for(Claim claim:claimList){
             processClaim(claim);
        }
        return  claimList;
    }

    public Claim validateClaim(Claim claim){
        return  processClaim(claim);
    }

    private Claim processClaim(Claim claim){
        try{
            RuleExecutionRequest ruleExecutionRequest= PropertyBuilder.initRuleExecutionRequest();
            ruleExecutionRequest=PropertyBuilder.buildRuleRequest(ruleExecutionRequest,claim);
            RuleExecutionResponse ruleExecutionResponse=postEncountersToRuleEngine(ruleExecutionRequest);
            if(ruleExecutionResponse.isSuccess()){
                Claim processedClaim = (Claim) objectMapper.convertValue(ruleExecutionResponse.getPayload().get(Constants.INPUT_OUTPUT_VARIABLE),Claim.class );
                List<String> errorList = (List<String>) objectMapper.convertValue(ruleExecutionResponse.getPayload().get(Constants.TECH_ERROR_VARIABLE),List.class );
                List<String> medErrorList = (List<String>) objectMapper.convertValue(ruleExecutionResponse.getPayload().get(Constants.MED_ERROR_VARIABLE),List.class );
                //HashMap<String,String> errorMap = (HashMap<String,String>) objectMapper.convertValue(ruleExecutionResponse.getPayload().get(Constants.ERROR_VARIABLE),HashMap.class );

                claim.setTechErrorMap(Mapper.buildErrorMap(errorList));
                claim.setMedErrorMap(Mapper.buildErrorMap(medErrorList));
                boolean isClean=true;
                if(!claim.getTechErrorMap().isEmpty()){
                    claim.setClaimLableType(ClaimLableType.TECHNICAL_ERROR.getCode());
                    isClean=false;
                }
                if(!claim.getMedErrorMap().isEmpty()){
                    claim.setClaimLableType(ClaimLableType.MEDICAL_ERROR.getCode());
                    isClean=false;
                }

                if(isClean){
                    claim.setClaimLable(ClaimLabel.CLEAN.getCode());
                }else{
                    claim.setClaimLable(ClaimLabel.ERROR.getCode());
                }
            }
        }catch (Exception e){
            logger.error("Error in Processing system validation",e);
        }
        return  claim;
    }

    private RuleExecutionResponse postEncountersToRuleEngine(RuleExecutionRequest ruleExecutionRequest){
        RuleExecutionResponse ruleExecutionResponse=ruleExecutorFeignService.execute(ruleExecutionRequest);

        //RuleExecutionResponse ruleExecutionResponse = (RuleExecutionResponse)restTemplate.postForObject(Constants.RULE_ENGINE_URL, ruleExecutionRequest, RuleExecutionResponse.class, new Object[0]);
        return ruleExecutionResponse;
    }

}
