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

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * DTO class for icd_am_disease table
 * 
 * @version 1.0 12 Jan 2018
 * @author Mohomad Nusky
 */
@Document(collection = "icd_australian_modification_disease")
public class ICDAustralianModificationDisease extends DataDictionary {

	@NotNull(message = "Ascii description must not be null")
	@NotEmpty(message = "Ascii description cannot be empty")
	private String ascii_description;
	
	@NotNull(message = "Ascii short must not be null")
	@NotEmpty(message = "Ascii short cannot be empty")
	private String ascii_short;
	
	private String chapter;
	private String code_length;
	private String dagger;
	private String asterisk;
	private String valid;
	private String aust_code;
	private String effective_date;
	private String inactive;
	private String reactivate;
	private String sex;
	private String s_type;
	private String age_l;
	private String age_h;
	private String a_type;
	private String r_diag;
	private String concept_ch;
	private String is_active;
	private String code_type;
	private String code_unformatted;
	private String is_infectious_disease;
	private String type_of_infection;
	private String sick_leave_period;
	
	/**
	 * Default constructor
	 */
	public ICDAustralianModificationDisease() {
	}

	/**
	 * @param ascii_description
	 * @param ascii_short
	 * @param chapter
	 * @param code_length
	 * @param dagger
	 * @param asterisk
	 * @param valid
	 * @param aust_code
	 * @param effective_date
	 * @param inactive
	 * @param reactivate
	 * @param sex
	 * @param s_type
	 * @param age_l
	 * @param age_h
	 * @param a_type
	 * @param r_diag
	 * @param concept_ch
	 * @param is_active
	 * @param code_type
	 * @param code_unformatted
	 * @param is_infectious_disease
	 * @param type_of_infection
	 * @param sick_leave_period
	 */
	public ICDAustralianModificationDisease(String ascii_description, String ascii_short, String chapter,
			String code_length, String dagger, String asterisk, String valid, String aust_code, String effective_date,
			String inactive, String reactivate, String sex, String s_type, String age_l, String age_h, String a_type,
			String r_diag, String concept_ch, String is_active, String code_type, String code_unformatted,
			String is_infectious_disease, String type_of_infection, String sick_leave_period) {
		this.ascii_description = ascii_description;
		this.ascii_short = ascii_short;
		this.chapter = chapter;
		this.code_length = code_length;
		this.dagger = dagger;
		this.asterisk = asterisk;
		this.valid = valid;
		this.aust_code = aust_code;
		this.effective_date = effective_date;
		this.inactive = inactive;
		this.reactivate = reactivate;
		this.sex = sex;
		this.s_type = s_type;
		this.age_l = age_l;
		this.age_h = age_h;
		this.a_type = a_type;
		this.r_diag = r_diag;
		this.concept_ch = concept_ch;
		this.is_active = is_active;
		this.code_type = code_type;
		this.code_unformatted = code_unformatted;
		this.is_infectious_disease = is_infectious_disease;
		this.type_of_infection = type_of_infection;
		this.sick_leave_period = sick_leave_period;
	}

	/**
	 * @return the ascii_description
	 */
	public String getAscii_description() {
		return ascii_description;
	}

	/**
	 * @param ascii_description the ascii_description to set
	 */
	public void setAscii_description(String ascii_description) {
		this.ascii_description = ascii_description;
	}

	/**
	 * @return the ascii_short
	 */
	public String getAscii_short() {
		return ascii_short;
	}

	/**
	 * @param ascii_short the ascii_short to set
	 */
	public void setAscii_short(String ascii_short) {
		this.ascii_short = ascii_short;
	}

	/**
	 * @return the chapter
	 */
	public String getChapter() {
		return chapter;
	}

	/**
	 * @param chapter the chapter to set
	 */
	public void setChapter(String chapter) {
		this.chapter = chapter;
	}

	/**
	 * @return the code_length
	 */
	public String getCode_length() {
		return code_length;
	}

	/**
	 * @param code_length the code_length to set
	 */
	public void setCode_length(String code_length) {
		this.code_length = code_length;
	}

	/**
	 * @return the dagger
	 */
	public String getDagger() {
		return dagger;
	}

	/**
	 * @param dagger the dagger to set
	 */
	public void setDagger(String dagger) {
		this.dagger = dagger;
	}

	/**
	 * @return the asterisk
	 */
	public String getAsterisk() {
		return asterisk;
	}

	/**
	 * @param asterisk the asterisk to set
	 */
	public void setAsterisk(String asterisk) {
		this.asterisk = asterisk;
	}

	/**
	 * @return the valid
	 */
	public String getValid() {
		return valid;
	}

	/**
	 * @param valid the valid to set
	 */
	public void setValid(String valid) {
		this.valid = valid;
	}

	/**
	 * @return the aust_code
	 */
	public String getAust_code() {
		return aust_code;
	}

	/**
	 * @param aust_code the aust_code to set
	 */
	public void setAust_code(String aust_code) {
		this.aust_code = aust_code;
	}

	/**
	 * @return the effective_date
	 */
	public String getEffective_date() {
		return effective_date;
	}

	/**
	 * @param effective_date the effective_date to set
	 */
	public void setEffective_date(String effective_date) {
		this.effective_date = effective_date;
	}

	/**
	 * @return the inactive
	 */
	public String getInactive() {
		return inactive;
	}

	/**
	 * @param inactive the inactive to set
	 */
	public void setInactive(String inactive) {
		this.inactive = inactive;
	}

	/**
	 * @return the reactivate
	 */
	public String getReactivate() {
		return reactivate;
	}

	/**
	 * @param reactivate the reactivate to set
	 */
	public void setReactivate(String reactivate) {
		this.reactivate = reactivate;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the s_type
	 */
	public String getS_type() {
		return s_type;
	}

	/**
	 * @param s_type the s_type to set
	 */
	public void setS_type(String s_type) {
		this.s_type = s_type;
	}

	/**
	 * @return the age_l
	 */
	public String getAge_l() {
		return age_l;
	}

	/**
	 * @param age_l the age_l to set
	 */
	public void setAge_l(String age_l) {
		this.age_l = age_l;
	}

	/**
	 * @return the age_h
	 */
	public String getAge_h() {
		return age_h;
	}

	/**
	 * @param age_h the age_h to set
	 */
	public void setAge_h(String age_h) {
		this.age_h = age_h;
	}

	/**
	 * @return the a_type
	 */
	public String getA_type() {
		return a_type;
	}

	/**
	 * @param a_type the a_type to set
	 */
	public void setA_type(String a_type) {
		this.a_type = a_type;
	}

	/**
	 * @return the r_diag
	 */
	public String getR_diag() {
		return r_diag;
	}

	/**
	 * @param r_diag the r_diag to set
	 */
	public void setR_diag(String r_diag) {
		this.r_diag = r_diag;
	}

	/**
	 * @return the concept_ch
	 */
	public String getConcept_ch() {
		return concept_ch;
	}

	/**
	 * @param concept_ch the concept_ch to set
	 */
	public void setConcept_ch(String concept_ch) {
		this.concept_ch = concept_ch;
	}

	/**
	 * @return the is_active
	 */
	public String getIs_active() {
		return is_active;
	}

	/**
	 * @param is_active the is_active to set
	 */
	public void setIs_active(String is_active) {
		this.is_active = is_active;
	}

	/**
	 * @return the code_type
	 */
	public String getCode_type() {
		return code_type;
	}

	/**
	 * @param code_type the code_type to set
	 */
	public void setCode_type(String code_type) {
		this.code_type = code_type;
	}

	/**
	 * @return the code_unformatted
	 */
	public String getCode_unformatted() {
		return code_unformatted;
	}

	/**
	 * @param code_unformatted the code_unformatted to set
	 */
	public void setCode_unformatted(String code_unformatted) {
		this.code_unformatted = code_unformatted;
	}

	/**
	 * @return the is_infectious_disease
	 */
	public String getIs_infectious_disease() {
		return is_infectious_disease;
	}

	/**
	 * @param is_infectious_disease the is_infectious_disease to set
	 */
	public void setIs_infectious_disease(String is_infectious_disease) {
		this.is_infectious_disease = is_infectious_disease;
	}

	/**
	 * @return the type_of_infection
	 */
	public String getType_of_infection() {
		return type_of_infection;
	}

	/**
	 * @param type_of_infection the type_of_infection to set
	 */
	public void setType_of_infection(String type_of_infection) {
		this.type_of_infection = type_of_infection;
	}

	/**
	 * @return the sick_leave_period
	 */
	public String getSick_leave_period() {
		return sick_leave_period;
	}

	/**
	 * @param sick_leave_period the sick_leave_period to set
	 */
	public void setSick_leave_period(String sick_leave_period) {
		this.sick_leave_period = sick_leave_period;
	}

}