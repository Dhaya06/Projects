package csi.vidaplus.rcm.datavalidation.service;

import java.util.List;

import csi.vidaplus.rcm.datavalidation.model.BaseModel;
import csi.vidaplus.rcm.datavalidation.model.ValidationClass;

public interface FieldValidationService {

	public <T extends BaseModel> List<T> validateSystemFields(List<T> records, ValidationClass validationClass,
			Class<T> classz);
	
	public <T extends BaseModel> String generateErrorMessage(T record);

	public <T extends BaseModel> List<T> validateAttachments(List<T> records, ValidationClass validationClass,
			Class<T> classz);
	
}
