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
 * DTO class for doctor table
 * 
 * @version 1.0 12 Jan 2018
 * @author Ahsan Shamsudeen
 */
@Document
public class Doctor extends MasterData {
	
	@NotNull(message = "Doctor id must not be null")
	@NotEmpty(message = "Doctor id cannot be empty")
	private String doctor_id;

	@NotNull(message = "Doctor name must not be null")
	@NotEmpty(message = "Doctor name cannot be empty")
	private String doctor_name;

	@NotNull(message = "Registration No. must not be null")
	@NotEmpty(message = "Registration No. cannot be empty")
	private String reg_no;
	private String nic;
	private String passport_no;

	@NotNull(message = "Gender cannot be null")
	@NotEmpty(message = "Gender  name cannot be empty")
	private String gender;

	private String date_of_birth;

	@Size(min = 10, max = 10, message = "Invalid phone number")
	private String phone;

	@Size(min = 10, max = 10, message = "Invalid mobile number")
	private String mobile_number;

	private String address;

	@Pattern(regexp = ".+@.+\\..+", message = "Invalid email address")
	private String email;

	private String date_of_joining;

	private String date_of_leaving;

	/**
	 * Default constructor
	 */
	public Doctor() {
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param doctor_id
	 * @param doctor_name
	 * @param gender
	 * @param date_of_birth
	 * @param phone
	 * @param mobile_number
	 * @param address
	 * @param email
	 * @param date_of_joining
	 * @param date_of_leaving
	 */
	public Doctor(String doctor_id,String doctor_name, String gender, String date_of_birth, String phone, String mobile_number,
			String address, String email, String date_of_joining, String date_of_leaving) {
		this.doctor_id = doctor_id;
		this.doctor_name = doctor_name;
		this.gender = gender;
		this.date_of_birth = date_of_birth;
		this.phone = phone;
		this.mobile_number = mobile_number;
		this.address = address;
		this.email = email;
		this.date_of_joining = date_of_joining;
		this.date_of_leaving = date_of_leaving;
	}
	
	

	/**
	 * returns the doctor_id
	 *
	 * @return the doctor_id
	 */
	public String getDoctor_id() {
		return doctor_id;
	}

	/**
	 * Sets the doctor_id to doctor_id
	 *
	 * @param doctor_id the doctor_id to set
	 */
	public void setDoctor_id(String doctor_id) {
		this.doctor_id = doctor_id;
	}

	/**
	 * Returns the doctor name
	 * 
	 * @return the doctor_name
	 */
	public String getDoctor_name() {
		return doctor_name;
	}

	/**
	 * Sets the doctor name
	 * 
	 * @param doctor_name
	 *            the doctor_name to set
	 */
	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}

	/**
	 * sets the registration no
	 * @return registration no
	 */
	public String getReg_no() {
		return reg_no;
	}

	/**
	 * set registration no
	 * @param reg_no
	 */
	public void setReg_no(String reg_no) {
		this.reg_no = reg_no;
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
	 * Returns the doctor's gender
	 * 
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Sets the doctor's gender
	 * 
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Returns the doctor's date of birth
	 * 
	 * @return the date_of_birth
	 */
	public String getDate_of_birth() {
		return date_of_birth;
	}

	/**
	 * Sets the doctor's date of birth
	 * 
	 * @param date_of_birth
	 *            the date_of_birth to set
	 */
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	/**
	 * Returns the doctor's phone number
	 * 
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the doctor's phone number
	 * 
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Returns the doctor's mobile number
	 * 
	 * @return the mobile_number
	 */
	public String getMobile_number() {
		return mobile_number;
	}

	/**
	 * Sets the doctor's mobile number
	 * 
	 * @param mobile_number
	 *            the mobile_number to set
	 */
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	/**
	 * Returns the doctor's home address
	 * 
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the doctor's home address
	 * 
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Returns the doctor's email address
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the doctor's email address
	 * 
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Returns the doctor's joined date
	 * 
	 * @return the date_of_joining
	 */
	public String getDate_of_joining() {
		return date_of_joining;
	}

	/**
	 * Sets the doctor's joined date
	 * 
	 * @param date_of_joining
	 *            the date_of_joining to set
	 */
	public void setDate_of_joining(String date_of_joining) {
		this.date_of_joining = date_of_joining;
	}

	/**
	 * Returns the doctor's resigned date
	 * 
	 * @return the date_of_leaving
	 */
	public String getDate_of_leaving() {
		return date_of_leaving;
	}

	/**
	 * Sets the doctor's resigned date
	 * 
	 * @param date_of_leaving
	 *            the date_of_leaving to set
	 */
	public void setDate_of_leaving(String date_of_leaving) {
		this.date_of_leaving = date_of_leaving;
	}

}