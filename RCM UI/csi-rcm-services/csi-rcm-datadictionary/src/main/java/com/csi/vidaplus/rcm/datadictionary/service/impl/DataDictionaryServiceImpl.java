/*
 * %W% %E% Firstname Lastname
 *
 * Copyright (c) 1993-1996 Sun Microsystems, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Sun
 * Microsystems, Inc. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 *
 * SUN MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
 * THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 * TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE, OR NON-INFRINGEMENT. SUN SHALL NOT BE LIABLE FOR
 * ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */
package com.csi.vidaplus.rcm.datadictionary.service.impl;

import java.util.List;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.csi.vidaplus.rcm.datadictionary.document.DataDictionary;
import com.csi.vidaplus.rcm.datadictionary.service.DataDictionaryService;
import com.csi.vidaplus.rcm.datadictionary.util.FilterCriteria;

/**
 * Implementation of data dictionary builder interface
 * 
 * @version 1.0 12 Jan 2018
 * @author Mohomad Nusky
 */
@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private MongoOperations mongoOperations;

	/**
	 * add data dictionary to db by type
	 * 
	 * @param dataDictionary
	 */
	public void add(DataDictionary dataDictionary) {
		mongoTemplate.insert(dataDictionary);
	}

	/**
	 * edit existing master in db by type
	 * 
	 * @param dataDictionary
	 */
	public void edit(DataDictionary dataDictionary) {
		mongoTemplate.save(dataDictionary);
	}

	/**
	 * delete data dictionary by id
	 * 
	 * @param id
	 * @param className
	 */
	public void delete(String id, Class className) {
		mongoOperations.remove(mongoOperations.findById(id, className));
	}

	/**
	 * get all the master related to a type
	 * 
	 * @param className
	 * @return List<DataDictionary>
	 */
	public List<DataDictionary> getAll(Class className) {
		return mongoTemplate.findAll(className);
	}

	/**
	 * get data dictionary by id
	 * 
	 * @param id
	 * @param className
	 * @return DataDictionary
	 */
	public DataDictionary getById(String id, Class className) {
		return (DataDictionary) mongoOperations.findById(id, className);
	}

	/**
	 * get data dictionary by field
	 * 
	 * @param className
	 * @param fieldName
	 * @param value
	 * @return List<DataDictionary>
	 */
	public List<DataDictionary> getAllByField(Class className, String fieldName, String value) {
		Query query = new Query();
		query.addCriteria(Criteria.where(fieldName).is(value));
		return mongoTemplate.find(query, className);
	}

	/**
	 * get data dictionary by regex
	 * 
	 * @param className
	 * @param fieldName
	 * @param value
	 * @return List<DataDictionary>
	 */
	public List<DataDictionary> getAllByRegex(Class className, String fieldName, String value) {
		Query query = new Query();
		String regex = "^" + value;
		query.addCriteria(Criteria.where(fieldName).regex(regex));
		return mongoTemplate.find(query, className);
	}

	/**
	 * get data dictionary by criteria
	 * 
	 * @param className
	 * @param fieldName
	 * @param fieldValue
	 * @param filterCriteria
	 * @return
	 */
	public List<DataDictionary> searchByCriteria(Class className, String fieldName, String fieldValue,
			FilterCriteria filterCriteria) {
		Query query = new Query();
		Criteria criteria = new Criteria();
		switch (filterCriteria) {
		case REGEX:
			String regex = "^" + fieldValue;
			criteria.where(fieldName).regex(regex);
			break;
		case EQUAL:
			if (!"".equals(fieldValue.trim())) {
				criteria.where(fieldName).is(fieldValue);
			}
			break;
		case GREATERTHAN:
			if (!"".equals(fieldValue.trim()) && NumberUtils.isNumber(fieldValue)) {
				criteria.where(fieldName).gt(fieldValue);
			}
			break;
		case LESSTHAN:
			if (!"".equals(fieldValue.trim()) && NumberUtils.isNumber(fieldValue)) {
				criteria.where(fieldName).lt(fieldValue);
			}
			break;
		case GREATERTHANOREQUAL:
			if (!"".equals(fieldValue.trim()) && NumberUtils.isNumber(fieldValue)) {
				criteria.where(fieldName).gte(fieldValue);
			}
			break;
		case LESSTHANOREQUAL:
			if (!"".equals(fieldValue.trim()) && NumberUtils.isNumber(fieldValue)) {
				criteria.where(fieldName).lte(fieldValue);
			}
			break;
		case NOTEQUAL:
			if (!"".equals(fieldValue.trim())) {
				criteria.where(fieldName).ne(fieldValue);
			}
			break;
		case SORTBY:
			if (!"".equals(fieldName.trim())) {
				query.with(new Sort(Sort.Direction.ASC, fieldName));
			}
			break;

		}
		query.addCriteria(criteria);
		return mongoTemplate.find(query, className);
	}

}