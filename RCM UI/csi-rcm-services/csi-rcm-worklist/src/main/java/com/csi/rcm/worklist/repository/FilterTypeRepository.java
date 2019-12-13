package com.csi.rcm.worklist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csi.rcm.worklist.model.FilterType;

/**
 * @author Kasun
 * @version 0.0.1
 * @since 2018/01/26
 */
@Repository
public interface FilterTypeRepository extends JpaRepository<FilterType, Long> {

}
