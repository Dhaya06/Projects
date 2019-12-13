package com.csi.vidaplus.rcm.claim.feign;

import com.csi.vidaplus.rcm.claim.config.FeignConfigure;
import com.csi.vidaplus.rcm.claim.model.WorkList;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

//@FeignClient(name="csi-rcm-worklist",url="http://172.15.100.10:10002/worklist/active",fallback=WorkListServiceFallBack.class,configuration = FeignConfigure.class)
@FeignClient(name="csi-rcm-worklist",fallback=WorkListServiceFallBack.class,configuration = FeignConfigure.class)
public interface WorkListService {

    @RequestMapping(method= RequestMethod.GET,value = "/active")
    public List<WorkList> getAll();
}
