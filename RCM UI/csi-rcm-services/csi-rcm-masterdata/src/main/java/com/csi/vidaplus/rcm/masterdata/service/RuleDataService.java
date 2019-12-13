package com.csi.vidaplus.rcm.masterdata.service;

/**
 * Created by Ahsan on 2/7/2018.
 */
public interface RuleDataService {
    Double getGroupMaxDiscountAllowed(String groupId);

    Double getProcedurePrice(String procedureId);
}
