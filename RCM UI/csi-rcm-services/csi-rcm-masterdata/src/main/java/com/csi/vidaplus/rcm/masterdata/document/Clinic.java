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
package com.csi.vidaplus.rcm.masterdata.document;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * DTO class for clinic table
 * 
 * @version 1.0 12 Jan 2018
 * @author Ahsan Shamsudeen
 */
@Document(collection = "clinic")
public class Clinic extends MasterData {
	
	@NotNull(message = "Clinic Id must not be null")
	@NotEmpty(message = "Clinic Id cannot be empty")
	private String clinic_id;

	@NotNull(message = "Clinic description must not be null")
	@NotEmpty(message = "Clinic description cannot be empty")
	private String clinic_description;
	
	@NotNull(message = "Clinic group Id must not be null")
	@NotEmpty(message = "Clinic group Id cannot be empty")
	private String group_id;
	

	/**
	 * Default constructor
	 */
	public Clinic() {
	}
	
	

	/**
	 * Parameterized constructor
	 * 
	 * @param clinic_id
	 * @param clinic_description
	 * @param group_id
	 * @param is_active
	 */
	public Clinic(String clinic_id, String clinic_description, String group_id) {
		super();
		this.clinic_id = clinic_id;
		this.clinic_description = clinic_description;
		this.group_id = group_id;
	}

	/**
	 * returns the clinic_id
	 *
	 * @return the clinic_id
	 */
	public String getClinic_id() {
		return clinic_id;
	}



	/**
	 * Sets the clinic_id to clinic_id
	 *
	 * @param clinic_id the clinic_id to set
	 */
	public void setClinic_id(String clinic_id) {
		this.clinic_id = clinic_id;
	}



	/**
	 * Returns the clinic description
	 * 
	 * @return the clinic_description
	 */
	public String getClinic_description() {
		return clinic_description;
	}

	/**
	 * Sets the clinic description
	 * 
	 * @param clinic_description
	 *            the clinic_description to set
	 */
	public void setClinic_description(String clinic_description) {
		this.clinic_description = clinic_description;
	}

	/**
	 * Returns the clinic group id
	 * 
	 * @return the group_id
	 */
	public String getGroup_id() {
		return group_id;
	}

	/**
	 * Sets the clinic group id
	 * 
	 * @param group_id
	 *            the group_id to set
	 */
	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}

}