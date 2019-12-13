/**
 * 
 */
package com.csi.vidaplus.rcm.masterdata.document;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * DTO class for procedure price table
 * 
 * @version 1.0 18 Jan 2018
 * @author rajith pemabandu
 */

@Document(collection = "user_remarks")
public class UserRemarks extends MasterData{
	
	
	private String description;

	/**
	 * Default Constructor
	 */
	public UserRemarks() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param description
	 */
	public UserRemarks(String description) {
		super();
		this.description = description;
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
	
	

}
