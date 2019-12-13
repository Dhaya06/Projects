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
 * DTO class for company table
 * 
 * @version 1.0 12 Jan 2018
 * @author Mohomad Nusky
 */
@Document
public class Company extends MasterData {
	
	@NotNull(message = "Company id must not be null")
	@NotEmpty(message = "Company id cannot be empty")
	private String company_id;

	@NotNull(message = "Company name must not be null")
	@NotEmpty(message = "Company name cannot be empty")
	private String company_name;
	
	private String insurance_policy_no;
	
	private String contact_person;
	
	@Size(min = 10, max = 10, message = "Invalid contact person mobile number")
	private String contact_person_mobile_number;
	
	@Pattern(regexp = ".+@.+\\..+", message = "Invalid contact person email address")
	private String contact_person_email_address;
	
	private String group_id;
	
	private String company_address;
	
	@Size(min = 10, max = 10, message = "Invalid company phone number")
	private String company_phone;
	
	@Pattern(regexp = ".+@.+\\..+", message = "Invalid company email address")
	private String company_email_address;

	/**
	 * Default constructor
	 */
	public Company() {
	}

	

	/**
	 * Parameterized constructor
	 * 
	 * @param company_id
	 * @param company_name
	 * @param insurance_policy_no
	 * @param contact_person
	 * @param contact_person_mobile_number
	 * @param contact_person_email_address
	 * @param group_id
	 * @param company_address
	 * @param company_phone
	 * @param company_email_address
	 */
	public Company(String company_id, String company_name, String insurance_policy_no, String contact_person,
			String contact_person_mobile_number, String contact_person_email_address, String group_id,
			String company_address, String company_phone, String company_email_address) {
		super();
		this.company_id = company_id;
		this.company_name = company_name;
		this.insurance_policy_no = insurance_policy_no;
		this.contact_person = contact_person;
		this.contact_person_mobile_number = contact_person_mobile_number;
		this.contact_person_email_address = contact_person_email_address;
		this.group_id = group_id;
		this.company_address = company_address;
		this.company_phone = company_phone;
		this.company_email_address = company_email_address;
	}


	/**
	 * returns the company_id
	 *
	 * @return the company_id
	 */
	public String getCompany_id() {
		return company_id;
	}



	/**
	 * Sets the company_id to company_id
	 *
	 * @param company_id the company_id to set
	 */
	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}



	/**
	 * Returns the company name
	 * 
	 * @return the company_name
	 */
	public String getCompany_name() {
		return company_name;
	}

	/**
	 * Sets the company name
	 * 
	 * @param company_name the company_name to set
	 */
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	/**
	 * Returns the insurance policy no
	 * 
	 * @return the insurance_policy_no
	 */
	public String getInsurance_policy_no() {
		return insurance_policy_no;
	}

	/**
	 * Sets the insurance policy no
	 * 
	 * @param insurance_policy_no the insurance_policy_no to set
	 */
	public void setInsurance_policy_no(String insurance_policy_no) {
		this.insurance_policy_no = insurance_policy_no;
	}

	/**
	 * Returns the contact person of the company
	 * 
	 * @return the contact_person
	 */
	public String getContact_person() {
		return contact_person;
	}

	/**
	 * Sets the contact person of the company
	 * 
	 * @param contact_person the contact_person to set
	 */
	public void setContact_person(String contact_person) {
		this.contact_person = contact_person;
	}

	/**
	 * Returns the mobile number of the contact person
	 * 
	 * @return the contact_person_mobile_number
	 */
	public String getContact_person_mobile_number() {
		return contact_person_mobile_number;
	}

	/**
	 * Sets the mobile number of the contact person
	 * 
	 * @param contact_person_mobile_number the contact_person_mobile_number to set
	 */
	public void setContact_person_mobile_number(String contact_person_mobile_number) {
		this.contact_person_mobile_number = contact_person_mobile_number;
	}

	/**
	 * Returns the email address of the contact person
	 * 
	 * @return the contact_person_email_address
	 */
	public String getContact_person_email_address() {
		return contact_person_email_address;
	}

	/**
	 * Sets the email address of the contact person
	 * 
	 * @param contact_person_email_address the contact_person_email_address to set
	 */
	public void setContact_person_email_address(String contact_person_email_address) {
		this.contact_person_email_address = contact_person_email_address;
	}

	/**
	 * Returns the group id
	 * 
	 * @return the group_id
	 */
	public String getGroup_id() {
		return group_id;
	}

	/**
	 * Sets the group id
	 * 
	 * @param group_id the group_id to set
	 */
	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}

	/**
	 * Returns the company address
	 * 
	 * @return the company_address
	 */
	public String getCompany_address() {
		return company_address;
	}

	/**
	 * Sets the company address
	 * 
	 * @param company_address the company_address to set
	 */
	public void setCompany_address(String company_address) {
		this.company_address = company_address;
	}

	/**
	 * Returns the company phone number
	 * 
	 * @return the company_phone
	 */
	public String getCompany_phone() {
		return company_phone;
	}

	/**
	 * Sets the company phone number
	 * 
	 * @param company_phone the company_phone to set
	 */
	public void setCompany_phone(String company_phone) {
		this.company_phone = company_phone;
	}

	/**
	 * Returns the company email address
	 * 
	 * @return the company_email_address
	 */
	public String getCompany_email_address() {
		return company_email_address;
	}

	/**
	 * Sets the company email address
	 * 
	 * @param company_email_address the company_email_address to set
	 */
	public void setCompany_email_address(String company_email_address) {
		this.company_email_address = company_email_address;
	}

}