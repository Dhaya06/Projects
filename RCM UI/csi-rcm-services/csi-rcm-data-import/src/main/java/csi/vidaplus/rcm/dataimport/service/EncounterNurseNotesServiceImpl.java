package csi.vidaplus.rcm.dataimport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csi.vidaplus.rcm.dataimport.model.NurseNotes;
import csi.vidaplus.rcm.dataimport.repository.EncounterNurseNotesRepository;

@Service
public class EncounterNurseNotesServiceImpl implements EncounterNurseNotesService {

	@Autowired
	private EncounterNurseNotesRepository repository;
	
	@Override
	public List<NurseNotes> insert(Iterable<NurseNotes> nurseNotes) {
		nurseNotes.forEach(nurseNote -> nurseNote.setId(null));
		return repository.insert(nurseNotes);
	}

	@Override
	public List<NurseNotes> update(Iterable<NurseNotes> nurseNotes) {
		return repository.save(nurseNotes);
	}
	
	@Override
	public List<NurseNotes> delete(List<String> ids) {
		return repository.deleteByIdIn(ids);
	}
	
	@Override
	public List<NurseNotes> deleteByEncounter(String encounterId) {
		List<NurseNotes> findByEncounterId = repository.findByEncounterId(encounterId);
		repository.delete(findByEncounterId);
		return findByEncounterId;
	}

	@Override
	public List<NurseNotes> unprocessed() {
		return repository.findUnprocessed();
	}
	
	
	@Override
	public List<NurseNotes> unprocessedByEncounterId(String encounterId) {
		return repository.findByEncounterId(encounterId);
	}
}
