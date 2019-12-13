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
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * DTO class for company group table
 * 
 * @version 1.0 12 Jan 2018
 * @author Mohomad Nusky
 */
@Document(collection = "company_group")
public class CompanyGroup extends MasterData {
	
	@NotNull(message = "Company id name must not be null")
	@NotEmpty(message = "Company id name cannot be empty")
	@Indexed(unique=true)
	private String group_id;

	@NotNull(message = "Company group name must not be null")
	@NotEmpty(message = "Company group name cannot be empty")
	private String group_name;
	
	@NotNull(message = "Is eligibility check cannot be null")
	@NotEmpty(message = "Is eligibility check cannot be empty")
	private Boolean is_eligibility_check_required;
	
	@NotNull(message = "Is electronic claim check cannot be null")
	@NotEmpty(message = "Is electronic claim check cannot be empty")
	private Boolean is_electronic_claim;
	
	@NotNull(message = "Maximum allowed amount cannot be null")
	@NotEmpty(message = "Maximum allowed amount check cannot be empty")
	private String maximum_allowed_discount;
	
	private String effective_date;
	
	private String approval_limit_days;
	
	@Pattern(regexp = ".+@.+\\..+", message = "Invalid company group email address")
	private String email_address;
	
	@Size(min = 10, max = 10, message = "Invalid company group phone number")
	private String phone_number;
	
	private String address;
	
	private String contact_person;
	
	@Size(min = 10, max = 10, message = "Invalid contact person mobile number")
	private String contact_person_mobile_number;
	
	@Pattern(regexp = ".+@.+\\..+", message = "Invalid contact person email address")
	private String contact_person_email_address;
	
	/**
	 * Default constructor
	 */
	public CompanyGroup() {
	}



	/**
	 * Parameterized constructor
	 * 
	 * @param group_id
	 * @param group_name
	 * @param is_eligibility_check_required
	 * @param is_electronic_claim
	 * @param maximum_allowed_discount
	 * @param is_active
	 * @param effective_date
	 * @param approval_limit_days
	 * @param email_address
	 * @param phone_number
	 * @param address
	 * @param contact_person
	 * @param contact_person_mobile_number
	 * @param contact_person_email_address
	 */
	public CompanyGroup(String group_id, String group_name, Boolean is_eligibility_check_required,
			Boolean is_electronic_claim, String maximum_allowed_discount, Boolean is_active, String effective_date,
			String approval_limit_days, String email_address, String phone_number, String address,
			String contact_person, String contact_person_mobile_number, String contact_person_email_address) {
		super();
		this.group_id = group_id;
		this.group_name = group_name;
		this.is_eligibility_check_required = is_eligibility_check_required;
		this.is_electronic_claim = is_electronic_claim;
		this.maximum_allowed_discount = maximum_allowed_discount;
		this.effective_date = effective_date;
		this.approval_limit_days = approval_limit_days;
		this.email_address = email_address;
		this.phone_number = phone_number;
		this.address = address;
		this.contact_person = contact_person;
		this.contact_person_mobile_number = contact_person_mobile_number;
		this.contact_person_email_address = contact_person_email_address;
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
	 * Returns the company group name
	 * 
	 * @return the group_name
	 */
	public String getGroup_name() {
		return group_name;
	}

	/**
	 * Sets the company group name
	 * 
	 * @param group_name the group_name to set
	 */
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}

	/**
	 * Returns the value for whether eligibility check is required for company group
	 * 
	 * @return the is_eligibility_check_required
	 */
	public Boolean getIs_eligibility_check_required() {
		return is_eligibility_check_required;
	}

	/**
	 * Sets the value for whether eligibility check is required for company group
	 * 
	 * @param is_eligibility_check_required the is_eligibility_check_required to set
	 */
	public void setIs_eligibility_check_required(Boolean is_eligibility_check_required) {
		this.is_eligibility_check_required = is_eligibility_check_required;
	}

	/**
	 * Returns the value for whether electronic claim is required for company group
	 * 
	 * @return the is_electronic_claim
	 */
	public Boolean getIs_electronic_claim() {
		return is_electronic_claim;
	}

	/**
	 * Sets the value for whether electronic claim is required for company group
	 * 
	 * @param is_electronic_claim the is_electronic_claim to set
	 */
	public void setIs_electronic_claim(Boolean is_electronic_claim) {
		this.is_electronic_claim = is_electronic_claim;
	}

	/**
	 * Returns the maximum allowed discount for company group
	 * 
	 * @return the maximum_allowed_discount
	 */
	public String getMaximum_allowed_discount() {
		return maximum_allowed_discount;
	}

	/**
	 * Sets the maximum allowed discount for company group
	 * 
	 * @param maximum_allowed_discount the maximum_allowed_discount to set
	 */
	public void setMaximum_allowed_discount(String maximum_allowed_discount) {
		this.maximum_allowed_discount = maximum_allowed_discount;
	}

	/**
	 * Returns the effective date for company group
	 * 
	 * @return the effective_date
	 */
	public String getEffective_date() {
		return effective_date;
	}

	/**
	 * Sets the effective date for company group
	 * 
	 * @param effective_date the effective_date to set
	 */
	public void setEffective_date(String effective_date) {
		this.effective_date = effective_date;
	}

	/**
	 * Returns the approval limit days for company group
	 * 
	 * @return the approval_limit_days
	 */
	public String getApproval_limit_days() {
		return approval_limit_days;
	}

	/**
	 * Sets the approval limit days for company group
	 * 
	 * @param approval_limit_days the approval_limit_days to set
	 */
	public void setApproval_limit_days(String approval_limit_days) {
		this.approval_limit_days = approval_limit_days;
	}

	/**
	 * Returns the email address for company group
	 * 
	 * @return the email_address
	 */
	public String getEmail_address() {
		return email_address;
	}

	/**
	 * Sets the email address for company group
	 * 
	 * @param email_address the email_address to set
	 */
	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}

	/**
	 * Returns the phone number for company group
	 * 
	 * @return the phone_number
	 */
	public String getPhone_number() {
		return phone_number;
	}

	/**
	 * Sets the phone number for company group
	 * 
	 * @param phone_number the phone_number to set
	 */
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	/**
	 * Returns the address for company group
	 * 
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address for company group
	 * 
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Returns the contact person of the company group
	 * 
	 * @return the contact_person
	 */
	public String getContact_person() {
		return contact_person;
	}

	/**
	 * Sets the contact person of the company group
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
}