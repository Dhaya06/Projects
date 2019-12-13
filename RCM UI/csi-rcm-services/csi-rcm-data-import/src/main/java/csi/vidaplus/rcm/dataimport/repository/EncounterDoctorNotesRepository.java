package csi.vidaplus.rcm.dataimport.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import csi.vidaplus.rcm.dataimport.model.DoctorNotes;

public interface EncounterDoctorNotesRepository extends MongoRepository<DoctorNotes,String> {

	@Query(value="{'encounterId': ?0 ,processed : false}", delete = true)
	List<DoctorNotes> deleteByEncounterId(String encounterId);
	
	@Query(value="{processed : false}", delete = true)
	List<DoctorNotes> deleteByIdIn(List<String> ids);
	
	
	@Query(value="{processed : false}")
	List<DoctorNotes> findUnprocessed();
	
	
	@Query(value="{'encounterId': ?0 ,processed : false}")
	List<DoctorNotes> findByEncounterId(String encounterId);
}
