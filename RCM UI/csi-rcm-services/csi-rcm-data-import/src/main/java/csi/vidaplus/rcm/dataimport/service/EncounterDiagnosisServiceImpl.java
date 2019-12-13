package csi.vidaplus.rcm.dataimport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csi.vidaplus.rcm.dataimport.model.EncounterDiagnosis;
import csi.vidaplus.rcm.dataimport.repository.EncounterDiagnosisRepository;

@Service
public class EncounterDiagnosisServiceImpl implements EncounterDiagnosisService {

	@Autowired
	private EncounterDiagnosisRepository repository;

	@Override
	public List<EncounterDiagnosis> insert(Iterable<EncounterDiagnosis> claimDiagnosis) {
		claimDiagnosis.forEach(diga -> diga.setId(null));
		return repository.insert(claimDiagnosis);
	}

	@Override
	public List<EncounterDiagnosis> update(Iterable<EncounterDiagnosis> claimDiagnosis) {
		return repository.save(claimDiagnosis);
	}

	@Override
	public List<EncounterDiagnosis> delete(List<String> ids) {
		return repository.deleteByIdIn(ids);
	}
	
	@Override
	public List<EncounterDiagnosis> deleteByEncounter(String encountersId) {
		List<EncounterDiagnosis> findByEncounterId = repository.findByEncounterId(encountersId);
		repository.delete(findByEncounterId);
		return findByEncounterId;
	}
	
	@Override
	public List<EncounterDiagnosis> unprocessed() {
		return repository.findUnprocessedQuery();
	}
	
	@Override
	public List<EncounterDiagnosis> unprocessedByEncounterId(String encounterId) {
		return repository.fingUnprocessedByEncounterIdQuery(encounterId);
	}
	
}
