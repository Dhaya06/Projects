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
 * DTO class for company profile table
 * 
 * @version 1.0 12 Jan 2018
 * @author Mohomad Nusky
 */
@Document(collection = "company_profile")
public class CompanyProfile extends MasterData {
	
	@NotNull(message = "Profile id must not be null")
	@NotEmpty(message = "Profile id cannot be empty")
	private String profile_id;
	
	@NotNull(message = "Company id must not be null")
	@NotEmpty(message = "Company id cannot be empty")
	private String company_id;
	
	@NotNull(message = "Profile Name must not be null")
	@NotEmpty(message = "Profile Name cannot be empty")
	private String profile_name;
	
	@NotNull(message = "Category must not be null")
	@NotEmpty(message = "Category cannot be empty")
	private String category;
	
	@NotNull(message = "Group Name must not be null")
	@NotEmpty(message = "Group Name cannot be empty")
	private String group_name;
	
	@NotNull(message = "Submission format must not be null")
	@NotEmpty(message = "Submission format cannot be empty")
	private String submission_format;
	
	@NotNull(message = "Submission template must not be null")
	@NotEmpty(message = "Submission template cannot be empty")
	private String submission_template;
	
	private String submission_time_period;
	
	private String resubmission_time_period;
	
	private Boolean is_cover_letter_needed;
	
	private Boolean is_printouts_needed;
	
	private Boolean is_portal_needed;
	
	private String submission_url;
	
	private String submission_date_of_month;
	
	private String payment_method;
	
	private String payment_time_period;
	

	/**
	 * Default constructor
	 */
	public CompanyProfile() {
	}


	/**
	 * @param profile_id
	 * @param company_id
	 * @param profile_name
	 * @param category
	 * @param group_name
	 * @param submission_format
	 * @param submission_template
	 * @param submission_time_period
	 * @param resubmission_time_period
	 * @param is_cover_letter_needed
	 * @param is_printouts_needed
	 * @param is_portal_needed
	 * @param submission_url
	 * @param submission_date_of_month
	 * @param payment_method
	 * @param payment_time_period
	 */
	public CompanyProfile(String profile_id, String company_id, String profile_name, String category, String group_name,
			String submission_format, String submission_template, String submission_time_period,
			String resubmission_time_period, Boolean is_cover_letter_needed, Boolean is_printouts_needed,
			Boolean is_portal_needed, String submission_url, String submission_date_of_month, String payment_method,
			String payment_time_period) {
		super();
		this.profile_id = profile_id;
		this.company_id = company_id;
		this.profile_name = profile_name;
		this.category = category;
		this.group_name = group_name;
		this.submission_format = submission_format;
		this.submission_template = submission_template;
		this.submission_time_period = submission_time_period;
		this.resubmission_time_period = resubmission_time_period;
		this.is_cover_letter_needed = is_cover_letter_needed;
		this.is_printouts_needed = is_printouts_needed;
		this.is_portal_needed = is_portal_needed;
		this.submission_url = submission_url;
		this.submission_date_of_month = submission_date_of_month;
		this.payment_method = payment_method;
		this.payment_time_period = payment_time_period;
	}




	/**
	 * returns the profile_id
	 *
	 * @return the profile_id
	 */
	public String getProfile_id() {
		return profile_id;
	}




	/**
	 * Sets the profile_id to profile_id
	 *
	 * @param profile_id the profile_id to set
	 */
	public void setProfile_id(String profile_id) {
		this.profile_id = profile_id;
	}

	/**
	 * Returns the company id
	 * 
	 * @return the company_id
	 */
	public String getCompany_id() {
		return company_id;
	}

	/**
	 * Sets the company id
	 * 
	 * @param company_id the company_id to set
	 */
	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}

	/**
	 * Returns the company submission format
	 * 
	 * @return the submission_format
	 */
	public String getSubmission_format() {
		return submission_format;
	}

	/**
	 * Sets the company submission format
	 * 
	 * @param submission_format the submission_format to set
	 */
	public void setSubmission_format(String submission_format) {
		this.submission_format = submission_format;
	}

	/**
	 * Returns the company submission template
	 * 
	 * @return the submission_template
	 */
	public String getSubmission_template() {
		return submission_template;
	}

	/**
	 * Sets the company submission template
	 * 
	 * @param submission_template the submission_template to set
	 */
	public void setSubmission_template(String submission_template) {
		this.submission_template = submission_template;
	}
	
	

	/**
	 * returns the submission_url
	 *
	 * @return the submission_url
	 */
	public String getSubmission_url() {
		return submission_url;
	}



	/**
	 * Sets the submission_url to submission_url
	 *
	 * @param submission_url the submission_url to set
	 */
	public void setSubmission_url(String submission_url) {
		this.submission_url = submission_url;
	}



	/**
	 * returns the submission_date_of_month
	 *
	 * @return the submission_date_of_month
	 */
	public String getSubmission_date_of_month() {
		return submission_date_of_month;
	}



	/**
	 * Sets the submission_date_of_month to submission_date_of_month
	 *
	 * @param submission_date_of_month the submission_date_of_month to set
	 */
	public void setSubmission_date_of_month(String submission_date_of_month) {
		this.submission_date_of_month = submission_date_of_month;
	}


	/**
	 * returns the group_name
	 *
	 * @return the group_name
	 */
	public String getGroup_name() {
		return group_name;
	}


	/**
	 * Sets the group_name to group_name
	 *
	 * @param group_name the group_name to set
	 */
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}


	/**
	 * returns the payment_method
	 *
	 * @return the payment_method
	 */
	public String getPayment_method() {
		return payment_method;
	}



	/**
	 * Sets the payment_method to payment_method
	 *
	 * @param payment_method the payment_method to set
	 */
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}



	/**
	 * returns the payment_time_period
	 *
	 * @return the payment_time_period
	 */
	public String getPayment_time_period() {
		return payment_time_period;
	}



	/**
	 * Sets the payment_time_period to payment_time_period
	 *
	 * @param payment_time_period the payment_time_period to set
	 */
	public void setPayment_time_period(String payment_time_period) {
		this.payment_time_period = payment_time_period;
	}



	/**
	 * Returns the company submission time period
	 * 
	 * @return the submission_time_period
	 */
	public String getSubmission_time_period() {
		return submission_time_period;
	}

	/**
	 * Sets the company submission time period
	 * 
	 * @param submission_time_period the submission_time_period to set
	 */
	public void setSubmission_time_period(String submission_time_period) {
		this.submission_time_period = submission_time_period;
	}

	/**
	 * Returns the company resubmission time period
	 * 
	 * @return the resubmission_time_period
	 */
	public String getResubmission_time_period() {
		return resubmission_time_period;
	}

	/**
	 * Sets the company resubmission time period
	 * 
	 * @param resubmission_time_period the resubmission_time_period to set
	 */
	public void setResubmission_time_period(String resubmission_time_period) {
		this.resubmission_time_period = resubmission_time_period;
	}

	/**
	 * Returns whether the cover letter is needed by the company
	 * 
	 * @return the is_cover_letter_needed
	 */
	public Boolean getIs_cover_letter_needed() {
		return is_cover_letter_needed;
	}

	/**
	 * Sets whether the cover letter is needed by the company
	 * 
	 * @param is_cover_letter_needed the is_cover_letter_needed to set
	 */
	public void setIs_cover_letter_needed(Boolean is_cover_letter_needed) {
		this.is_cover_letter_needed = is_cover_letter_needed;
	}

	/**
	 * Returns whether printouts are needed by the company
	 * 
	 * @return the is_printouts_needed
	 */
	public Boolean getIs_printouts_needed() {
		return is_printouts_needed;
	}

	/**
	 * Sets whether printouts are needed by the company
	 * 
	 * @param is_printouts_needed the is_printouts_needed to set
	 */
	public void setIs_printouts_needed(Boolean is_printouts_needed) {
		this.is_printouts_needed = is_printouts_needed;
	}



	/**
	 * returns the profile_name
	 *
	 * @return the profile_name
	 */
	public String getProfile_name() {
		return profile_name;
	}



	/**
	 * Sets the profile_name to profile_name
	 *
	 * @param profile_name the profile_name to set
	 */
	public void setProfile_name(String profile_name) {
		this.profile_name = profile_name;
	}



	/**
	 * returns the category
	 *
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}



	/**
	 * Sets the category to category
	 *
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}


	/**
	 * returns the is_portal_needed
	 *
	 * @return the is_portal_needed
	 */
	public Boolean getIs_portal_needed() {
		return is_portal_needed;
	}


	/**
	 * Sets the is_portal_needed to is_portal_needed
	 *
	 * @param is_portal_needed the is_portal_needed to set
	 */
	public void setIs_portal_needed(Boolean is_portal_needed) {
		this.is_portal_needed = is_portal_needed;
	}
	
}