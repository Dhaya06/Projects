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
package com.csi.vidaplus.rcm.masterdata.service;

import java.util.List;

import com.csi.vidaplus.rcm.masterdata.document.MasterData;
import com.csi.vidaplus.rcm.masterdata.util.FilterCriteria;

/**
 * Master data builder interface
 * 
 * @version 1.0 12 Jan 2018
 * @author Ahsan Shamsudeen
 */
public interface MasterDataService {

	void add(MasterData masterData);

	void edit(MasterData masterData);

	void delete(String id,Class className);

	List<MasterData> getAll(Class className);

	MasterData getById(String id,Class className);

	List<MasterData> getAllByField(Class className, String fieldName, String value);

	List<MasterData> getAllByRegex(Class className, String fieldName, String value);

	List<MasterData> searchByCriteria(Class  className, String fieldName, String fieldValue, FilterCriteria filterCriteria);
}