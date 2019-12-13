package com.csi.vidaplus.rcm.masterdata.document;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * DTO class for group rules
 * 
 * @version 1.0 12 Jan 2018
 * @author Ahsan Shamsudeen
 */
@Document(collection = "group_rules")
public class GroupRules extends MasterData {

	@NotNull(message = "Group Id must not be null")
	@NotEmpty(message = "Group Id cannot be empty")
	private String group_id;
	private String sub_category_id;
	private String proc_class_type;
	private String proc_class_id;
	private String is_covered;
	private String discount_type;
	private String discount_value;
	private String share_type;
	private String group_share;
	private String patient_share;
	private String is_patient_share_on_gross;
	private String is_approval_required;
	private String approval_limit;
	private String rule_type;

	/**
	 * Default constructor
	 */
	public GroupRules() {
	}

	/**
	 * @param group_id
	 * @param sub_category_id
	 * @param proc_class_type
	 * @param proc_class_id
	 * @param is_covered
	 * @param discount_type
	 * @param discount_value
	 * @param share_type
	 * @param group_share
	 * @param patient_share
	 * @param is_patient_share_on_gross
	 * @param is_approval_required
	 * @param approval_limit
	 * @param is_active
	 * @param rule_type
	 */
	public GroupRules(String group_id,String sub_category_id, String proc_class_type,
			String proc_class_id, String is_covered, String discount_type, String discount_value, String share_type,
			String group_share, String patient_share, String is_patient_share_on_gross, String is_approval_required,
			String approval_limit, String rule_type) {
		this.group_id = group_id;
		this.sub_category_id = sub_category_id;
		this.proc_class_type = proc_class_type;
		this.proc_class_id = proc_class_id;
		this.is_covered = is_covered;
		this.discount_type = discount_type;
		this.discount_value = discount_value;
		this.share_type = share_type;
		this.group_share = group_share;
		this.patient_share = patient_share;
		this.is_patient_share_on_gross = is_patient_share_on_gross;
		this.is_approval_required = is_approval_required;
		this.approval_limit = approval_limit;
		this.rule_type = rule_type;
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
	 * @return the sub_category_id
	 */
	public String getSub_category_id() {
		return sub_category_id;
	}

	/**
	 * @param sub_category_id the sub_category_id to set
	 */
	public void setSub_category_id(String sub_category_id) {
		this.sub_category_id = sub_category_id;
	}

	/**
	 * @return the proc_class_type
	 */
	public String getProc_class_type() {
		return proc_class_type;
	}

	/**
	 * @param proc_class_type the proc_class_type to set
	 */
	public void setProc_class_type(String proc_class_type) {
		this.proc_class_type = proc_class_type;
	}

	/**
	 * @return the proc_class_id
	 */
	public String getProc_class_id() {
		return proc_class_id;
	}

	/**
	 * @param proc_class_id the proc_class_id to set
	 */
	public void setProc_class_id(String proc_class_id) {
		this.proc_class_id = proc_class_id;
	}

	/**
	 * @return the is_covered
	 */
	public String getIs_covered() {
		return is_covered;
	}

	/**
	 * @param is_covered the is_covered to set
	 */
	public void setIs_covered(String is_covered) {
		this.is_covered = is_covered;
	}

	/**
	 * @return the discount_type
	 */
	public String getDiscount_type() {
		return discount_type;
	}

	/**
	 * @param discount_type the discount_type to set
	 */
	public void setDiscount_type(String discount_type) {
		this.discount_type = discount_type;
	}

	/**
	 * @return the discount_value
	 */
	public String getDiscount_value() {
		return discount_value;
	}

	/**
	 * @param discount_value the discount_value to set
	 */
	public void setDiscount_value(String discount_value) {
		this.discount_value = discount_value;
	}

	/**
	 * @return the share_type
	 */
	public String getShare_type() {
		return share_type;
	}

	/**
	 * @param share_type the share_type to set
	 */
	public void setShare_type(String share_type) {
		this.share_type = share_type;
	}

	/**
	 * @return the group_share
	 */
	public String getGroup_share() {
		return group_share;
	}

	/**
	 * @param company_share the group_share to set
	 */
	public void setGroup_share(String company_share) {
		this.group_share = company_share;
	}

	/**
	 * @return the patient_share
	 */
	public String getPatient_share() {
		return patient_share;
	}

	/**
	 * @param patient_share the patient_share to set
	 */
	public void setPatient_share(String patient_share) {
		this.patient_share = patient_share;
	}

	/**
	 * @return the is_patient_share_on_gross
	 */
	public String getIs_patient_share_on_gross() {
		return is_patient_share_on_gross;
	}

	/**
	 * @param is_patient_share_on_gross the is_patient_share_on_gross to set
	 */
	public void setIs_patient_share_on_gross(String is_patient_share_on_gross) {
		this.is_patient_share_on_gross = is_patient_share_on_gross;
	}

	/**
	 * @return the is_approval_required
	 */
	public String getIs_approval_required() {
		return is_approval_required;
	}

	/**
	 * @param is_approval_required the is_approval_required to set
	 */
	public void setIs_approval_required(String is_approval_required) {
		this.is_approval_required = is_approval_required;
	}

	/**
	 * @return the approval_limit
	 */
	public String getApproval_limit() {
		return approval_limit;
	}

	/**
	 * @param approval_limit the approval_limit to set
	 */
	public void setApproval_limit(String approval_limit) {
		this.approval_limit = approval_limit;
	}

	

	/**
	 * @return the rule_type
	 */
	public String getRule_type() {
		return rule_type;
	}

	/**
	 * @param rule_type the rule_type to set
	 */
	public void setRule_type(String rule_type) {
		this.rule_type = rule_type;
	}

	

}