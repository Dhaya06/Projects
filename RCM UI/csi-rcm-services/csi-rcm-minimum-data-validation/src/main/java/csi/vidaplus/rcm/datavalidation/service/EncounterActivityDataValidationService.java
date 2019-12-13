package csi.vidaplus.rcm.datavalidation.service;

import java.util.List;
import java.util.Set;

import csi.vidaplus.rcm.datavalidation.model.EncounterActivity;

/**
 * 
 * @author Kasun Ranasinghe
 * @version 1.0
 * @since 2018/01/16
 *
 * Purpose of this class to validate Encounter Activities 
 */
public interface EncounterActivityDataValidationService {

	/**
	 * This method validates the given {@code encounterActivities} against defined minimum data set and set error message 
	 * @param encounterActivities to validate
	 * @return set of erroneous activities
	 */
	public Set<EncounterActivity> validateEncounterActivities(List<EncounterActivity> encounterActivities);
	
	/**
	 * This method creates final error message
	 * @param encounterActivities
	 * @param finalErrorMessage
	 */
	public void generateFinalErrorMessage(List<EncounterActivity> encounterActivities,StringBuilder finalErrorMessage);
}
