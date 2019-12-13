package com.csi.rcm.encounter.prognote.repository;

import com.csi.rcm.encounter.prognote.model.PNComplaint;
import com.csi.rcm.encounter.prognote.model.PNVitalSign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VitalSignRepository extends JpaRepository<PNVitalSign, Integer>{
    List<PNVitalSign> findByAppointmentno(@Param("appointmentno") int appointmentno);
}
