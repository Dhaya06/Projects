package csi.vidaplus.rcm.datavalidation.service;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csi.vidaplus.rcm.datavalidation.feign.EncounterImportService;
import csi.vidaplus.rcm.datavalidation.model.BaseModel;
import csi.vidaplus.rcm.datavalidation.model.ValidationClass;
import csi.vidaplus.rcm.datavalidation.model.ValidationField;

@Service
public class FieldValidationServiceImpl implements FieldValidationService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EncounterImportService dataImportService;

	@Override
	public <T extends BaseModel> List<T> validateSystemFields(List<T> records, ValidationClass validationClass,
			Class<T> classz) {

		logger.info("Start system field validation for ", records);

		List<T> erroneousRecords = new LinkedList<>();

		Map<String, ValidationField> validationFieldMap = validationClass.getSystemDefinedFields().stream()
				.collect(Collectors.toMap(ValidationField::getField, fld -> fld));

		Field[] declaredFields = prepareFields(classz);

		for (T record : records) {

			logger.info("Validating ", record);

			StringBuilder errorMessage = new StringBuilder();

			Boolean hasError = Boolean.FALSE;

			for (Field field : declaredFields) {
				try {
					Object object = field.get(record);
					ValidationField validationField = validationFieldMap.get(field.getName());
					if (validationField == null) {
						continue;
					}

					List<String> allowableValues = validationField.getAllowableValues();

					//If the value is null and field is mandatory 
					if ((object == null && validationField.getIsMandotory())) {

						if (!hasError) {
							errorMessage
									.append("Errors on " + validationClass.getClassName() + " Id No " + record.getId());
							errorMessage.append("\n");
						}

						errorMessage.append(validationField.getMessage());
						errorMessage.append("\n");
						hasError = Boolean.TRUE;
					}

					if (allowableValues == null) {
						continue;
					}
					//if value is not an allowable value
					if (!allowableValues.contains(object)) {
						
						if (!hasError) {
							errorMessage
									.append("Error on " + validationClass.getClassName() + " Id No" + record.getId());
							errorMessage.append("\n");
						}
						
						errorMessage.append("Wrong value for ").append(field.getName()).append(", Value :")
								.append(object).append(allowableValues).append("\n");
						hasError = Boolean.TRUE;
					}

				} catch (IllegalArgumentException | IllegalAccessException e) {
					logger.error("Error reading fiedl " + field.getName(), record);
					throw new RuntimeException(e);
				}
			}

			if (hasError) {
				record.setErrorMessage(errorMessage.toString());
				erroneousRecords.add(record);
				logger.error("Found erroneous record ", record, errorMessage);
			}
			record.setProcessed(!hasError);
		}

		return erroneousRecords;

	}

	private Field[] prepareFields(Class<?> classz) {
		Field[] declaredFields = classz.getDeclaredFields();
		for (Field field : declaredFields) {
			field.setAccessible(true);
		}
		return declaredFields;
	}

	@Override
	public <T extends BaseModel> List<T> validateAttachments(List<T> records, ValidationClass validationClass,
			Class<T> classz) {

		List<ValidationField> attachments = validationClass.getAttachments();
		List<T> erroneousRecords = new LinkedList<>();

		if (attachments == null || attachments.isEmpty()) {

			return erroneousRecords;
		}

		List<String> requiredFields = attachments.stream().filter(att -> att.getIsMandotory())
				.map(att -> att.getField()).collect(Collectors.toList());

		for (T record : records) {
			List<String> requiredFieldsCopy = new LinkedList<>(requiredFields);
			Map<String, List<String>> attachmentIds = dataImportService.getAttachmentIds(record.getId());
			Set<String> attachmentFieldName = attachmentIds.keySet();
			requiredFieldsCopy.removeAll(attachmentFieldName);

			if (!requiredFieldsCopy.isEmpty()) {
				StringBuilder errorMessage = new StringBuilder("Missing Attachment\n");
				for (String requiredField : requiredFieldsCopy) {
					errorMessage.append(requiredField).append("\n");
				}

				String currentErrorMessage = record.getErrorMessage();
				if (currentErrorMessage == null) {
					record.setErrorMessage(errorMessage.toString());
				} else {
					record.setErrorMessage(currentErrorMessage + errorMessage.toString());
				}
				record.setProcessed(Boolean.FALSE);
				erroneousRecords.add(record);
			}

			record.setAttachmentIds(attachmentIds);
		}

		return erroneousRecords;
	}

	@Override
	public <T extends BaseModel> String generateErrorMessage(T record) {

		StringBuilder builder = new StringBuilder();

		// for (T t : records) {
		// builder.append(t.getErrorMessage());
		// builder.append("\n");
		// }
		//
		return record.getErrorMessage();
	}

}
