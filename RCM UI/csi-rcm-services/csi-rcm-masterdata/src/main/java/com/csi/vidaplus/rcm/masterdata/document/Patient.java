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
 * DTO class for patient table
 * 
 * @version 1.0 12 Jan 2018
 * @author Ahsan Shamsudeen
 */
@Document
public class Patient extends MasterData {
	
	
	private String patient_id; 

	@NotNull(message = "Patients name must not be null")
	@NotEmpty(message = "Patients name cannot be empty")
	private String patient_name;

	@NotNull(message = "National Identification No. must not be null")
	@NotEmpty(message = "National Identification. cannot be empty")
	private String nic;
	private String passport_no;
	
	private String registration_date;
	
	@NotNull(message = "Gender cannot be null")
	@NotEmpty(message = "Gender  name cannot be empty")
	private String gender;
	
	private String date_of_birth;
	
	private String first_visit;
	
	private String last_visit;
	
	private String no_of_visit;
	
	@Size(min = 10, max = 10, message = "Invalid phone number")
	private String phone;
	
	@Size(min = 10, max = 10, message = "Invalid mobile number")
	private String mobile_number;
	
	@Pattern(regexp=".+@.+\\..+", message="Invalid email address")
	private String email_address;
	
	private String blood_group;

	/**
	 * Default constructor
	 */
	public Patient() {
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param patient_name
	 * @param registration_date
	 * @param gender
	 * @param date_of_birth
	 * @param first_visit
	 * @param last_visit
	 * @param no_of_visit
	 * @param phone
	 * @param mobile_number
	 * @param email_address
	 * @param blood_group
	 */
	public Patient(String patient_name, String registration_date, String gender,
			String date_of_birth, String first_visit, String last_visit, String no_of_visit, String phone,
			String mobile_number, String email_address, String blood_group) {
		this.patient_name = patient_name;
		this.registration_date = registration_date;
		this.gender = gender;
		this.date_of_birth = date_of_birth;
		this.first_visit = first_visit;
		this.last_visit = last_visit;
		this.no_of_visit = no_of_visit;
		this.phone = phone;
		this.mobile_number = mobile_number;
		this.email_address = email_address;
		this.blood_group = blood_group;
	}

	/**
	 * Returns the patient name
	 * 
	 * @return the patient_name
	 */
	public String getPatient_name() {
		return patient_name;
	}

	/**
	 * Sets the patient name
	 * 
	 * @param patient_name
	 *            the patient_name to set
	 */
	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}

	/**
	 * get the passport no
	 * @return passport no
	 */
	public String getPassport_no() {
		return passport_no;
	}

	/**
	 * set passport no
	 * @param passport_no
	 */
	public void setPassport_no(String passport_no) {
		this.passport_no = passport_no;
	}

	/**
	 * Get National Identification No
	 * @return
	 */
	public String getNic() {
		return nic;
	}

	/**
	 * set National Identification No
	 * @param nic
	 */
	public void setNic(String nic) {
		this.nic = nic;
	}

	/**
	 * Returns the registration date of the patient
	 * 
	 * @return the registration_date
	 */
	public String getRegistration_date() {
		return registration_date;
	}

	/**
	 * Sets the registration date of the patient
	 * 
	 * @param registration_date
	 *            the registration_date to set
	 */
	public void setRegistration_date(String registration_date) {
		this.registration_date = registration_date;
	}

	/**
	 * Returns the patient's gender
	 * 
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Sets the patient's gender
	 * 
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Returns the patient's date of birth
	 * 
	 * @return the date_of_birth
	 */
	public String getDate_of_birth() {
		return date_of_birth;
	}

	/**
	 * Sets the patient's date of birth
	 * 
	 * @param date_of_birth
	 *            the date_of_birth to set
	 */
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	/**
	 * Returns the patient's initial visit date
	 * 
	 * @return the first_visit
	 */
	public String getFirst_visit() {
		return first_visit;
	}

	/**
	 * Sets the patient's initial visit date
	 * 
	 * @param first_visit
	 *            the first_visit to set
	 */
	public void setFirst_visit(String first_visit) {
		this.first_visit = first_visit;
	}

	/**
	 * Returns the patient's last visit date
	 * 
	 * @return the last_visit
	 */
	public String getLast_visit() {
		return last_visit;
	}

	/**
	 * Sets the patient's last visit date
	 * 
	 * @param last_visit
	 *            the last_visit to set
	 */
	public void setLast_visit(String last_visit) {
		this.last_visit = last_visit;
	}

	/**
	 * Returns the patient's number of visits
	 * 
	 * @return the no_of_visit
	 */
	public String getNo_of_visit() {
		return no_of_visit;
	}

	/**
	 * Sets the patient's number of visits
	 * 
	 * @param no_of_visit
	 *            the no_of_visit to set
	 */
	public void setNo_of_visit(String no_of_visit) {
		this.no_of_visit = no_of_visit;
	}

	/**
	 * Returns the patient's phone number
	 * 
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the patient's phone number
	 * 
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Returns the patient's mobile number
	 * 
	 * @return the mobile_number
	 */
	public String getMobile_number() {
		return mobile_number;
	}

	/**
	 * Sets the patient's mobile number
	 * 
	 * @param mobile_number
	 *            the mobile_number to set
	 */
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	/**
	 * Returns the patient's email address
	 * 
	 * @return the email_address
	 */
	public String getEmail_address() {
		return email_address;
	}

	/**
	 * Sets the patient's email address
	 * 
	 * @param email_address
	 *            the email_address to set
	 */
	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}

	/**
	 * Returns the patient's blood group
	 * 
	 * @return the blood_group
	 */
	public String getBlood_group() {
		return blood_group;
	}

	/**
	 * Sets the patient's blood group
	 * 
	 * @param blood_group
	 *            the blood_group to set
	 */
	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}

}