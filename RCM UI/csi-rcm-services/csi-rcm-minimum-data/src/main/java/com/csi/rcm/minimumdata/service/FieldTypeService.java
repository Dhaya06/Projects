package com.csi.rcm.minimumdata.service;

import java.util.List;

import com.csi.rcm.minimumdata.model.FieldType;

/**
 * 
 * @author Kasun
 * @version 1.0
 * @since 2018/01/23
 *
 */
public interface FieldTypeService {
	/**
	 *  This method use to save the {@code FieldType}
	 * @param fieldType to save
	 */
	public void save(FieldType fieldType);
	
	/**
	 *  This method use to update the {@code FieldType}
	 * @param fieldType to update
	 */
	public void update(FieldType fieldType);
	
	/**
	 *  This method use get all {@code FieldType}
	 *  @return list of {@code FieldType}
	 */
	public List<FieldType> getAll();
}
