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
 * DTO class for procedure table
 * 
 * @version 1.0 12 Jan 2018
 * @author Mohomad Nusky
 */
@Document(collection = "procedure")
public class Procedure extends MasterData {
	
	@NotNull(message = "Procedure id must not be null")
	@NotEmpty(message = "Procedure id cannot be empty")
	private String procedure_id;

	@NotNull(message = "Procedure name not be null")
	@NotEmpty(message = "Procedure name cannot be empty")
	private String procedure_name;
	
	@NotNull(message = "Category id must not be null")
	@NotEmpty(message = "Category id cannot be empty")
	private String category_id;
	
	@NotNull(message = "Group id must not be null")
	@NotEmpty(message = "Group id cannot be empty")
	private String group_id;
	
	@NotNull(message = "Sub group id must not be null")
	@NotEmpty(message = "Sub group id cannot be empty")
	private String sub_group_id;
	
	
	private Boolean is_package;
	
	private Boolean is_inpatient;
	
	private Boolean is_consent_required;
	
	/**
	 * Default constructor
	 */
	public Procedure() {
		
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param procedure_id
	 * @param procedure_name
	 * @param category_id
	 * @param group_id
	 * @param sub_group_id
	 * @param is_package
	 * @param is_inpatient
	 * @param is_consent_required
	 * @param is_active
	 */
	public Procedure(String procedure_id,String procedure_name, String category_id, String group_id, String sub_group_id, Boolean is_package,
			Boolean is_inpatient, Boolean is_consent_required, Boolean is_active) {
		this.procedure_id = procedure_id;
		this.procedure_name = procedure_name;
		this.category_id = category_id;
		this.group_id = group_id;
		this.sub_group_id = sub_group_id;
		this.is_package = is_package;
		this.is_inpatient = is_inpatient;
		this.is_consent_required = is_consent_required;
	}
	
	

	/**
	 * returns the procedure_id
	 *
	 * @return the procedure_id
	 */
	public String getProcedure_id() {
		return procedure_id;
	}

	/**
	 * Sets the procedure_id to procedure_id
	 *
	 * @param procedure_id the procedure_id to set
	 */
	public void setProcedure_id(String procedure_id) {
		this.procedure_id = procedure_id;
	}

	/**
	 * @return the procedure_name
	 */
	public String getProcedure_name() {
		return procedure_name;
	}

	/**
	 * @param procedure_name the procedure_name to set
	 */
	public void setProcedure_name(String procedure_name) {
		this.procedure_name = procedure_name;
	}

	/**
	 * @return the category_id
	 */
	public String getCategory_id() {
		return category_id;
	}

	/**
	 * @param category_id the category_id to set
	 */
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	/**
	 * @return the group_id
	 */
	public String getGroup_id() {
		return group_id;
	}

	/**
	 * @param group_id the group_id to set
	 */
	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}

	/**
	 * @return the sub_group_id
	 */
	public String getSub_group_id() {
		return sub_group_id;
	}

	/**
	 * @param sub_group_id the sub_group_id to set
	 */
	public void setSub_group_id(String sub_group_id) {
		this.sub_group_id = sub_group_id;
	}

	/**
	 * @return the is_package
	 */
	public Boolean getIs_package() {
		return is_package;
	}

	/**
	 * @param is_package the is_package to set
	 */
	public void setIs_package(Boolean is_package) {
		this.is_package = is_package;
	}

	/**
	 * @return the is_inpatient
	 */
	public Boolean getIs_inpatient() {
		return is_inpatient;
	}

	/**
	 * @param is_inpatient the is_inpatient to set
	 */
	public void setIs_inpatient(Boolean is_inpatient) {
		this.is_inpatient = is_inpatient;
	}

	/**
	 * @return the is_consent_required
	 */
	public Boolean getIs_consent_required() {
		return is_consent_required;
	}

	/**
	 * @param is_consent_required the is_consent_required to set
	 */
	public void setIs_consent_required(Boolean is_consent_required) {
		this.is_consent_required = is_consent_required;
	}
}