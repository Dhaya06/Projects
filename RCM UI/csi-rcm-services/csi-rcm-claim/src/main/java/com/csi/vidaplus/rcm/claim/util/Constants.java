package com.csi.vidaplus.rcm.claim.util;

/**
 * Created by Ahsan on 2/8/2018.
 */
public class Constants {
    public static final String RULE_CODE="system_verification_1.0.0";
    public static final String INPUT_OUTPUT_VARIABLE="encounter";
    public static final String TECH_ERROR_VARIABLE="errorList";
    public static final String MED_ERROR_VARIABLE="medErrorList";
    public static final String ERROR_MAP_VARIABLE="errorMap";
    public static final String RULE_INPUT_TYPE="com.rcm.system_verification.Encounter";
    public static final String RULE_ERROR_TYPE="java.util.ArrayList";
    public static final String RULE_ERROR_MAP_TYPE="java.util.HashMap";

    public static final String RULE_ENGINE_URL="http://172.15.100.71:8010/rules-engine/execute";
    //public static final String RULE_ENGINE_URL="https://csi-java-rule-01.run.aws-usw02-pr.ice.predix.io/rules-engine/execute";

    //todo- this need to change for feign
    public static final String WORKLIST_URL="http://172.15.100.10:10002/worklist/active";
    //public static final String WORKLIST_URL="https://csi-java-rcmworklist-02.run.aws-usw02-pr.ice.predix.io/worklist/active";

    public static final String CLAIM_SUCCESS_RESPONSE="success";
    public static final String CLAIM_NO_ACTIVE_WORKLIST="No Active Worklist Found";
    public static final String CLAIM_ASSIGNED_PERSIST_ERROR="Error in persisting assigned claims";
    public static final String CLAIM_UNASSIGNED_PERSIST_ERROR="Erron in persisting unassigned claims";





}
