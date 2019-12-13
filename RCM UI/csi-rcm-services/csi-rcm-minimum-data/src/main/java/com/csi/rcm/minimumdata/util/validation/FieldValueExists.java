package com.csi.rcm.minimumdata.util.validation;

public interface FieldValueExists {
	/**
	 * Checks whether or not a given value exists for a given field
	 * 
	 * @param value
	 *            Entity
	 * @param fieldName
	 *            The name of the field for which to check if the value exists
	 * @return True if the value exists for the field; false otherwise
	 */
	boolean fieldValueExists(Object object, String fieldName) ;
}
