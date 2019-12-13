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
 * DTO class for procedure group table
 * 
 * @version 1.0 12 Jan 2018
 * @author Mohomad Nusky
 */
@Document(collection = "procedure_group")
public class ProcedureGroup extends MasterData {
	
	@NotNull(message = "Procedure group id must not be null")
	@NotEmpty(message = "Procedure group id cannot be empty")
	private String group_id;

	@NotNull(message = "Procedure group description must not be null")
	@NotEmpty(message = "Procedure group description cannot be empty")
	private String group_description;

	/**
	 * Default constructor
	 */
	public ProcedureGroup() {
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param group_id
	 * @param group_description
	 */
	public ProcedureGroup(String group_id,String group_description) {
		this.group_id = group_id;
		this.group_description = group_description;
	}
	
	

	/**
	 * returns the group_id
	 *
	 * @return the group_id
	 */
	public String getGroup_id() {
		return group_id;
	}

	/**
	 * Sets the group_id to group_id
	 *
	 * @param group_id the group_id to set
	 */
	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}

	/**
	 * Returns the procedure group description
	 * 
	 * @return the group_description
	 */
	public String getGroup_description() {
		return group_description;
	}

	/**
	 * Sets the procedure group description
	 * 
	 * @param group_description
	 *            the group_description to set
	 */
	public void setGroup_description(String group_description) {
		this.group_description = group_description;
	}


}