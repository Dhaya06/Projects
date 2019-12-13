package csi.vidaplus.rcm.dataimport.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import csi.vidaplus.rcm.dataimport.model.EncounterActivity;

public interface EncounterActivityRepository extends MongoRepository<EncounterActivity,String> {

	@Query(value="{'encounterId': ?0 ,processed : false}", delete = true)
	List<EncounterActivity> deleteByInvoiceId(String invoiceId);
	
	@Query(value="{processed : false}", delete = true)
	List<EncounterActivity> deleteByIdIn(List<String> ids);
	
	
	@Query(value="{processed : false}")
	List<EncounterActivity> findUnprocessed();
	
	
	@Query(value="{'encounterId': ?0 ,processed : false}")
	List<EncounterActivity> findByInvoiceId(String invoiceId);
}
