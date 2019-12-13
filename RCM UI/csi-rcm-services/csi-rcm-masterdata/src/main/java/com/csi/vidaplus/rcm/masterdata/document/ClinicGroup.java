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
 * DTO class for clinic group table
 * 
 * @version 1.0 12 Jan 2018
 * @author Firstname Lastname
 */
@Document(collection = "clinic_group")
public class ClinicGroup extends MasterData {
	
	@NotNull(message = "Clinic group id must not be null")
	@NotEmpty(message = "Clinic group id cannot be empty")
	private String clinic_group_id;

	@NotNull(message = "Clinic group description must not be null")
	@NotEmpty(message = "Clinic group description cannot be empty")
	private String group_description;

	/**
	 * Default constructor
	 */
	public ClinicGroup() {
	}

	
	/**
	 * Parameterized constructor
	 * 
	 * @param clinic_group_id
	 * @param group_description
	 * @param is_active
	 */
	public ClinicGroup(String clinic_group_id, String group_description, Boolean is_active) {
		super();
		this.clinic_group_id = clinic_group_id;
		this.group_description = group_description;
	}
	
	


	/**
	 * returns the clinic_group_id
	 *
	 * @return the clinic_group_id
	 */
	public String getClinic_group_id() {
		return clinic_group_id;
	}


	/**
	 * Sets the clinic_group_id to clinic_group_id
	 *
	 * @param clinic_group_id the clinic_group_id to set
	 */
	public void setClinic_group_id(String clinic_group_id) {
		this.clinic_group_id = clinic_group_id;
	}


	/**
	 * Returns the clinic group description
	 * 
	 * @return the group_description
	 */
	public String getGroup_description() {
		return group_description;
	}

	/**
	 * Sets the clinic group description
	 * 
	 * @param group_description
	 *            the group_description to set
	 */
	public void setGroup_description(String group_description) {
		this.group_description = group_description;
	}

}