package csi.vidaplus.rcm.datavalidation.service;

import java.util.List;
import java.util.Set;

import csi.vidaplus.rcm.datavalidation.model.EncounterDiagnosis;


/**
 * @author Kasun Ranasinghe
 * @version 1.0
 * @since 2018/01/16
 * @author Kasun
 *
 */
public interface EncounterDiagnosisDataValidationService {
	
	/**
	 * This method validates the given {@code encounterDiagnosis} against defined minimum data set and set error message
	 * @param encounterDiagnosis
	 * @return set of erroneous encounter diagnosis
	 */
	public Set<EncounterDiagnosis> validateEncounterDiagnosis(List<EncounterDiagnosis> encounterDiagnosis);

	/*
	 * This method creates final error message
	 */
	public void generateFinalErrorMessage(List<EncounterDiagnosis> encounterDiagnosis, StringBuilder finalErrorMessage);
}
