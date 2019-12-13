package csi.vidaplus.rcm.dataimport.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import csi.vidaplus.rcm.dataimport.model.Encounter;

public interface EncounterRepository extends MongoRepository<Encounter, String> {

	
	@Query(value="{processed : false}", delete = true)
	public List<Encounter> deleteByIdsIn(List<String> ids);
	
	
	@Query(value="{processed : false}")
	public List<Encounter> unprocessed();
	
}
