package com.csi.rcm.encounter.prognote.repository;

import com.csi.rcm.encounter.prognote.model.PNOrder;
import com.csi.rcm.encounter.prognote.model.PNVitalSign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<PNOrder, Integer>{
    List<PNOrder> findByAppointmentno(@Param("appointmentno") int appointmentno);
}
