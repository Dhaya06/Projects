package csi.vidaplus.rcm.dataimport.service;

import java.util.List;

import csi.vidaplus.rcm.dataimport.model.EncounterActivity;

public interface EncounterActivityService {

	List<EncounterActivity> insert(Iterable<EncounterActivity> claimActivities);

	List<EncounterActivity> update(Iterable<EncounterActivity> claimActivities);
	
	List<EncounterActivity> deleteByInvoice(String invoiceId);
	
	List<EncounterActivity> delete(List<String> ids);
	
	List<EncounterActivity> unprocessed();
	
	List<EncounterActivity> unprocessedByInvoiceId(String invoiceId);
}
