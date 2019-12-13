/**
 * 
 */
package com.csi.vidaplus.rcm.masterdata.document;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * DTO class for Payment Mode table
 * 
 * @version 1.0 18 Jan 2018
 * @author rajith pemabandu
 *
 */
@Document(collection = "payment_mode")
public class PaymentMode extends MasterData{
	
	@NotNull(message = "Payment Mode id must not be null")
	@NotEmpty(message = "Payment Mode id cannot be empty")
	private String payment_mode_id;
	
	@NotNull(message = "Payment Mode must not be null")
	@NotEmpty(message = "Payment Mode cannot be empty")
	private String payment_mode;
	
	@NotNull(message = "Payment Mode description must not be null")
	@NotEmpty(message = "Payment Mode description cannot be empty")
	private String description;
	
	@NotNull(message = "Payment Mode type must not be null")
	@NotEmpty(message = "Payment Mode type cannot be empty")
	private String payment_type;
	
	private Boolean is_transferable;
	
	private Boolean is_card_payment;
	
	private Boolean is_used_4_refund;
	
	private Boolean is_credit_auth_required;
	
	private Boolean is_used_in_pharmacy;
	
	private Boolean is_allowed_to_refund;
	
	private String refund_limit;
	
	private String commission_percentage;
	
	private String doctor_share;
	
	private String company_share;
	
	private String maximum_limit;
	
	private String ora_map_code;
	
	private String use_in_transaction;
	
	private String is_business_promotion;
	
	private String cash_patient_maximum_promotion_percentage;
	
	private String company_patient_maximum_promotion_percentage;


	/**
	 * Default constructor
	 * 
	 */
	public PaymentMode() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	

	/**
	 * Parameterized constructor
	 * 
<<<<<<< HEAD
	 * @param payment_mode_id
=======
	 * @param payment_mode
>>>>>>> 4446507ced91bbe44d11120c6e2f0ce2bda3ef86
	 * @param description
	 * @param payment_type
	 * @param is_transferable
	 * @param is_card_payment
	 * @param is_used_4_refund
	 * @param is_credit_auth_required
	 * @param is_used_in_pharmacy
	 * @param is_allowed_to_refund
	 * @param refund_limit
	 * @param commission_percentage
	 * @param doctor_share
	 * @param company_share
	 * @param is_active
	 * @param maximum_limit
	 * @param ora_map_code
	 * @param use_in_transaction
	 * @param is_business_promotion
	 * @param cash_patient_maximum_promotion_percentage
	 * @param company_patient_maximum_promotion_percentage
	 */
	public PaymentMode(String payment_mode_id,String description, String payment_type, Boolean is_transferable, Boolean is_card_payment,
			Boolean is_used_4_refund, Boolean is_credit_auth_required, Boolean is_used_in_pharmacy,
			Boolean is_allowed_to_refund, String refund_limit, String commission_percentage, String doctor_share, String company_share,
			Boolean is_active, String maximum_limit, String ora_map_code, String use_in_transaction,
			String is_business_promotion, String cash_patient_maximum_promotion_percentage,
			String company_patient_maximum_promotion_percentage) {
		super();
		this.payment_mode_id =payment_mode_id;
		this.description = description;
		this.payment_type = payment_type;
		this.is_transferable = is_transferable;
		this.is_card_payment = is_card_payment;
		this.is_used_4_refund = is_used_4_refund;
		this.is_credit_auth_required = is_credit_auth_required;
		this.is_used_in_pharmacy = is_used_in_pharmacy;
		this.is_allowed_to_refund = is_allowed_to_refund;
		this.refund_limit = refund_limit;
		this.commission_percentage = commission_percentage;
		this.doctor_share = doctor_share;
		this.company_share = company_share;
		this.maximum_limit = maximum_limit;
		this.ora_map_code = ora_map_code;
		this.use_in_transaction = use_in_transaction;
		this.is_business_promotion = is_business_promotion;
		this.cash_patient_maximum_promotion_percentage = cash_patient_maximum_promotion_percentage;
		this.company_patient_maximum_promotion_percentage = company_patient_maximum_promotion_percentage;
	}


	/**
	 * returns the payment_mode
	 *
	 * @return the payment_mode
	 */
	public String getPayment_mode() {
		return payment_mode;
	}







	/**
	 * returns the payment_mode_id
	 *
	 * @return the payment_mode_id
	 */
	public String getPayment_mode_id() {
		return payment_mode_id;
	}





	/**
	 * Sets the payment_mode_id to payment_mode_id
	 *
	 * @param payment_mode_id the payment_mode_id to set
	 */
	public void setPayment_mode_id(String payment_mode_id) {
		this.payment_mode_id = payment_mode_id;
	}





	/**
	 * returns the description
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}



	/**
	 * Sets the description to description
	 *
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}



	/**
	 * returns the payment_type
	 *
	 * @return the payment_type
	 */
	public String getPayment_type() {
		return payment_type;
	}



	/**
	 * Sets the payment_type to payment_type
	 *
	 * @param payment_type the payment_type to set
	 */
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}



	/**
	 * returns the is_transferable
	 *
	 * @return the is_transferable
	 */
	public Boolean getIs_transferable() {
		return is_transferable;
	}



	/**
	 * Sets the is_transferable to is_transferable
	 *
	 * @param is_transferable the is_transferable to set
	 */
	public void setIs_transferable(Boolean is_transferable) {
		this.is_transferable = is_transferable;
	}



	/**
	 * returns the is_card_payment
	 *
	 * @return the is_card_payment
	 */
	public Boolean getIs_card_payment() {
		return is_card_payment;
	}



	/**
	 * Sets the is_card_payment to is_card_payment
	 *
	 * @param is_card_payment the is_card_payment to set
	 */
	public void setIs_card_payment(Boolean is_card_payment) {
		this.is_card_payment = is_card_payment;
	}



	/**
	 * returns the is_used_4_refund
	 *
	 * @return the is_used_4_refund
	 */
	public Boolean getIs_used_4_refund() {
		return is_used_4_refund;
	}



	/**
	 * Sets the is_used_4_refund to is_used_4_refund
	 *
	 * @param is_used_4_refund the is_used_4_refund to set
	 */
	public void setIs_used_4_refund(Boolean is_used_4_refund) {
		this.is_used_4_refund = is_used_4_refund;
	}



	/**
	 * returns the is_credit_auth_required
	 *
	 * @return the is_credit_auth_required
	 */
	public Boolean getIs_credit_auth_required() {
		return is_credit_auth_required;
	}



	/**
	 * Sets the is_credit_auth_required to is_credit_auth_required
	 *
	 * @param is_credit_auth_required the is_credit_auth_required to set
	 */
	public void setIs_credit_auth_required(Boolean is_credit_auth_required) {
		this.is_credit_auth_required = is_credit_auth_required;
	}



	/**
	 * returns the is_used_in_pharmacy
	 *
	 * @return the is_used_in_pharmacy
	 */
	public Boolean getIs_used_in_pharmacy() {
		return is_used_in_pharmacy;
	}



	/**
	 * Sets the is_used_in_pharmacy to is_used_in_pharmacy
	 *
	 * @param is_used_in_pharmacy the is_used_in_pharmacy to set
	 */
	public void setIs_used_in_pharmacy(Boolean is_used_in_pharmacy) {
		this.is_used_in_pharmacy = is_used_in_pharmacy;
	}



	/**
	 * returns the is_allowed_to_refund
	 *
	 * @return the is_allowed_to_refund
	 */
	public Boolean getIs_allowed_to_refund() {
		return is_allowed_to_refund;
	}



	/**
	 * Sets the is_allowed_to_refund to is_allowed_to_refund
	 *
	 * @param is_allowed_to_refund the is_allowed_to_refund to set
	 */
	public void setIs_allowed_to_refund(Boolean is_allowed_to_refund) {
		this.is_allowed_to_refund = is_allowed_to_refund;
	}
	

	/**
	 * returns the refund_limit
	 *
	 * @return the refund_limit
	 */
	public String getRefund_limit() {
		return refund_limit;
	}





	/**
	 * Sets the refund_limit to refund_limit
	 *
	 * @param refund_limit the refund_limit to set
	 */
	public void setRefund_limit(String refund_limit) {
		this.refund_limit = refund_limit;
	}





	/**
	 * returns the commission_percentage
	 *
	 * @return the commission_percentage
	 */
	public String getCommission_percentage() {
		return commission_percentage;
	}



	/**
	 * Sets the commission_percentage to commission_percentage
	 *
	 * @param commission_percentage the commission_percentage to set
	 */
	public void setCommission_percentage(String commission_percentage) {
		this.commission_percentage = commission_percentage;
	}



	/**
	 * returns the doctor_share
	 *
	 * @return the doctor_share
	 */
	public String getDoctor_share() {
		return doctor_share;
	}



	/**
	 * Sets the doctor_share to doctor_share
	 *
	 * @param doctor_share the doctor_share to set
	 */
	public void setDoctor_share(String doctor_share) {
		this.doctor_share = doctor_share;
	}



	/**
	 * returns the company_share
	 *
	 * @return the company_share
	 */
	public String getCompany_share() {
		return company_share;
	}



	/**
	 * Sets the company_share to company_share
	 *
	 * @param company_share the company_share to set
	 */
	public void setCompany_share(String company_share) {
		this.company_share = company_share;
	}

	/**
	 * returns the maximum_limit
	 *
	 * @return the maximum_limit
	 */
	public String getMaximum_limit() {
		return maximum_limit;
	}





	/**
	 * Sets the maximum_limit to maximum_limit
	 *
	 * @param maximum_limit the maximum_limit to set
	 */
	public void setMaximum_limit(String maximum_limit) {
		this.maximum_limit = maximum_limit;
	}





	/**
	 * returns the ora_map_code
	 *
	 * @return the ora_map_code
	 */
	public String getOra_map_code() {
		return ora_map_code;
	}





	/**
	 * Sets the ora_map_code to ora_map_code
	 *
	 * @param ora_map_code the ora_map_code to set
	 */
	public void setOra_map_code(String ora_map_code) {
		this.ora_map_code = ora_map_code;
	}





	/**
	 * returns the use_in_transaction
	 *
	 * @return the use_in_transaction
	 */
	public String getUse_in_transaction() {
		return use_in_transaction;
	}





	/**
	 * Sets the use_in_transaction to use_in_transaction
	 *
	 * @param use_in_transaction the use_in_transaction to set
	 */
	public void setUse_in_transaction(String use_in_transaction) {
		this.use_in_transaction = use_in_transaction;
	}





	/**
	 * returns the is_business_promotion
	 *
	 * @return the is_business_promotion
	 */
	public String getIs_business_promotion() {
		return is_business_promotion;
	}





	/**
	 * Sets the is_business_promotion to is_business_promotion
	 *
	 * @param is_business_promotion the is_business_promotion to set
	 */
	public void setIs_business_promotion(String is_business_promotion) {
		this.is_business_promotion = is_business_promotion;
	}





	/**
	 * returns the cash_patient_maximum_promotion_percentage
	 *
	 * @return the cash_patient_maximum_promotion_percentage
	 */
	public String getCash_patient_maximum_promotion_percentage() {
		return cash_patient_maximum_promotion_percentage;
	}





	/**
	 * Sets the cash_patient_maximum_promotion_percentage to cash_patient_maximum_promotion_percentage
	 *
	 * @param cash_patient_maximum_promotion_percentage the cash_patient_maximum_promotion_percentage to set
	 */
	public void setCash_patient_maximum_promotion_percentage(String cash_patient_maximum_promotion_percentage) {
		this.cash_patient_maximum_promotion_percentage = cash_patient_maximum_promotion_percentage;
	}





	/**
	 * returns the company_patient_maximum_promotion_percentage
	 *
	 * @return the company_patient_maximum_promotion_percentage
	 */
	public String getCompany_patient_maximum_promotion_percentage() {
		return company_patient_maximum_promotion_percentage;
	}


	/**
	 * Sets the company_patient_maximum_promotion_percentage to company_patient_maximum_promotion_percentage
	 *
	 * @param company_patient_maximum_promotion_percentage the company_patient_maximum_promotion_percentage to set
	 */
	public void setCompany_patient_maximum_promotion_percentage(String company_patient_maximum_promotion_percentage) {
		this.company_patient_maximum_promotion_percentage = company_patient_maximum_promotion_percentage;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PaymentMode [payment_mode_id=" + payment_mode_id + ", description=" + description + ", payment_type="
				+ payment_type + ", is_transferable=" + is_transferable + ", is_card_payment=" + is_card_payment
				+ ", is_used_4_refund=" + is_used_4_refund + ", is_credit_auth_required=" + is_credit_auth_required
				+ ", is_used_in_pharmacy=" + is_used_in_pharmacy + ", is_allowed_to_refund=" + is_allowed_to_refund
				+ ", refund_limit=" + refund_limit + ", commission_percentage=" + commission_percentage
				+ ", doctor_share=" + doctor_share + ", company_share=" + company_share
				+ ", maximum_limit=" + maximum_limit + ", ora_map_code=" + ora_map_code + ", use_in_transaction="
				+ use_in_transaction + ", is_business_promotion=" + is_business_promotion
				+ ", cash_patient_maximum_promotion_percentage=" + cash_patient_maximum_promotion_percentage
				+ ", company_patient_maximum_promotion_percentage=" + company_patient_maximum_promotion_percentage
				+ "]";
	}
	
}
