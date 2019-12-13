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

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Parent class for the DTO classes
 * 
 * @version 1.0 12 Jan 2018
 * @author Firstname Lastname
 */
public class MasterData implements Serializable {

	@Id
	private String _id;
	
	private Integer created_by;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date created_on;
	
	
	private Integer edited_by;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date edited_on;
	
	private String row_version;

	private Boolean is_active;
	
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
	 * returns the created_on
	 *
	 * @return the created_on
	 */
	public Date getCreated_on() {
		return created_on;
	}

	/**
	 * Sets the created_on to created_on
	 *
	 * @param created_on the created_on to set
	 */
	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}

	/**
	 * returns the edited_on
	 *
	 * @return the edited_on
	 */
	public Date getEdited_on() {
		return edited_on;
	}

	/**
	 * Sets the edited_on to edited_on
	 *
	 * @param edited_on the edited_on to set
	 */
	public void setEdited_on(Date edited_on) {
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

	/**
	 * returns the created_by
	 *
	 * @return the created_by
	 */
	public Integer getCreated_by() {
		return created_by;
	}

	/**
	 * Sets the created_by to created_by
	 *
	 * @param created_by the created_by to set
	 */
	public void setCreated_by(Integer created_by) {
		this.created_by = created_by;
	}

	/**
	 * returns the edited_by
	 *
	 * @return the edited_by
	 */
	public Integer getEdited_by() {
		return edited_by;
	}

	/**
	 * Sets the edited_by to edited_by
	 *
	 * @param edited_by the edited_by to set
	 */
	public void setEdited_by(Integer edited_by) {
		this.edited_by = edited_by;
	}

	public Boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}

	
}