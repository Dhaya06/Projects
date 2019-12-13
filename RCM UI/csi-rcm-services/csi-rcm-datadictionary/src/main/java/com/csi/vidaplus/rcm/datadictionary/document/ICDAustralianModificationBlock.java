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
 * DTO class for icd_am_block table
 * 
 * @version 1.0 12 Jan 2018
 * @author Mohomad Nusky
 */
@Document(collection = "icd_australian_modification_block")
public class ICDAustralianModificationBlock extends DataDictionary {

	@NotNull(message = "Ascii description must not be null")
	@NotEmpty(message = "Ascii description cannot be empty")
	private String ascii_desc;
	
	private String ascii_short;
	
	private String effective_date;
	
	private String inactive;
	
	/**
	 * Default constructor
	 */
	public ICDAustralianModificationBlock() {
	}

	/**
	 * @param ascii_desc
	 * @param ascii_short
	 * @param effective_date
	 * @param inactive
	 */
	public ICDAustralianModificationBlock(String ascii_desc, String ascii_short, String effective_date,
			String inactive) {
		this.ascii_desc = ascii_desc;
		this.ascii_short = ascii_short;
		this.effective_date = effective_date;
		this.inactive = inactive;
	}

	/**
	 * @return the ascii_desc
	 */
	public String getAscii_desc() {
		return ascii_desc;
	}

	/**
	 * @param ascii_desc the ascii_desc to set
	 */
	public void setAscii_desc(String ascii_desc) {
		this.ascii_desc = ascii_desc;
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
	 * @return the inactive
	 */
	public String getInactive() {
		return inactive;
	}

	/**
	 * @param inactive the inactive to set
	 */
	public void setInactive(String inactive) {
		this.inactive = inactive;
	}

}