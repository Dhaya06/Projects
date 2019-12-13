package com.csi.rcm.encounter.prognote.service.impl;

import com.csi.rcm.encounter.prognote.model.*;
import com.csi.rcm.encounter.prognote.repository.*;
import com.csi.rcm.encounter.prognote.service.PrognoteService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrognoteServiceImpl implements PrognoteService{

    @Autowired
    private ChiefComplaintRepository chiefComplaintRepository;

    @Autowired
    private ComplaintRepository complaintRepository;

    @Autowired
    private MedicalHistoryRepository medicalHistoryRepository;

    @Autowired
    private VitalSignRepository vitalSignRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AllergyDiseaseRepository allergyDiseaseRepository;

    @Override
    public List<PNChiefComplaint> chiefComplaint(int appointmentno) {
        return chiefComplaintRepository.findByAppointmentno(appointmentno);
    }

    @Override
    public List<PNComplaint> complaint(int appointmentno) {
        return complaintRepository.findByAppointmentno(appointmentno);
    }

    @Override
    public List<PNMedicalHistory> medicalHistory() {
        return medicalHistoryRepository.findAll();
    }

    @Override
    public List<PNVitalSign> vitalSign(int appointmentno) {
        return vitalSignRepository.findByAppointmentno(appointmentno);
    }

    @Override
    public List<PNOrder> order(int appointmentno) {
        return orderRepository.findByAppointmentno(appointmentno);
    }

    @Override
    public List<PNAllergyDisease> alergyDisease(int appointmentno) {
        return allergyDiseaseRepository.findByAppointmentno(appointmentno);
    }

//    @Override
//    public List<String> test() {
//        Byte b1 = new Byte("11");
//        Byte b2 = new Byte("7");
//
//        return medicalHistoryRepository.fn_GetParameterDescription("91877", 1, b1, b2, 0, null);
//
//    }

}
