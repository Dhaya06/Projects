export  const API_URL = {
    TASK_MANAGER : {
        ROOT : "http://172.15.100.10:10002/worklist/",
        SEARCH : "http://172.15.100.10:10002/worklist/search/"
    }, PAYER_PROFILE : {
        GETALL : "http://172.15.100.10:10003/masterdata/getAll?type=CompanyProfile",
        GETBYID :"http://172.15.100.10:10003/masterdata/getAllByField?type=CompanyProfile&searchField=profile_id&searchValue=",
        CREATE : "http://172.15.100.10:10003/masterdata/add",
        UPDATE : "http://172.15.100.10:10003/masterdata/update",
        DELETE : "http://172.15.100.10:10003/masterdata/delete?type=CompanyProfile&id="
    },COMPANY_GROUP : {
        GETALL : "http://172.15.100.10:10003/masterdata/getAll?type=CompanyGroup"
    },COMPANY : {
        GETALL : "http://172.15.100.10:10003/masterdata/getAll?type=Company",
        GET_FOR_COMPANYGROUP : 'http://172.15.100.10:10003/masterdata/getAllByField?type=Company&searchField=group_id&searchValue='
    },PROCEDURE: {
        GETALL: "http://172.15.100.10:10003/masterdata/getAll?type=Procedure"
    },CLAIM : {
        SEARCH : "http://172.15.100.10:10011/claim/search/",
        SINGLECLAIM: "http://172.15.100.10:10011/claim/",
        SAVE: "http://172.15.100.10:10011/claim/validateAssignClaims"
    },PATIENT : {
        GETALL : "http://172.15.100.10:10003/masterdata/getAll?type=Patient"
    },HOSPITAL : {
        GETALL : "http://172.15.100.10:10003/masterdata/getAll?type=Hospital"
    },ENCOUNTERTYPE : {
        GETALL : "http://172.15.100.10:10003/masterdata/getAll?type=EncounterType"
    },CLINIC : {
        GETALL : "http://172.15.100.10:10003/masterdata/getAll?type=Clinic"
    },DOCTORS : {
        GETALL : "http://172.15.100.10:10003/masterdata/getAll?type=Doctor"
    },Widjet :{
        GETENCOUNTER_SUMMARY : "http://172.15.100.10:10012/widget/encounterSummeryWidgetData/",
        GETNURSE_NOTES :  "http://172.15.100.10:10012/widget/nurseNoteWidgetData/",
        PATIENT_HISTORY : "http://172.15.100.10:10012/widget/patientHistoryWidgetData/",
        VITAL_SIGN :    "http://172.15.100.10:10025/prognote/vitalSign/",
        COMPLAINT : "http://172.15.100.10:10025/prognote/complaint/",
        ORDERS: "http://172.15.100.10:10025/prognote/order/",
        ENCOUNTER_DATA:"http://172.15.100.10:10003/masterdata/getAllByField?type=EncounterType&searchField=encounter_id&searchValue="
    }

}
