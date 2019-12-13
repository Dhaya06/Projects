package com.csi.vidaplus.rcm.claim.feign;


import com.csi.vidaplus.rcm.claim.config.FeignConfigure;
import com.csi.vidaplus.rulesengine.client.dto.RuleExecutionRequest;
import com.csi.vidaplus.rulesengine.client.dto.RuleExecutionResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


//@FeignClient(value="rules-executor-service",url="http://172.15.100.71:8010/rules-engine/execute",fallback=RuleExecutorFeignServiceFallBack.class,configuration = FeignConfigure.class)
@FeignClient(value="rules-executor-service",fallback=RuleExecutorFeignServiceFallBack.class,configuration = FeignConfigure.class)
public interface RuleExecutorFeignService {

    @RequestMapping(method= RequestMethod.POST)
    public RuleExecutionResponse execute(RuleExecutionRequest request);
}
