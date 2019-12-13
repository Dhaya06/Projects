package com.csi.rcm.encounter.prognote.repository;

import com.csi.rcm.encounter.prognote.model.PNAllergyDisease;
import com.csi.rcm.encounter.prognote.model.PNChiefComplaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AllergyDiseaseRepository extends JpaRepository<PNAllergyDisease, Integer>{
    List<PNAllergyDisease> findByAppointmentno(@Param("appointmentno") int appointmentno);
}
