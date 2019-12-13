package com.csi.rcm.minimumdata.util.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class UniqueValidator implements ConstraintValidator<Unique, Object> {

	@Autowired
	private ApplicationContext applicationContext;
	private FieldValueExists service;
	private String fieldName;

	@Override
	public void initialize(Unique unique) {

		if (this.applicationContext == null) {
			return;
		}

		Class<? extends FieldValueExists> clazz = unique.service();
		this.fieldName = unique.fieldName();
		String serviceQualifier = unique.serviceQualifier();

		if (!serviceQualifier.equals("")) {
			this.service = this.applicationContext.getBean(serviceQualifier, clazz);
		} else {
			this.service = this.applicationContext.getBean(clazz);
		}
	}

	@Override
	public boolean isValid(Object object, ConstraintValidatorContext ctx) {
		// some times UniqueValidator object create 2 time. in the 2nd time it will
		// create without using spring DI. so at that time we will not get any ctx.
		if (this.applicationContext == null) {
			return Boolean.TRUE;
		}

		if (object == null) {
			return true;
		}

		BeanWrapper wrapper = PropertyAccessorFactory.forBeanPropertyAccess(object);
		String fieldValue = (String) wrapper.getPropertyValue(fieldName);
		// if the fieldValue not exist the its not a duplicate value
		return !this.service.fieldValueExists(object, fieldValue);
	}

}
