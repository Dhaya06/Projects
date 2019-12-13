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
package com.csi.vidaplus.rcm.masterdata.util;

/**
 * Enums for the filter criteria
 * 
 * <ul>
 * <li>Filter Criteria None = 0</li>
 * <li>Filter Criteria REGEX = 1</li>
 * <li>Filter Criteria Equal = 2</li>
 * <li>Filter Criteria GreaterThan = 3</li>
 * <li>Filter Criteria LessThan = 4</li>
 * <li>Filter Criteria GreaterThanOrEqual = 5</li>
 * <li>Filter Criteria LessThanOrEqual = 6</li>
 * <li>Filter Criteria NotEqual = 7</li>
 * <li>Sort by = 8</li>
 * </ul>
 * 
 * @version 1.0 12 Jan 2018
 * @author Firstname Lastname
 */
public enum FilterCriteria {
	NONE(0), REGEX(1), EQUAL(2), GREATERTHAN(3), LESSTHAN(4), 
	GREATERTHANOREQUAL(5), LESSTHANOREQUAL(6), NOTEQUAL(7), SORTBY(8);
	
	private int code;

	/**
	 * Sets the filter criteria code
	 * 
	 * @param code
	 */
	private FilterCriteria(int code) {
		this.code = code;
	}

	/**
	 * Returns the filter criteria enum for the given code
	 * 
	 * @param code
	 * @return FilterCriteria
	 */
	public FilterCriteria getEnum(int code) {
		FilterCriteria[] values = FilterCriteria.values();
		if (code <= 0 || code >= values.length) {
			return NONE;
		} else {
			return values[code];
		}
	}

	/**
	 * Returns the filter criteria code
	 * 
	 * @return code
	 */
	public int getCode() {
		return code;
	}

}
