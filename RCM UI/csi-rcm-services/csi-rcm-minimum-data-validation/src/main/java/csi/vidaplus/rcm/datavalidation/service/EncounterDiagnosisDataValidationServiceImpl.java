package csi.vidaplus.rcm.datavalidation.service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csi.vidaplus.rcm.datavalidation.feign.MinimumDataSetService;
import csi.vidaplus.rcm.datavalidation.model.EncounterActivity;
import csi.vidaplus.rcm.datavalidation.model.EncounterDiagnosis;
import csi.vidaplus.rcm.datavalidation.model.ValidationClass;

@Service
public class EncounterDiagnosisDataValidationServiceImpl implements EncounterDiagnosisDataValidationService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private FieldValidationService fieldValidationService;

	@Autowired
	private MinimumDataSetService minimumDataSetService;

	@Override
	public Set<EncounterDiagnosis> validateEncounterDiagnosis(List<EncounterDiagnosis> encounterActivities) {
		
		logger.info("Start encounter diagnosis validation",encounterActivities);
		
		ValidationClass validationClass = minimumDataSetService.getValidationClass("EncounterActivity");

		List<EncounterDiagnosis> erroneousEncounterActivities = fieldValidationService
				.validateSystemFields(encounterActivities, validationClass, EncounterDiagnosis.class);

		List<EncounterDiagnosis> validateAttachments = fieldValidationService.validateAttachments(encounterActivities, validationClass, EncounterDiagnosis.class);
		
		erroneousEncounterActivities.addAll(validateAttachments);
		
		logger.info("List of  erroneous encounter diagnosis",erroneousEncounterActivities);
		logger.info("Complete encounter diagnosis validation");
		
		return new HashSet<>(erroneousEncounterActivities);
	}

	@Override
	public void generateFinalErrorMessage(List<EncounterDiagnosis> encounterDiagnosis,
			StringBuilder finalErrorMessage) {

		for (EncounterDiagnosis encounterDiagnos : encounterDiagnosis) {
			finalErrorMessage.append("Encounter Diagnos errors \n");
			String diagnosErrorMessage = fieldValidationService.generateErrorMessage(encounterDiagnos);
			finalErrorMessage.append(diagnosErrorMessage).append("\n");
		}
	}
}
