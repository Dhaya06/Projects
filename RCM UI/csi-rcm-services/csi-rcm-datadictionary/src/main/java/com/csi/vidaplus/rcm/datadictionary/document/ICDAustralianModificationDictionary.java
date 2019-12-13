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
 * DTO class for icd_am_dictionary table
 * 
 * @version 1.0 12 Jan 2018
 * @author Mohomad Nusky
 */
@Document(collection = "icd_australian_modification_dictionary")
public class ICDAustralianModificationDictionary extends DataDictionary {
	
	@NotNull(message = "Abbreviation must not be null")
	@NotEmpty(message = "Abbreviation cannot be empty")
	private String abbreviation;
	
	@NotNull(message = "Full description must not be null")
	@NotEmpty(message = "Full description cannot be empty")
	private String full_description;
	
	/**
	 * Default constructor
	 */
	public ICDAustralianModificationDictionary() {
	}

	/**
	 * @param abbreviation
	 * @param full_description
	 */
	public ICDAustralianModificationDictionary(String abbreviation, String full_description) {
		this.abbreviation = abbreviation;
		this.full_description = full_description;
	}

	/**
	 * @return the abbreviation
	 */
	public String getAbbreviation() {
		return abbreviation;
	}

	/**
	 * @param abbreviation the abbreviation to set
	 */
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
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