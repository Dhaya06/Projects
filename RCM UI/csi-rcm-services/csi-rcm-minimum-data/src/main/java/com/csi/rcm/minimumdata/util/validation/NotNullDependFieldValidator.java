package com.csi.rcm.minimumdata.util.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
/**
 * 
 * @author Kasun
 * @version 1.0
 * @since 2018/01/23
 *
 */
public class NotNullDependFieldValidator implements ConstraintValidator<NotNullDependField, Object> {

	private String fieldName;
	private String dependFieldName;
	private String expectedValue;
	
	@Override
	public void initialize(NotNullDependField annotation) {
		fieldName = annotation.fieldName();
		dependFieldName = annotation.dependFieldName();
		expectedValue = annotation.expectedValue();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext ctx) {
		if (value == null) {
			return true;
		}

		BeanWrapper wrapper = PropertyAccessorFactory.forBeanPropertyAccess(value);
		Object fieldValue = wrapper.getPropertyValue(fieldName);
		Object dependFieldValue = wrapper.getPropertyValue(dependFieldName);

		//if the field value is not null and has the expected value the dependField should have a value
		if (fieldValue != null && fieldValue.toString().equals(expectedValue) && dependFieldValue == null) {
			ctx.disableDefaultConstraintViolation();
			ctx.buildConstraintViolationWithTemplate(ctx.getDefaultConstraintMessageTemplate())
					.addPropertyNode(dependFieldName).addConstraintViolation();
			return false;
		}

		return true;
	}

}
