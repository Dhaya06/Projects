package com.csi.vidaplus.rcm.claim.util;

import com.csi.vidaplus.rcm.claim.entity.Claim;
import com.csi.vidaplus.rulesengine.client.dto.RuleContext;
import com.csi.vidaplus.rulesengine.client.dto.RuleExecutionRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Ahsan on 2/5/2018.
 */

public class PropertyBuilder {
    public static RuleExecutionRequest buildRuleRequest(RuleExecutionRequest ruleExecutionRequest,Claim claim){
        RuleExecutionRequest.RuleResult ruleResult=new RuleExecutionRequest.RuleResult();
        ruleResult.setVariable(Constants.INPUT_OUTPUT_VARIABLE);

        RuleExecutionRequest.RuleParameter ruleParameter=new RuleExecutionRequest.RuleParameter();
        ruleParameter.setType(Constants.RULE_INPUT_TYPE);
        ruleParameter.setValue(claim);
        ruleParameter.setReturning(true);
        ruleParameter.setRuleResult(ruleResult);

        RuleExecutionRequest.RuleParameter techErrorParameter=new RuleExecutionRequest.RuleParameter();
        techErrorParameter.setType(Constants.RULE_ERROR_TYPE);
        techErrorParameter.setParameter(Constants.TECH_ERROR_VARIABLE);
        techErrorParameter.setCommon(true);
        techErrorParameter.setValue(new ArrayList<>());
        techErrorParameter.setReturning(true);

        RuleExecutionRequest.RuleParameter medErrorParameter=new RuleExecutionRequest.RuleParameter();
        medErrorParameter.setType(Constants.RULE_ERROR_TYPE);
        medErrorParameter.setParameter(Constants.MED_ERROR_VARIABLE);
        medErrorParameter.setCommon(true);
        medErrorParameter.setValue(new ArrayList<>());
        medErrorParameter.setReturning(true);

        /*RuleExecutionRequest.RuleParameter errorMap=new RuleExecutionRequest.RuleParameter();
        errorMap.setType(Constants.RULE_ERROR_MAP_TYPE);
        errorMap.setParameter(Constants.ERROR_MAP_VARIABLE);
        errorMap.setCommon(true);
        errorMap.setValue(new HashMap<>());
        errorMap.setReturning(true);*/

        List<RuleExecutionRequest.RuleParameter<?>> ruleParameterList=new ArrayList<>();
        ruleParameterList.add(ruleParameter);
        ruleParameterList.add(techErrorParameter);
        ruleParameterList.add(medErrorParameter);
        //ruleParameterList.add(errorMap);
        ruleExecutionRequest.setParameters(ruleParameterList);
        return ruleExecutionRequest;
    }

    public static RuleExecutionRequest initRuleExecutionRequest(){
        RuleExecutionRequest ruleExecutionRequest=new RuleExecutionRequest();
        RuleContext ruleContext=new RuleContext();
        ruleContext.setRuleCode(Constants.RULE_CODE);
        ruleExecutionRequest.setRuleContext(ruleContext);
        return ruleExecutionRequest;
    }

}
