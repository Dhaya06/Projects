package com.csi.rcm.encounter.prognote.service;


import com.csi.rcm.encounter.prognote.model.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PrognoteService {
    public List<PNChiefComplaint> chiefComplaint(int appointmentno);
    public List<PNComplaint> complaint(int appointmentno);
    public List<PNMedicalHistory> medicalHistory();
    public List<PNVitalSign> vitalSign(int appointmentno);
    public List<PNOrder> order(int appointmentno);
    public List<PNAllergyDisease> alergyDisease(int appointmentno);
//    public List<String> test();
}
