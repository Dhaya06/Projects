package csi.vidaplus.rcm.dataimport.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import csi.vidaplus.rcm.dataimport.model.EncounterInvoice;

public interface EncounterInvoiceRepository extends MongoRepository<EncounterInvoice,String> {

	@Query(value="{'encounterId': ?0 ,processed : false}", delete = true)
	List<EncounterInvoice> deleteByEncounterId(String encounterId);
	
	@Query(value="{processed : false}", delete = true)
	List<EncounterInvoice> deleteByIdIn(List<String> ids);
	
	
	@Query(value="{processed : false}")
	List<EncounterInvoice> findUnprocessed();
	
	
	@Query(value="{'encounterId': ?0 ,processed : false}")
	List<EncounterInvoice> findByEncounterId(String encounterId);
}
