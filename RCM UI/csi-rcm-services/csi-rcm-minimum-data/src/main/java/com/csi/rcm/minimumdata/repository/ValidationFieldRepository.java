package com.csi.rcm.minimumdata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csi.rcm.minimumdata.model.ValidationClass;
import com.csi.rcm.minimumdata.model.ValidationField;

/**
 * 
 * @author Kasun
 * @version 1.0
 * @since 2018/01/23
 *
 */
@Repository
public interface ValidationFieldRepository extends JpaRepository<ValidationField, Long> {

	List<ValidationField> findAllBySystemValidateionClass(ValidationClass systemValidateionClass);
	
}
