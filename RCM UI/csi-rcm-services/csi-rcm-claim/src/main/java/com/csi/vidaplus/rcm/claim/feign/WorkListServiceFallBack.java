package com.csi.vidaplus.rcm.claim.feign;

import com.csi.vidaplus.rcm.claim.model.WorkList;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class WorkListServiceFallBack implements WorkListService {

    public List<WorkList> getAll(){
        System.out.println("fall back called");
        WorkList workList=new WorkList();
        workList.setId(1L);
        List<WorkList> workLists=new ArrayList<>();
        workLists.add(workList);
        return workLists;
    }
}
