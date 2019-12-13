package com.csi.rcm.encounter.prognote.controller;

import com.csi.rcm.encounter.prognote.model.*;
import com.csi.rcm.encounter.prognote.repository.ChiefComplaintRepository;
import com.csi.rcm.encounter.prognote.service.PrognoteService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prognote")
@CrossOrigin
public class ChiefComplaintController {

    @Autowired
    private PrognoteService prognoteService;

    @GetMapping("/chiefcomplaint/{appointmentno}")
    public List<PNChiefComplaint> getChiefComplaint(@PathVariable int appointmentno){
        return prognoteService.chiefComplaint(appointmentno);
    }

    @GetMapping("/complaint/{appointmentno}")
    public List<PNComplaint> getComplaint(@PathVariable int appointmentno){
        return prognoteService.complaint(appointmentno);
    }

    @GetMapping("/medicalHistory/{patientid}")
    public List<PNMedicalHistory> getMedicalHistory(@PathVariable int patientid){
        return prognoteService.medicalHistory();
    }

    @GetMapping("/vitalSign/{appointmentno}")
    public List<PNVitalSign> getVitalSign(@PathVariable int appointmentno){
        return prognoteService.vitalSign(appointmentno);
    }

    @GetMapping("/order/{appointmentno}")
    public List<PNOrder> getOrder(@PathVariable int appointmentno){
        return prognoteService.order(appointmentno);
    }

    @GetMapping("/allergyDisease/{appointmentno}")
    public List<PNAllergyDisease> getAllergyDisease(@PathVariable int appointmentno){
        return prognoteService.alergyDisease(appointmentno);
    }

//    @GetMapping("/test")
//    public List<String> test(){
//        return prognoteService.test();
//    }

}
