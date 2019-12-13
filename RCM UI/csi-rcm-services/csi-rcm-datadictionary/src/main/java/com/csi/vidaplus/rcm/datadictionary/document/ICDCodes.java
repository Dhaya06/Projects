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
 * DTO class for cpt codes table
 * 
 * @version 1.0 12 Jan 2018
 * @author Mohomad Nusky
 */
@Document(collection = "icd_codes")
public class ICDCodes extends DataDictionary {

	@NotNull(message = "ICD code short description must not be null")
	@NotEmpty(message = "ICD code short description must not be empty")
	private String short_description;
	
	@NotNull(message = "ICD code long description must not be null")
	@NotEmpty(message = "ICD code long description must not be empty")
	private String long_description;

	/**
	 * 
	 */
	public ICDCodes() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param short_description
	 * @param long_description
	 */
	public ICDCodes(String short_description, String long_description) {
		this.short_description = short_description;
		this.long_description = long_description;
	}

	/**
	 * @return the short_description
	 */
	public String getShort_description() {
		return short_description;
	}

	/**
	 * @param short_description the short_description to set
	 */
	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}

	/**
	 * @return the long_description
	 */
	public String getLong_description() {
		return long_description;
	}

	/**
	 * @param long_description the long_description to set
	 */
	public void setLong_description(String long_description) {
		this.long_description = long_description;
	}
	
}