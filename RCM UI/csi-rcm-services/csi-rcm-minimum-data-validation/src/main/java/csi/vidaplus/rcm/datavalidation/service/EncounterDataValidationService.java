package csi.vidaplus.rcm.datavalidation.service;

import java.util.List;
import java.util.Set;

import csi.vidaplus.rcm.datavalidation.model.Encounter;

/**
 * @author Kasun Ranasinghe
 * @version 1.0
 * @since 2018/01/16
 * @author Kasun
 *
 */
public interface EncounterDataValidationService {

	/**
	 * This method validates the given {@code encounters} against defined minimum data set and set error message
	 * @param encounters
	 * @return set of erroneous encounters
	 */
	public Set<Encounter> validateEncounters(List<Encounter> encounters);
	
}
