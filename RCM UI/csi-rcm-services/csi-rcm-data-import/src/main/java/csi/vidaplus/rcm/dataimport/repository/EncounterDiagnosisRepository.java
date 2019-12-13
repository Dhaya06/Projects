package csi.vidaplus.rcm.dataimport.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import csi.vidaplus.rcm.dataimport.model.EncounterDiagnosis;

public interface EncounterDiagnosisRepository extends MongoRepository<EncounterDiagnosis, String> {

	@Query(value = "{processed : false}", delete = true)
	List<EncounterDiagnosis> deleteByEncounterId(String encounterId);

	@Query(value = "{processed : false}", delete = true)
	List<EncounterDiagnosis> deleteByIdIn(List<String> ids);

	@Query(value = "{processed : false}")
	List<EncounterDiagnosis> findUnprocessedQuery();

	@Query(value = "{'encounterId' : ?0 ,processed : false}")
	List<EncounterDiagnosis> fingUnprocessedByEncounterIdQuery(String encounterId);
	
	@Query(value="{'encounterId': ?0 ,processed : false}")
	List<EncounterDiagnosis> findByEncounterId(String encounterId);
}
