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
package com.csi.vidaplus.rcm.datadictionary.document;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * DTO class for icd_who_cm_map table
 * 
 * @version 1.0 12 Jan 2018
 * @author Mohomad Nusky
 */
@Document(collection = "icd_who_clinical_modification_map")
public class ICDWHOClinicalModificationMap extends DataDictionary {

	@NotNull(message = "ICD WHO code must not be null")
	@NotEmpty(message = "ICD WHO cannot be empty")
	private String icd_10_who;
	
	@NotNull(message = "ICD CM code must not be null")
	@NotEmpty(message = "ICD CM code cannot be empty")
	private String icd_10_cm;

	/**
	 * Default constructor
	 */
	public ICDWHOClinicalModificationMap() {
	}

	/**
	 * @param icd_10_who
	 * @param icd_10_cm
	 */
	public ICDWHOClinicalModificationMap(String icd_10_who, String icd_10_cm) {
		this.icd_10_who = icd_10_who;
		this.icd_10_cm = icd_10_cm;
	}

	/**
	 * @return the icd_10_who
	 */
	public String getIcd_10_who() {
		return icd_10_who;
	}

	/**
	 * @param icd_10_who the icd_10_who to set
	 */
	public void setIcd_10_who(String icd_10_who) {
		this.icd_10_who = icd_10_who;
	}

	/**
	 * @return the icd_10_cm
	 */
	public String getIcd_10_cm() {
		return icd_10_cm;
	}

	/**
	 * @param icd_10_cm the icd_10_cm to set
	 */
	public void setIcd_10_cm(String icd_10_cm) {
		this.icd_10_cm = icd_10_cm;
	}
}