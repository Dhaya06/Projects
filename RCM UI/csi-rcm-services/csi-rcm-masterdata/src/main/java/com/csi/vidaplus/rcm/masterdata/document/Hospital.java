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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * DTO class for hospital table
 * 
 * @version 1.0 12 Jan 2018
 * @author Firstname Lastname
 */
@Document
public class Hospital extends MasterData {
	
	@NotNull(message = "Hospital id must not be null")
	@NotEmpty(message = "Hospital id cannot be empty")
	private String hospital_id;

	@NotNull(message = "Hospital name must not be null")
	@NotEmpty(message = "Hospital name cannot be empty")
	private String hospital_name;

	private String contact_person;

	@Size(min = 10, max = 10, message = "Invalid phone number")
	private String contact_person_mobile_number;

	@Pattern(regexp = ".+@.+\\..+", message = "Invalid email address")
	private String contact_person_email_address;

	@NotNull(message = "Hospital name must not be null")
	@NotEmpty(message = "Hospital name cannot be empty")
	private String hospital_address;

	/**
	 * Default constructor
	 */
	public Hospital() {
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param hospital_id
	 * @param hospital_name
	 * @param contact_person
	 * @param contact_person_mobile_number
	 * @param contact_person_email_address
	 * @param hospital_address
	 */
	public Hospital(String hopital_id,String hospital_name, String contact_person, String contact_person_mobile_number,
			String contact_person_email_address, String hospital_address) {
		this.hospital_id = hopital_id;
		this.hospital_name = hospital_name;
		this.contact_person = contact_person;
		this.contact_person_mobile_number = contact_person_mobile_number;
		this.contact_person_email_address = contact_person_email_address;
		this.hospital_address = hospital_address;
	}
	
	

	/**
	 * returns the hospital_id
	 *
	 * @return the hospital_id
	 */
	public String getHospital_id() {
		return hospital_id;
	}

	/**
	 * Sets the hospital_id to hospital_id
	 *
	 * @param hospital_id the hospital_id to set
	 */
	public void setHospital_id(String hospital_id) {
		this.hospital_id = hospital_id;
	}

	/**
	 * Returns the hospital name
	 * 
	 * @return the hospital_name
	 */
	public String getHospital_name() {
		return hospital_name;
	}

	/**
	 * Sets the hospital name
	 * 
	 * @param hospital_name
	 *            the hospital_name to set
	 */
	public void setHospital_name(String hospital_name) {
		this.hospital_name = hospital_name;
	}

	/**
	 * Returns the contact person for the hospital
	 * 
	 * @return the contact_person
	 */
	public String getContact_person() {
		return contact_person;
	}

	/**
	 * Sets the contact person for the hospital
	 * 
	 * @param contact_person
	 *            the contact_person to set
	 */
	public void setContact_person(String contact_person) {
		this.contact_person = contact_person;
	}

	/**
	 * Returns the contact person's mobile number
	 * 
	 * @return the contact_person_mobile_number
	 */
	public String getContact_person_mobile_number() {
		return contact_person_mobile_number;
	}

	/**
	 * Sets the contact person's mobile number
	 * 
	 * @param contact_person_mobile_number
	 *            the contact_person_mobile_number to set
	 */
	public void setContact_person_mobile_number(String contact_person_mobile_number) {
		this.contact_person_mobile_number = contact_person_mobile_number;
	}

	/**
	 * Returns the contact person's email address
	 * 
	 * @return the contact_person_email_address
	 */
	public String getContact_person_email_address() {
		return contact_person_email_address;
	}

	/**
	 * Sets the contact person's email address
	 * 
	 * @param contact_person_email_address
	 *            the contact_person_email_address to set
	 */
	public void setContact_person_email_address(String contact_person_email_address) {
		this.contact_person_email_address = contact_person_email_address;
	}

	/**
	 * Returns the hospital address
	 * 
	 * @return the hospital_address
	 */
	public String getHospital_address() {
		return hospital_address;
	}

	/**
	 * Sets the hospital address
	 * 
	 * @param hospital_address
	 *            the hospital_address to set
	 */
	public void setHospital_address(String hospital_address) {
		this.hospital_address = hospital_address;
	}

}