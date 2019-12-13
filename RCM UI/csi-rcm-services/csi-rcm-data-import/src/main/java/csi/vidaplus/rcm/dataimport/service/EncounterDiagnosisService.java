package csi.vidaplus.rcm.dataimport.service;

import java.util.List;

import csi.vidaplus.rcm.dataimport.model.EncounterDiagnosis;

public interface EncounterDiagnosisService {

	List<EncounterDiagnosis> insert(Iterable<EncounterDiagnosis> claimDiagnosis);

	List<EncounterDiagnosis> update(Iterable<EncounterDiagnosis> claimDiagnosis);
	
	List<EncounterDiagnosis> deleteByEncounter(String encountersId);
	
	List<EncounterDiagnosis> delete(List<String> ids);
	
	List<EncounterDiagnosis> unprocessed();
	
	List<EncounterDiagnosis> unprocessedByEncounterId(String encounterId);
}
