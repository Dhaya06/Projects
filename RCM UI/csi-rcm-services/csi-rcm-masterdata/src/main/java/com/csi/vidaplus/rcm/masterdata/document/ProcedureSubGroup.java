/**
 * 
 */
package com.csi.vidaplus.rcm.masterdata.document;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * DTO class for procedure sub group table
 * 
 * @version 1.0 18 Jan 2018
 * @author rajith pemabandu
 *
 */

@Document(collection = "procedure_sub_group")
public class ProcedureSubGroup extends MasterData {
	
	@NotNull(message = "Procedure sub group id must not be null")
	private String sub_group_id;
	
	@NotNull(message = "Procedure sub group description must not be null")
	@NotEmpty(message = "Procedure sub group description cannot be empty")
	private String sub_group_description;
	
	private Boolean is_special_discount_allowed;
	
	private String alias;

	/**
	 * Default constructor
	 */
	public ProcedureSubGroup() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 *  Parameterized constructor
	 * 
	 * @param sub_group_id
	 * @param sub_group_description
	 * @param is_active
	 * @param is_special_discount_allowed
	 * @param alias
	 */
	public ProcedureSubGroup(String sub_group_id, String sub_group_description, Boolean is_active,
			Boolean is_special_discount_allowed, String alias) {
		super();
		this.sub_group_id = sub_group_id;
		this.sub_group_description = sub_group_description;
		this.is_special_discount_allowed = is_special_discount_allowed;
		this.alias = alias;
	}
	

	/**
	 * returns the sub_group_id
	 *
	 * @return the sub_group_id
	 */
	public String getSub_group_id() {
		return sub_group_id;
	}

	/**
	 * Sets the sub_group_id to sub_group_id
	 *
	 * @param sub_group_id the sub_group_id to set
	 */
	public void setSub_group_id(String sub_group_id) {
		this.sub_group_id = sub_group_id;
	}

	/**
	 * returns the sub_group_description
	 *
	 * @return the sub_group_description
	 */
	public String getSub_group_description() {
		return sub_group_description;
	}

	/**
	 * Sets the sub_group_description to sub_group_description
	 *
	 * @param sub_group_description the sub_group_description to set
	 */
	public void setSub_group_description(String sub_group_description) {
		this.sub_group_description = sub_group_description;
	}

	/**
	 * returns the is_special_discount_allowed
	 *
	 * @return the is_special_discount_allowed
	 */
	public Boolean getIs_special_discount_allowed() {
		return is_special_discount_allowed;
	}

	/**
	 * Sets the is_special_discount_allowed to is_special_discount_allowed
	 *
	 * @param is_special_discount_allowed the is_special_discount_allowed to set
	 */
	public void setIs_special_discount_allowed(Boolean is_special_discount_allowed) {
		this.is_special_discount_allowed = is_special_discount_allowed;
	}

	/**
	 * returns the alias
	 *
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * Sets the alias to alias
	 *
	 * @param alias the alias to set
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "ProcedureSubGroup{" +
				"sub_group_id='" + sub_group_id + '\'' +
				", sub_group_description='" + sub_group_description + '\'' +
				", is_special_discount_allowed=" + is_special_discount_allowed +
				", alias='" + alias + '\'' +
				'}';
	}
}
