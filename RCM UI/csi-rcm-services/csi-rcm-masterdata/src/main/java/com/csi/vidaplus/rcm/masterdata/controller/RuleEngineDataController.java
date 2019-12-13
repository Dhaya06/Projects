package com.csi.vidaplus.rcm.masterdata.controller;

import com.csi.vidaplus.rcm.masterdata.service.RuleDataService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ahsan on 2/7/2018.
 */
@Api(basePath = "/ ", value = "Master Data", description = "All services related to Master Data from rule engine", produces = "application/json")
@RestController
@CrossOrigin
public class RuleEngineDataController {

    @Autowired
    private RuleDataService ruleDataService;

    @GetMapping("/getMaxDiscount")
    public ResponseEntity<Double> getMaxDiscount(String groupId) {
        double maxDiscountAllowed=ruleDataService.getGroupMaxDiscountAllowed(groupId);
        System.out.println("request received");
        return new ResponseEntity<Double>(maxDiscountAllowed, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/getProcedurePrice")
    public ResponseEntity<Double> getProcedurePrice(String procedureId) {
        double procedurePrice=ruleDataService.getProcedurePrice(procedureId);
        System.out.println("request received");
        return new ResponseEntity<Double>(procedurePrice, new HttpHeaders(), HttpStatus.OK);
    }
}

