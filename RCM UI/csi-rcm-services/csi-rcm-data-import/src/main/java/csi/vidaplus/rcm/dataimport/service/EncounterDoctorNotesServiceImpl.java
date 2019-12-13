package csi.vidaplus.rcm.dataimport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csi.vidaplus.rcm.dataimport.model.DoctorNotes;
import csi.vidaplus.rcm.dataimport.repository.EncounterDoctorNotesRepository;

@Service
public class EncounterDoctorNotesServiceImpl implements EncounterDoctorNotesService {

	@Autowired
	private EncounterDoctorNotesRepository repository;
	
	@Override
	public List<DoctorNotes> insert(Iterable<DoctorNotes> doctorNotes) {
		doctorNotes.forEach(doctorNote -> doctorNote.setId(null));
		return repository.insert(doctorNotes);
	}

	@Override
	public List<DoctorNotes> update(Iterable<DoctorNotes> doctorNotes) {
		return repository.save(doctorNotes);
	}
	
	@Override
	public List<DoctorNotes> delete(List<String> ids) {
		return repository.deleteByIdIn(ids);
	}
	
	@Override
	public List<DoctorNotes> deleteByEncounter(String encounterId) {
		List<DoctorNotes> findByEncounterId = repository.findByEncounterId(encounterId);
		repository.delete(findByEncounterId);
		return findByEncounterId;
	}

	@Override
	public List<DoctorNotes> unprocessed() {
		return repository.findUnprocessed();
	}
	
	
	@Override
	public List<DoctorNotes> unprocessedByEncounterId(String encounterId) {
		return repository.findByEncounterId(encounterId);
	}
}
