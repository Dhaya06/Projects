package com.csi.rcm.worklist.util.validation;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

public class UniqueValidator implements ConstraintValidator<UniqueList, Object> {

	private String fieldToCheckUnique;

	@Override
	public void initialize(UniqueList unique) {
		fieldToCheckUnique = unique.fieldToCheckUnique();
	}

	@Override
	public boolean isValid(Object object, ConstraintValidatorContext ctx) {

		if(object == null) {
			return true;
		}
		
		Set<Object> fieldValues = new HashSet<>();
		Collection listOfObjects = (Collection) object;
		for (Object object2 : listOfObjects) {
			BeanWrapper wrapper = PropertyAccessorFactory.forBeanPropertyAccess(object2);
			Object fieldValue = wrapper.getPropertyValue(fieldToCheckUnique);
			if (!fieldValues.add(fieldValue)) {
				return false;
			}
		}
		return true;
	}

}
