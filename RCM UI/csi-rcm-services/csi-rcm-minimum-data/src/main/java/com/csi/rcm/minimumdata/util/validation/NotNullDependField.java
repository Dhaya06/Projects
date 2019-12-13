package com.csi.rcm.minimumdata.util.validation;

import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
 *  This annotation use to validate dependent fields.
 */

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotNullDependFieldValidator.class)
@Documented
public @interface NotNullDependField {
	
	String fieldName();

	String dependFieldName();

	String expectedValue();
	
	String message() default "{NotNullIfAnotherFieldHasValue.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@interface List {
		NotNullDependField[] value();
	}

}
