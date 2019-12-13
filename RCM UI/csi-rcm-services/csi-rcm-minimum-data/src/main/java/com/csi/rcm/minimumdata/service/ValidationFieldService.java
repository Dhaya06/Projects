package com.csi.rcm.minimumdata.service;

import java.util.List;

import com.csi.rcm.minimumdata.cqrs.commands.CreateValidationFieldCommand;
import com.csi.rcm.minimumdata.model.ValidationClass;
import com.csi.rcm.minimumdata.model.ValidationField;

/**
 * 
 * @author Kasun
 * @version 1.0
 * @since 2018/01/23
 *
 */
public interface ValidationFieldService {

	/**
	 * This method use to save {@code ValidationField}
	 * @param validationField
	 */
	public void saveValidationField(ValidationField validationField);
	
	/**
	 * This method use to create list of {@code CreateValidationFieldCommand} from list of {@code ValidationField}
	 * 
	 * @param fields
	 * @return
	 */
	public List<CreateValidationFieldCommand>  getCreateValidationFieldCommands(List<ValidationField> fields);
	
	/**
	 * This method use to get {@code ValidationField} of {@code systemValidateionClass}
	 * @param systemValidateionClass
	 * @return
	 */
	public List<ValidationField> findAllBySystemValidateionClass(ValidationClass systemValidateionClass);
	
	/**
	 * This method will check the @c{@code ValidationField} is removed  from the {@code fields}
	 * 
	 * @param fields
	 * @param currentFields
	 * @return
	 */
	public Boolean systemFieldsRemoved(List<ValidationField> fields, List<ValidationField> currentFields);
}
