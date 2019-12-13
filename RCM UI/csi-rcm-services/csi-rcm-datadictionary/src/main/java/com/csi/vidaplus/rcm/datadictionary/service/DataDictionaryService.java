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
package com.csi.vidaplus.rcm.datadictionary.service;

import java.util.List;

import com.csi.vidaplus.rcm.datadictionary.document.DataDictionary;
import com.csi.vidaplus.rcm.datadictionary.util.FilterCriteria;

/**
 * Data dictionary builder interface
 * 
 * @version 1.0 12 Jan 2018
 * @author Mohomad Nusky
 */
public interface DataDictionaryService {

	void add(DataDictionary dataDictionary);

	void edit(DataDictionary dataDictionary);

	void delete(String id,Class className);

	List<DataDictionary> getAll(Class className);

	DataDictionary getById(String id,Class className);

	List<DataDictionary> getAllByField(Class className, String fieldName, String value);

	List<DataDictionary> getAllByRegex(Class className, String fieldName, String value);

	List<DataDictionary> searchByCriteria(Class  className, String fieldName, String fieldValue, FilterCriteria filterCriteria);
}