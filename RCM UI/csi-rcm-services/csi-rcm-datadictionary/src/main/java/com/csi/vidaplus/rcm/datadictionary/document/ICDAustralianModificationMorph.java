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
 * DTO class for icd_am_morph table
 * 
 * @version 1.0 12 Jan 2018
 * @author Mohomad Nusky
 */
@Document(collection = "icd_australian_modification_morph")
public class ICDAustralianModificationMorph extends DataDictionary {

	private String aust_code;

	@NotNull(message = "Full description must not be null")
	@NotEmpty(message = "Full description cannot be empty")
	private String full_description;
	
	private String ascii_short;
	
	private String effective_date;
	
	private String in_active;

	/**
	 * Default constructor
	 */
	public ICDAustralianModificationMorph() {
	}

	/**
	 * @param aust_code
	 * @param full_description
	 * @param ascii_short
	 * @param effective_date
	 * @param in_active
	 */
	public ICDAustralianModificationMorph(String aust_code, String full_description, String ascii_short,
			String effective_date, String in_active) {
		this.aust_code = aust_code;
		this.full_description = full_description;
		this.ascii_short = ascii_short;
		this.effective_date = effective_date;
		this.in_active = in_active;
	}

	/**
	 * @return the aust_code
	 */
	public String getAust_code() {
		return aust_code;
	}

	/**
	 * @param aust_code the aust_code to set
	 */
	public void setAust_code(String aust_code) {
		this.aust_code = aust_code;
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

	/**
	 * @return the ascii_short
	 */
	public String getAscii_short() {
		return ascii_short;
	}

	/**
	 * @param ascii_short the ascii_short to set
	 */
	public void setAscii_short(String ascii_short) {
		this.ascii_short = ascii_short;
	}

	/**
	 * @return the effective_date
	 */
	public String getEffective_date() {
		return effective_date;
	}

	/**
	 * @param effective_date the effective_date to set
	 */
	public void setEffective_date(String effective_date) {
		this.effective_date = effective_date;
	}

	/**
	 * @return the in_active
	 */
	public String getIn_active() {
		return in_active;
	}

	/**
	 * @param in_active the in_active to set
	 */
	public void setIn_active(String in_active) {
		this.in_active = in_active;
	}
}