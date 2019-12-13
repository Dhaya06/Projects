package csi.vidaplus.rcm.dataimport.service;

import java.util.List;

import csi.vidaplus.rcm.dataimport.model.NurseNotes;

public interface EncounterNurseNotesService {

	List<NurseNotes> insert(Iterable<NurseNotes> nurseNotes);

	List<NurseNotes> update(Iterable<NurseNotes> nurseNotes);
	
	List<NurseNotes> deleteByEncounter(String encounterId);
	
	List<NurseNotes> delete(List<String> ids);
	
	List<NurseNotes> unprocessed();
	
	List<NurseNotes> unprocessedByEncounterId(String encounterId);
}
