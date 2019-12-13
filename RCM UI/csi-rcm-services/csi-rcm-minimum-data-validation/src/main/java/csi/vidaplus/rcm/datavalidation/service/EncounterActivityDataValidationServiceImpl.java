package csi.vidaplus.rcm.datavalidation.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csi.vidaplus.rcm.datavalidation.feign.MinimumDataSetService;
import csi.vidaplus.rcm.datavalidation.model.EncounterActivity;
import csi.vidaplus.rcm.datavalidation.model.ValidationClass;

@Service
public class EncounterActivityDataValidationServiceImpl implements EncounterActivityDataValidationService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private FieldValidationService fieldValidationService;

	@Autowired
	private MinimumDataSetService minimumDataSetService;

	@Override
	public Set<EncounterActivity> validateEncounterActivities(List<EncounterActivity> encounterActivities) {

		logger.info("Start encounter activity validation",encounterActivities);
		
		ValidationClass validationClass = minimumDataSetService.getValidationClass("EncounterActivity");

		List<EncounterActivity> erroneousActivities = fieldValidationService.validateSystemFields(encounterActivities,
				validationClass, EncounterActivity.class);
		
		List<EncounterActivity> validateAttachments = fieldValidationService.validateAttachments(encounterActivities, validationClass, EncounterActivity.class);
		erroneousActivities.addAll(validateAttachments);
		
		logger.info("List of erroneous activities",erroneousActivities);
		logger.info("Complete the encounter Validation");
		
		return new HashSet<>(erroneousActivities);
	}

	@Override
	public void generateFinalErrorMessage(List<EncounterActivity> encounterActivities,
			StringBuilder finalErrorMessage) {

		for (EncounterActivity encounterActivity : encounterActivities) {
			finalErrorMessage.append("Encounter Activity errors \n");
			String activityErrorMessage = fieldValidationService.generateErrorMessage(encounterActivity);
			finalErrorMessage.append(activityErrorMessage).append("\n");
						
		}
	}

}
