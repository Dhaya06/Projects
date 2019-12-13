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
package com.csi.vidaplus.rcm.datadictionary.protocol;

import java.io.Serializable;

/**
 * Generic class for the request
 * 
 * @version 1.0 12 Jan 2018
 * @author Mohomad Nusky
 */
public class RequestEnvelope<T> implements Serializable {
	private String type;
	private T body;

	/**
	 * Returns the request type
	 * 
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the request  type
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Returns the request object body
	 * 
	 * @return body
	 */
	public T getBody() {
		return body;
	}

	/**
	 * Sets the request  object body
	 * 
	 * @param body
	 */
	public void setBody(T body) {
		this.body = body;
	}
}
