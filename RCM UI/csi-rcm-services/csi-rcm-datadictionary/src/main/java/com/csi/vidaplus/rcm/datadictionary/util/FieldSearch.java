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
package com.csi.vidaplus.rcm.datadictionary.util;

/**
 * Class to store the field name, field value and the search criteria
 * 
 * @version 1.0 12 Jan 2018
 * @author Firstname Lastname
 */
public class FieldSearch {
	
	private String fieldName;
	private String fieldValue;
	private int criteria;
	
	/**
	 * Returns the field name
	 * 
	 * @return the fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}
	
	/**
	 * Sets the field name
	 * 
	 * @param fieldName the fieldName to set
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
	/**
	 * Returns the field value
	 * 
	 * @return the fieldValue
	 */
	public String getFieldValue() {
		return fieldValue;
	}
	
	/**
	 * Sets the field value
	 * 
	 * @param fieldValue the fieldValue to set
	 */
	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
	
	/**
	 * Returns the search criteria
	 * 
	 * @return the criteria
	 */
	public int getCriteria() {
		return criteria;
	}
	
	/**
	 * Sets the search criteria
	 * 
	 * @param criteria the criteria to set
	 */
	public void setCriteria(int criteria) {
		this.criteria = criteria;
	}
}
