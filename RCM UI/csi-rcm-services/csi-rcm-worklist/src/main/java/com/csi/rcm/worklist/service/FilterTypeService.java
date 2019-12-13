package com.csi.rcm.worklist.service;

import java.util.List;

import com.csi.rcm.worklist.model.FilterType;

/**
 * @author Kasun
 * @version 0.0.1
 * @since 2018/01/26
 */
public interface FilterTypeService {

	/**
	 * Method is use to save new FilterType
	 * @param filterType new FilterType
	 */
	public void save(FilterType filterType);
	
	/**
	 * Method is use to update FilterType
	 * @param filterType
	 */
	public void update(FilterType filterType);
	
	/**
	 * Method is use to get all FilterTypes
	 * @return {@link List} of FilterTypes
	 */
	public List<FilterType> getAll();
	
	/**
	 * Method is use to get FilterType from id
	 * @param id
	 * @return
	 */
	public FilterType getById(Long id);
	
}
