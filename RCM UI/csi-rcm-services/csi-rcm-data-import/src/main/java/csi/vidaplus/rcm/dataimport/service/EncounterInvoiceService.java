package csi.vidaplus.rcm.dataimport.service;

import java.util.List;

import csi.vidaplus.rcm.dataimport.model.EncounterInvoice;

public interface EncounterInvoiceService {

	List<EncounterInvoice> insert(Iterable<EncounterInvoice> claimInvoices);

	List<EncounterInvoice> update(Iterable<EncounterInvoice> claimInvoices);
	
	List<EncounterInvoice> deleteByEncounter(String encounterId);
	
	List<EncounterInvoice> delete(List<String> ids);
	
	List<EncounterInvoice> unprocessed();
	
	List<EncounterInvoice> unprocessedByEncounterId(String encounterId);
}
