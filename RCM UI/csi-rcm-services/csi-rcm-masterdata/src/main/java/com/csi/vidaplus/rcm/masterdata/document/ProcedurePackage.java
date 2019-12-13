/**
 * 
 */
package com.csi.vidaplus.rcm.masterdata.document;


import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * DTO class for Procedure Package table
 * 
 * @version 1.0 18 Jan 2018
 * @author rajith pemabandu
 *
 */

@Document(collection = "procedure_package")
public class ProcedurePackage extends MasterData {

	@NotNull(message = "Procedure Id must not be null")
	@NotEmpty(message = "Procedure Id cannot be empty")
	private String procedure_id;
	
	@NotNull(message = "Child Procedure Id must not be null")
	@NotEmpty(message = "Child Procedure Id cannot be empty")
	private String child_procedure_id;
	
	private String line_item_no;
	
	private String actual_price;
	
	private String discounted_price;
	
	private String published_price;
	
	private String special_price;
	
	private Boolean is_allow_special_discount;
	
	/**
	 *  Default constructor
	 * 
	 */
	public ProcedurePackage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param procedure_id
	 * @param child_procedure_id
	 * @param line_item_no
	 * @param actual_price
	 * @param discounted_price
	 * @param published_price
	 * @param special_price
	 * @param is_allow_special_discount
	 * @param is_active
	 */
	public ProcedurePackage(String procedure_id, String child_procedure_id, String line_item_no,
			String actual_price, String discounted_price, String published_price, String special_price,
			Boolean is_allow_special_discount, Boolean is_active) {
		super();
		this.procedure_id = procedure_id;
		this.child_procedure_id = child_procedure_id;
		this.line_item_no = line_item_no;
		this.actual_price = actual_price;
		this.discounted_price = discounted_price;
		this.published_price = published_price;
		this.special_price = special_price;
		this.is_allow_special_discount = is_allow_special_discount;
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
	 * returns the child_procedure_id
	 *
	 * @return the child_procedure_id
	 */
	public String getChild_procedure_id() {
		return child_procedure_id;
	}

	/**
	 * Sets the child_procedure_id to child_procedure_id
	 *
	 * @param child_procedure_id the child_procedure_id to set
	 */
	public void setChild_procedure_id(String child_procedure_id) {
		this.child_procedure_id = child_procedure_id;
	}

	/**
	 * returns the line_item_no
	 *
	 * @return the line_item_no
	 */
	public String getLine_item_no() {
		return line_item_no;
	}

	/**
	 * Sets the line_item_no to line_item_no
	 *
	 * @param line_item_no the line_item_no to set
	 */
	public void setLine_item_no(String line_item_no) {
		this.line_item_no = line_item_no;
	}

	/**
	 * returns the actual_price
	 *
	 * @return the actual_price
	 */
	public String getActual_price() {
		return actual_price;
	}

	/**
	 * Sets the actual_price to actual_price
	 *
	 * @param actual_price the actual_price to set
	 */
	public void setActual_price(String actual_price) {
		this.actual_price = actual_price;
	}

	/**
	 * returns the discounted_price
	 *
	 * @return the discounted_price
	 */
	public String getDiscounted_price() {
		return discounted_price;
	}

	/**
	 * Sets the discounted_price to discounted_price
	 *
	 * @param discounted_price the discounted_price to set
	 */
	public void setDiscounted_price(String discounted_price) {
		this.discounted_price = discounted_price;
	}

	/**
	 * returns the published_price
	 *
	 * @return the published_price
	 */
	public String getPublished_price() {
		return published_price;
	}

	/**
	 * Sets the published_price to published_price
	 *
	 * @param published_price the published_price to set
	 */
	public void setPublished_price(String published_price) {
		this.published_price = published_price;
	}

	/**
	 * returns the special_price
	 *
	 * @return the special_price
	 */
	public String getSpecial_price() {
		return special_price;
	}

	/**
	 * Sets the special_price to special_price
	 *
	 * @param special_price the special_price to set
	 */
	public void setSpecial_price(String special_price) {
		this.special_price = special_price;
	}

	/**
	 * returns the is_allow_special_discount
	 *
	 * @return the is_allow_special_discount
	 */
	public Boolean getIs_allow_special_discount() {
		return is_allow_special_discount;
	}

	/**
	 * Sets the is_allow_special_discount to is_allow_special_discount
	 *
	 * @param is_allow_special_discount the is_allow_special_discount to set
	 */
	public void setIs_allow_special_discount(Boolean is_allow_special_discount) {
		this.is_allow_special_discount = is_allow_special_discount;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProcedurePackage [procedure_id=" + procedure_id + ", child_procedure_id=" + child_procedure_id
				+ ", line_item_no=" + line_item_no + ", actual_price=" + actual_price + ", discounted_price="
				+ discounted_price + ", published_price=" + published_price + ", special_price=" + special_price
				+ ", is_allow_special_discount=" + is_allow_special_discount + "]";
	}
	
	
}
