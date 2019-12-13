/**
 * 
 */
package com.csi.vidaplus.rcm.masterdata.document;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * DTO class for procedure price table
 * 
 * @version 1.0 18 Jan 2018
 * @author rajith pemabandu
 */

@Document(collection = "procedure_price")
public class ProcedurePrice extends MasterData{
	
	@NotNull(message = "Company group Id must not be null")
	@NotEmpty(message = "Company group Id cannot be empty")
	private String company_group_id;
	
	@NotNull(message = "Procedure Id must not be null")
	@NotEmpty(message = "Procedure Id cannot be empty")
	private String procedure_id;
	
	@NotNull(message = "Price not be null")
	private Double price;
	
	private Double published_price;
	private Double gross_price;
	private Double special_price;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date effective_date;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date end_date;
	
	private Boolean is_discount_allowed;
	
	/**
	 * Default constructor
	 */
	public ProcedurePrice() {

	}

	/**
	 * Parameterized constructor
	 * 
	 * @param company_group_id
	 * @param procedure_id
	 * @param price
	 * @param published_price
	 * @param gross_price
	 * @param special_price
	 * @param effective_date
	 * @param end_date
	 * @param is_active
	 * @param is_discount_allowed
	 */
	public ProcedurePrice(String company_group_id, String procedure_id, Double price, Double published_price,
			Double gross_price, Double special_price, Date effective_date, Date end_date, Boolean is_active,
			Boolean is_discount_allowed) {
		super();
		this.company_group_id = company_group_id;
		this.procedure_id = procedure_id;
		this.price = price;
		this.published_price = published_price;
		this.gross_price = gross_price;
		this.special_price = special_price;
		this.effective_date = effective_date;
		this.end_date = end_date;
		this.is_discount_allowed = is_discount_allowed;
	}

	/**
	 * returns the company_group_id
	 *
	 * @return the company_group_id
	 */
	public String getCompany_group_id() {
		return company_group_id;
	}

	/**
	 * Sets the company_group_id to company_group_id
	 *
	 * @param company_group_id the company_group_id to set
	 */
	public void setCompany_group_id(String company_group_id) {
		this.company_group_id = company_group_id;
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
	 * returns the price
	 *
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * Sets the price to price
	 *
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * returns the published_price
	 *
	 * @return the published_price
	 */
	public Double getPublished_price() {
		return published_price;
	}

	/**
	 * Sets the published_price to published_price
	 *
	 * @param published_price the published_price to set
	 */
	public void setPublished_price(Double published_price) {
		this.published_price = published_price;
	}

	/**
	 * returns the gross_price
	 *
	 * @return the gross_price
	 */
	public Double getGross_price() {
		return gross_price;
	}

	/**
	 * Sets the gross_price to gross_price
	 *
	 * @param gross_price the gross_price to set
	 */
	public void setGross_price(Double gross_price) {
		this.gross_price = gross_price;
	}

	/**
	 * returns the special_price
	 *
	 * @return the special_price
	 */
	public Double getSpecial_price() {
		return special_price;
	}

	/**
	 * Sets the special_price to special_price
	 *
	 * @param special_price the special_price to set
	 */
	public void setSpecial_price(Double special_price) {
		this.special_price = special_price;
	}

	/**
	 * returns the effective_date
	 *
	 * @return the effective_date
	 */
	public Date getEffective_date() {
		return effective_date;
	}

	/**
	 * Sets the effective_date to effective_date
	 *
	 * @param effective_date the effective_date to set
	 */
	public void setEffective_date(Date effective_date) {
		this.effective_date = effective_date;
	}

	/**
	 * returns the end_date
	 *
	 * @return the end_date
	 */
	public Date getEnd_date() {
		return end_date;
	}

	/**
	 * Sets the end_date to end_date
	 *
	 * @param end_date the end_date to set
	 */
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	/**
	 * returns the is_discount_allowed
	 *
	 * @return the is_discount_allowed
	 */
	public Boolean getIs_discount_allowed() {
		return is_discount_allowed;
	}

	/**
	 * Sets the is_discount_allowed to is_discount_allowed
	 *
	 * @param is_discount_allowed the is_discount_allowed to set
	 */
	public void setIs_discount_allowed(Boolean is_discount_allowed) {
		this.is_discount_allowed = is_discount_allowed;
	}
	
	

	
	
}
