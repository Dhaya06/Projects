package com.csi.rcm.minimumdata.service;

import java.util.List;

import com.csi.rcm.minimumdata.model.ValidationClass;
import com.csi.rcm.minimumdata.util.validation.FieldValueExists;

/**
 * 
 * @author Kasun
 * @version 1.0
 * @since 2018/01/23
 *
 */
public interface ValidationClassService extends FieldValueExists {

	/**
	 * This method use to save {@code ValidationClass}
	 * @param validationClass to save
	 */
	public void save(ValidationClass validationClass);
	
	/**
	 * This method use to update {@code ValidationClass}
	 * @param validationClass to save
	 */
	public void update(ValidationClass validationClass);
	
	/**
	 * This method use to get All {@code ValidationClass}
	 * @return List of {@code ValidationClass}
	 */
	public List<ValidationClass> getAll();
	
	/**
	 * This method use to get Validation Class from className
	 * @param className
	 * @return
	 */
	public ValidationClass getByClassName(String className);
	
}
