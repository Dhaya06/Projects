package csi.vidaplus.rcm.dataimport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csi.vidaplus.rcm.dataimport.model.EncounterActivity;
import csi.vidaplus.rcm.dataimport.repository.EncounterActivityRepository;

@Service
public class EncounterActivityServiceImpl implements EncounterActivityService {

	@Autowired
	private EncounterActivityRepository repository;
	
	@Override
	public List<EncounterActivity> insert(Iterable<EncounterActivity> claimActivities) {
		claimActivities.forEach(act -> act.setId(null));
		return repository.insert(claimActivities);
	}

	@Override
	public List<EncounterActivity> update(Iterable<EncounterActivity> claimActivities) {
		return repository.save(claimActivities);
	}
	
	@Override
	public List<EncounterActivity> delete(List<String> ids) {
		return repository.deleteByIdIn(ids);
	}
	
	@Override
	public List<EncounterActivity> deleteByInvoice(String invoiceId) {
		List<EncounterActivity> findByInvoiceId = repository.findByInvoiceId(invoiceId);
		repository.delete(findByInvoiceId);
		return findByInvoiceId;
	}

	@Override
	public List<EncounterActivity> unprocessed() {
		return repository.findUnprocessed();
	}
	
	
	@Override
	public List<EncounterActivity> unprocessedByInvoiceId(String invoiceId) {
		return repository.findByInvoiceId(invoiceId);
	}
}
