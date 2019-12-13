package com.csi.rcm.minimumdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csi.rcm.minimumdata.model.FieldType;

/**
 * 
 * @author Kasun
 * @version 1.0
 * @since 2018/01/23
 *
 */
@Repository
public interface FieldTypeRepository extends JpaRepository<FieldType, Long> {

}
