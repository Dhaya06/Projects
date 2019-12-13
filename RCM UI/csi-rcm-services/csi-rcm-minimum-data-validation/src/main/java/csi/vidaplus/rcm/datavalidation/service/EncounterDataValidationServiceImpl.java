package csi.vidaplus.rcm.datavalidation.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csi.vidaplus.rcm.datavalidation.feign.MinimumDataSetService;
import csi.vidaplus.rcm.datavalidation.feign.NotificationService;
import csi.vidaplus.rcm.datavalidation.model.Encounter;
import csi.vidaplus.rcm.datavalidation.model.EncounterActivity;
import csi.vidaplus.rcm.datavalidation.model.EncounterDiagnosis;
import csi.vidaplus.rcm.datavalidation.model.Message;
import csi.vidaplus.rcm.datavalidation.model.MessageId;
import csi.vidaplus.rcm.datavalidation.model.MessageInfo;
import csi.vidaplus.rcm.datavalidation.model.ValidationClass;

@Service
public class EncounterDataValidationServiceImpl implements EncounterDataValidationService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private FieldValidationService fieldValidationService;

	@Autowired
	private MinimumDataSetService minimumDataSetService;

	@Autowired
	private EncounterActivityDataValidationService activityDataValidationService;

	@Autowired
	private EncounterDiagnosisDataValidationService diagnosisDataValidationService;
	
	@Autowired
	private NotificationService notificationService;

	public Set<Encounter> validateEncounters(List<Encounter> encounters) {

		logger.info("Start encounter validation",encounters);
		
		ValidationClass validationClass = minimumDataSetService.getValidationClass("Encounter");

		List<Encounter> erroneousEncounters = fieldValidationService.validateSystemFields(encounters, validationClass,
				Encounter.class);
		
		List<Encounter> validateAttachments = fieldValidationService.validateAttachments(encounters, validationClass,Encounter.class);
		erroneousEncounters.addAll(validateAttachments);

		for (Encounter encounter : encounters) {
			Set<EncounterActivity> erroneousEncounterActivities = activityDataValidationService
					.validateEncounterActivities(encounter.getEncounterActivities());

			Set<EncounterDiagnosis> erroneousEncounterDiagnosis = diagnosisDataValidationService
					.validateEncounterDiagnosis(encounter.getEncounterDiagnosis());
			// if there is a erroneous activity or diagnosis then update the encounter as
			// not processed
			if (!erroneousEncounterActivities.isEmpty() || !erroneousEncounterDiagnosis.isEmpty()) {
				encounter.setProcessed(false);
				erroneousEncounters.add(encounter);
			}
		}

		String generateErrorMessage = generateErrorMessage(erroneousEncounters);
		sendErrorMessage(generateErrorMessage);
		
		logger.info("List of erroneous encounters",erroneousEncounters);
		logger.info("Complete encounter validation");
		
		return new HashSet<>(encounters);
	}

	
	private void sendErrorMessage(String generatedMessage) {
		
		MessageInfo messageInfo = minimumDataSetService.gteValidationMessageInfo();
		MessageId id = new MessageId();
		id.setId(messageInfo.getRecevierId());
		id.setUserId(messageInfo.getRecevierUserId());
		Message message = new Message();
		message.setId(id);
		message.setMessage(generatedMessage);
		message.setNotificationType(messageInfo.getNotificationType());
		message.setNotificationMessageType(messageInfo.getNotificationMessageType());
		message.setTitle("Minimum Data Validation");
		
		notificationService.sendNotification(message);
	}
	
	private String generateErrorMessage(List<Encounter> erroneousEncounters) {
		StringBuilder finalErrorMessage = new StringBuilder();
		
		for (Encounter encounter : erroneousEncounters) {
			String encounterErrorMessage = fieldValidationService.generateErrorMessage(encounter);
			finalErrorMessage.append("Encounter errors").append(encounterErrorMessage).append("\n");

			diagnosisDataValidationService.generateFinalErrorMessage(encounter.getEncounterDiagnosis(), finalErrorMessage);
			activityDataValidationService.generateFinalErrorMessage(encounter.getEncounterActivities(), finalErrorMessage);

		}
		return finalErrorMessage.toString();

	}

}
