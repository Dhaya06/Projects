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

import java.io.Serializable;

import org.springframework.data.annotation.Id;

/**
 * Parent class for the DTO classes
 * 
 * @version 1.0 12 Jan 2018
 * @author Mohomad Nusky
 */
public class DataDictionary implements Serializable {

	@Id
	private String _id;
	
	private String created_by;
	private String created_on;
	private String edited_by;
	private String edited_on;
	private String row_version;
	
	/**
	 * Returns the id
	 * 
	 * @return the _id
	 */
	public String get_id() {
		return _id;
	}
	
	/**
	 * Sets the id
	 * 
	 * @param _id the _id to set
	 */
	public void set_id(String _id) {
		this._id = _id;
	}

	/**
	 * returns the created_by
	 *
	 * @return the created_by
	 */
	public String getCreated_by() {
		return created_by;
	}

	/**
	 * Sets the created_by to created_by
	 *
	 * @param created_by the created_by to set
	 */
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	/**
	 * returns the created_on
	 *
	 * @return the created_on
	 */
	public String getCreated_on() {
		return created_on;
	}

	/**
	 * Sets the created_on to created_on
	 *
	 * @param created_on the created_on to set
	 */
	public void setCreated_on(String created_on) {
		this.created_on = created_on;
	}

	/**
	 * returns the edited_by
	 *
	 * @return the edited_by
	 */
	public String getEdited_by() {
		return edited_by;
	}

	/**
	 * Sets the edited_by to edited_by
	 *
	 * @param edited_by the edited_by to set
	 */
	public void setEdited_by(String edited_by) {
		this.edited_by = edited_by;
	}

	/**
	 * returns the edited_on
	 *
	 * @return the edited_on
	 */
	public String getEdited_on() {
		return edited_on;
	}

	/**
	 * Sets the edited_on to edited_on
	 *
	 * @param edited_on the edited_on to set
	 */
	public void setEdited_on(String edited_on) {
		this.edited_on = edited_on;
	}

	/**
	 * returns the row_version
	 *
	 * @return the row_version
	 */
	public String getRow_version() {
		return row_version;
	}

	/**
	 * Sets the row_version to row_version
	 *
	 * @param row_version the row_version to set
	 */
	public void setRow_version(String row_version) {
		this.row_version = row_version;
	}

	
}