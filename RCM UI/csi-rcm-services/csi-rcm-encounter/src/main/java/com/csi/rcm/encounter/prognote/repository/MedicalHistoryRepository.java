package com.csi.rcm.encounter.prognote.repository;

import com.csi.rcm.encounter.prognote.model.PNMedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MedicalHistoryRepository extends JpaRepository<PNMedicalHistory, Integer>{

}
