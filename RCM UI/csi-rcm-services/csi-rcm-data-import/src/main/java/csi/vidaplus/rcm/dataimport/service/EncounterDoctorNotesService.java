package csi.vidaplus.rcm.dataimport.service;

import java.util.List;

import csi.vidaplus.rcm.dataimport.model.DoctorNotes;

public interface EncounterDoctorNotesService {

	List<DoctorNotes> insert(Iterable<DoctorNotes> doctorNotes);

	List<DoctorNotes> update(Iterable<DoctorNotes> doctorNotes);
	
	List<DoctorNotes> deleteByEncounter(String encounterId);
	
	List<DoctorNotes> delete(List<String> ids);
	
	List<DoctorNotes> unprocessed();
	
	List<DoctorNotes> unprocessedByEncounterId(String encounterId);
}
