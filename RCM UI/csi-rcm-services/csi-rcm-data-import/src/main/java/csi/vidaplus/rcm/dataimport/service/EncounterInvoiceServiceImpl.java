package csi.vidaplus.rcm.dataimport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csi.vidaplus.rcm.dataimport.model.EncounterInvoice;
import csi.vidaplus.rcm.dataimport.repository.EncounterInvoiceRepository;

@Service
public class EncounterInvoiceServiceImpl implements EncounterInvoiceService {

	@Autowired
	private EncounterInvoiceRepository repository;
	
	@Override
	public List<EncounterInvoice> insert(Iterable<EncounterInvoice> claimInvoices) {
		claimInvoices.forEach(invoice -> invoice.setId(null));
		return repository.insert(claimInvoices);
	}

	@Override
	public List<EncounterInvoice> update(Iterable<EncounterInvoice> claimInvoices) {
		return repository.save(claimInvoices);
	}
	
	@Override
	public List<EncounterInvoice> delete(List<String> ids) {
		return repository.deleteByIdIn(ids);
	}
	
	@Override
	public List<EncounterInvoice> deleteByEncounter(String encounterId) {
		List<EncounterInvoice> findByEncounterId = repository.findByEncounterId(encounterId);
		repository.delete(findByEncounterId);
		return findByEncounterId;
	}

	@Override
	public List<EncounterInvoice> unprocessed() {
		return repository.findUnprocessed();
	}
	
	
	@Override
	public List<EncounterInvoice> unprocessedByEncounterId(String encounterId) {
		return repository.findByEncounterId(encounterId);
	}
}
