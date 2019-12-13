package com.csi.vidaplus.rcm.claim.util;

import com.csi.vidaplus.rcm.claim.entity.Appointment;
import com.csi.vidaplus.rcm.claim.entity.Claim;
import com.csi.vidaplus.rcm.claim.entity.ClaimStatus;
import com.csi.vidaplus.rcm.claim.entity.Invoice;
import com.csi.vidaplus.rcm.claim.model.*;
import com.csi.vidaplus.rcm.claim.model.type.AssignPeriod;
import com.csi.vidaplus.rcm.claim.service.ClaimService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * Created by Ahsan on 2/7/2018.
 */
public class Mapper {
    private static Logger logger = LogManager.getLogger(Mapper.class);

    @Autowired
    private static ClaimService claimService;

    public static void mapClaim(Claim claim){
        claim.getEncounterDiagnosis().forEach(claimDiagnosis -> claimDiagnosis.setClaim(claim));
        claim.getDoctorNotesList().forEach(doctorNotes -> doctorNotes.setClaim(claim));
        claim.getNurseNotesList().forEach(nurseNotes -> nurseNotes.setClaim(claim));
        claim.getPatient().setClaim(claim);

        claim.getAppointments().forEach(appointment -> {
            appointment.setClaim(claim);
            appointment.getInvoices().forEach(invoice -> {
                invoice.setAppointment(appointment);
                invoice.getEncounterActivities().forEach(claimActivity -> {
                    claimActivity.setActivities(invoice);
                });
            });
        });
    }

    public static Set<Long> memberSetAssignmentMapper(Set<MemberAssignment> memberAssignmentSet){
        Set<Long> memberSet=new HashSet<>();
        memberAssignmentSet.forEach(memberAssignment -> {
            memberSet.add(memberAssignment.getStaffMember().getId());
        });
        return memberSet;
    }

    public static HashMap<String,List<String>> buildErrorMap(List<String> errorList){
        HashMap<String,List<String>> errorMap=new HashMap<>();

        for(String error:errorList){
            try{
                String[] result=error.split("\\|");
                List<String> errors= new LinkedList<>(Arrays.asList(result[1].split(",")));
                if(errorMap.get(result[0])!=null){
                    List<String> existingErrors=errorMap.get(result[0]);
                    errors.addAll(existingErrors);
                }
                errorMap.put(result[0],errors);
            }catch (Exception e){
                e.printStackTrace();
                logger.error("Error in building map",e);
            }

        }
        return errorMap;
    }

    public static Date getExpireDate(AssignPeriod assignPeriod, Date activeFom){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(activeFom);

        switch (assignPeriod){
            case ONEDAY:
                calendar.add(Calendar.DATE,1);
                break;
            case ONEWEEK:
                calendar.add(Calendar.DATE,7);
                break;
            case ONEMONTH:
                calendar.add(Calendar.MONTH,1);
                break;
            case SIXMONTH:
                calendar.add(Calendar.MONTH,6);
                break;
            case ONEYEAR:
                calendar.add(Calendar.YEAR,1);
                break;
            default:
                break;
        }
        return calendar.getTime();
    }

    /*public static void mapClaimToEncounter(List<Encounter> encounterList){
        List<Claim> claimList=new ArrayList<>();
        *//**//*for(Claim claim:claimList){
            List<Invoice> invoiceList=claim.getEncounterInvoices();
            Appointment appointment;
            if(claim.getReferenceEncounterId()==null || "".equals(claim.getReferenceEncounterId())){
                appointment=new Appointment();
            }else{
                Claim existingClaim= claimService.getById(claim.getReferenceEncounterId());
                claim.getAppointments().addAll(existingClaim.getAppointments());
                claim.getDoctorNotesList().addAll(existingClaim.getDoctorNotesList());
                claim.getNurseNotesList().addAll(existingClaim.getNurseNotesList());
                //existingClaim.

            }

        }*//**//*

        Claim claim;

        for(Encounter encounter: encounterList){
            Appointment appointment=new Appointment();
            List<Invoice> invoiceList=new ArrayList<>();
            double grossAmount=0;
            double netAmount=0;
            double discount=0;
            double patientShare=0;
            double companyShare=0;
            double qty= 0;

            for(EncounterInvoice encounterInvoice:encounter.getEncounterInvoices()){
                Invoice invoice=new Invoice();
                BeanUtils.copyProperties(encounterInvoice,invoice);

                invoice.setId(String.valueOf(encounterInvoice.getId()));
                invoice.setGrossAmount(encounterInvoice.getInvoiceGross());
                invoice.setNetAmount(encounterInvoice.getInvoiceNet());
                invoice.setCompanyShare(encounterInvoice.getInvoiceCompanyShare());
                invoice.setPatientShare(encounterInvoice.getInvoicePatientShare());
                invoice.setDiscount(encounterInvoice.getInvoiceDiscount());
                invoice.setEncounterActivities(encounterInvoice.getEncounterActivities());
                invoiceList.add(invoice);

                grossAmount=grossAmount+encounterInvoice.getInvoiceGross();
                netAmount = netAmount + encounterInvoice.getInvoiceNet();
                companyShare = companyShare + encounterInvoice.getInvoiceCompanyShare();
                patientShare = patientShare + encounterInvoice.getInvoicePatientShare();
                discount = discount + encounterInvoice.getInvoiceDiscount();
                qty++;
            }
            appointment.setGrossAmount(grossAmount);
            appointment.setNetAmount(netAmount);
            appointment.setCompanyShare(companyShare);
            appointment.setPatientShare(patientShare);
            appointment.setDiscount(discount);
            appointment.setQuantity(qty);
            appointment.setInvoices(invoiceList);


            if(encounter.getReferenceEncounterId()==null || "".equals(encounter.getReferenceEncounterId())){
                claim=new Claim();
                BeanUtils.copyProperties(encounter,claim);
                claim.setAppointments(Arrays.asList(appointment));
                claim.setDoctorNotesList(encounter.getDoctorNotes());
                claim.setNurseNotesList(encounter.getNurseNotes());
                claim.setPatient(encounter.getPatient());
            }else{
                claim= claimService.getById(encounter.getReferenceEncounterId());


            }



            claimList.add(claim);


        }

    }*/
}
