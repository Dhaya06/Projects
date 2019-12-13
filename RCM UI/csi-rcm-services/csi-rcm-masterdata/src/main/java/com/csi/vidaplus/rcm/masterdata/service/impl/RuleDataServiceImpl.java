package com.csi.vidaplus.rcm.masterdata.service.impl;

import com.csi.vidaplus.rcm.masterdata.document.CompanyGroup;
import com.csi.vidaplus.rcm.masterdata.document.ProcedurePrice;
import com.csi.vidaplus.rcm.masterdata.service.RuleDataService;
import com.csi.vidaplus.rcm.masterdata.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ahsan on 2/7/2018.
 */
@Service
public class RuleDataServiceImpl implements RuleDataService{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Double getGroupMaxDiscountAllowed(String groupId) {
        double maxAllowedDiscount=0;
        Query query = new Query();
        query.addCriteria(Criteria.where("group_id").is(groupId));

        try {
            Class aClass = Class.forName(Constants.MASTER_DATA_PACKAGE_PREFIX+"CompanyGroup");
            List<CompanyGroup> companyGroupList=mongoTemplate.find(query,aClass);
            String maxDiscount=companyGroupList.get(0).getMaximum_allowed_discount();
            maxAllowedDiscount =Double.parseDouble(maxDiscount);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return maxAllowedDiscount;
    }

    @Override
    public Double getProcedurePrice(String procedureId) {
        double procedurePrice=0;
        Query query = new Query();
        query.addCriteria(Criteria.where("procedure_id").is(procedureId));

        try {
            Class aClass = Class.forName(Constants.MASTER_DATA_PACKAGE_PREFIX+"ProcedurePrice");
            List<ProcedurePrice> procedurePriceList=mongoTemplate.find(query,aClass);
            procedurePrice=procedurePriceList.get(0).getPrice();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return procedurePrice;
    }
}
