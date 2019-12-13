package csi.vidaplus.rcm.dataimport.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import csi.vidaplus.rcm.dataimport.model.NurseNotes;

public interface EncounterNurseNotesRepository extends MongoRepository<NurseNotes,String> {

	@Query(value="{'encounterId': ?0 ,processed : false}", delete = true)
	List<NurseNotes> deleteByEncounterId(String encounterId);
	
	@Query(value="{processed : false}", delete = true)
	List<NurseNotes> deleteByIdIn(List<String> ids);
	
	
	@Query(value="{processed : false}")
	List<NurseNotes> findUnprocessed();
	
	
	@Query(value="{'encounterId': ?0 ,processed : false}")
	List<NurseNotes> findByEncounterId(String encounterId);
}
