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
package com.csi.vidaplus.rcm.masterdata.service.impl;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.csi.vidaplus.rcm.masterdata.document.MasterData;
import com.csi.vidaplus.rcm.masterdata.service.MasterDataService;
import com.csi.vidaplus.rcm.masterdata.util.FilterCriteria;

/**
 * Implementation of master data builder interface
 * 
 * @version 1.0 12 Jan 2018
 * @author Ahsan Shamsudeen
 */
@Service
public class MasterDataServiceImpl implements MasterDataService {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private MongoOperations mongoOperations;

	/**
	 * add master data to db by type
	 * 
	 * @param masterData
	 */
	public void add(MasterData masterData) {
		mongoTemplate.insert(masterData);
	}

	/**
	 * edit existing master in db by type
	 * 
	 * @param masterData
	 */
	public void edit(MasterData masterData) {
		mongoTemplate.save(masterData);
	}

	/**
	 * delete master data by id
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
	 * @return List<MasterData>
	 */
	public List<MasterData> getAll(Class className) {
		return mongoTemplate.findAll(className);
	}

	/**
	 * get master data by id
	 * 
	 * @param id
	 * @param className
	 * @return MasterData
	 */
	public MasterData getById(String id, Class className) {
		return (MasterData) mongoOperations.findById(id, className);
	}
	/**
	 * get master data by field
	 * 
	 * @param className
	 * @param fieldName
	 * @param value
	 * @return List<MasterData>
	 */
	public List<MasterData> getAllByField(Class className, String fieldName, String value) {
	
		Field[] fields = className.getDeclaredFields();
		Field[] superClassfields = className.getSuperclass().getDeclaredFields();
		fields = ArrayUtils.addAll(fields,superClassfields);
		Query query = new Query();
		
		
		 for(Field f : fields){
	            Class t = f.getType();
	            if(f.getName().equalsIgnoreCase(fieldName)){
	            	if (t == Integer.class) {
	            		query.addCriteria(Criteria.where(fieldName).is(Integer.parseInt(value)));
	            	} 
	            	else if (t == String.class) {
	            		query.addCriteria(Criteria.where(fieldName).is(value));
	            	}
	            	else if (t == Double.class) {
	            		query.addCriteria(Criteria.where(fieldName).is(Double.parseDouble(value)));
	            	}else if(t == Date.class){
	            		query.addCriteria(Criteria.where(fieldName).is(value));
	            	}else if(t == Boolean.class){
	            		query.addCriteria(Criteria.where(fieldName).is(Boolean.parseBoolean(value)));
	            	}
	            }
	            
	        }
		
		//query.addCriteria(Criteria.where(fieldName).is(value));
		return mongoTemplate.find(query, className);
	}

	/**
	 * get master data by regex
	 * 
	 * @param className
	 * @param fieldName
	 * @param value
	 * @return List<MasterData>
	 */
	public List<MasterData> getAllByRegex(Class className, String fieldName, String value) {
		Query query = new Query();
		String regex = "^" + value;
		query.addCriteria(Criteria.where(fieldName).regex(regex));
		return mongoTemplate.find(query, className);
	}

	/**
	 * get master data by criteria
	 * 
	 * @param className
	 * @param fieldName
	 * @param fieldValue
	 * @param filterCriteria
	 * @return
	 */
	public List<MasterData> searchByCriteria(Class className, String fieldName, String fieldValue,
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
			if (NumberUtils.isNumber(fieldValue) && !"".equals(fieldValue.trim())) {
				criteria.where(fieldName).gt(fieldValue);
			}
			break;
		case LESSTHAN:
			if (NumberUtils.isNumber(fieldValue) && !"".equals(fieldValue.trim())) {
				criteria.where(fieldName).lt(fieldValue);
			}
			break;
		case GREATERTHANOREQUAL:
			if (NumberUtils.isNumber(fieldValue) && !"".equals(fieldValue.trim())) {
				criteria.where(fieldName).gte(fieldValue);
			}
			break;
		case LESSTHANOREQUAL:
			if (NumberUtils.isNumber(fieldValue) && !"".equals(fieldValue.trim())) {
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