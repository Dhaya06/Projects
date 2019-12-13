package com.csi.rcm.encounter.prognote.repository;

import com.csi.rcm.encounter.prognote.model.PNChiefComplaint;
import com.csi.rcm.encounter.prognote.model.PNComplaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChiefComplaintRepository extends JpaRepository<PNChiefComplaint, Integer>{
    List<PNChiefComplaint> findByAppointmentno(@Param("appointmentno") int appointmentno);
}