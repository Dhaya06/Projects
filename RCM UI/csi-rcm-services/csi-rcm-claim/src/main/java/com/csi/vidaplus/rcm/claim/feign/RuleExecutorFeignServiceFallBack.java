package com.csi.vidaplus.rcm.claim.feign;

import com.csi.vidaplus.rulesengine.client.dto.RuleExecutionRequest;
import com.csi.vidaplus.rulesengine.client.dto.RuleExecutionResponse;
import org.springframework.stereotype.Component;


/**
 * Created by Ahsan on 2/5/2018.
 */
@Component
public class RuleExecutorFeignServiceFallBack implements RuleExecutorFeignService{


    public RuleExecutionResponse execute(RuleExecutionRequest request){
        return null;
    }
}
