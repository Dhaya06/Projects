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
@Document(collection = "cpt_codes")
public class CPTCodes extends DataDictionary {

	@NotNull(message = "CPT short description must not be null")
	@NotEmpty(message = "CPT short description cannot be empty")
	private String short_description;
	
	@NotNull(message = "CPT long description must not be null")
	@NotEmpty(message = "CPT long description cannot be empty")
	private String long_description;
	
	@NotNull(message = "CPT full description must not be null")
	@NotEmpty(message = "CPT full description cannot be empty")
	private String full_description;

	/**
	 * Default constructor
	 */
	public CPTCodes() {
	}

	/**
	 * @param short_description
	 * @param long_description
	 * @param full_description
	 */
	public CPTCodes(String short_description, String long_description, String full_description) {
		this.short_description = short_description;
		this.long_description = long_description;
		this.full_description = full_description;
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

	/**
	 * @return the full_description
	 */
	public String getFull_description() {
		return full_description;
	}

	/**
	 * @param full_description the full_description to set
	 */
	public void setFull_description(String full_description) {
		this.full_description = full_description;
	}

	
}