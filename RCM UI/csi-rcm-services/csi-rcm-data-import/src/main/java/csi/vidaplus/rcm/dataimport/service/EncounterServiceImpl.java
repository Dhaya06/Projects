package csi.vidaplus.rcm.dataimport.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csi.vidaplus.rcm.dataimport.model.DoctorNotes;
import csi.vidaplus.rcm.dataimport.model.Encounter;
import csi.vidaplus.rcm.dataimport.model.EncounterActivity;
import csi.vidaplus.rcm.dataimport.model.EncounterDiagnosis;
import csi.vidaplus.rcm.dataimport.model.EncounterInvoice;
import csi.vidaplus.rcm.dataimport.model.NurseNotes;
import csi.vidaplus.rcm.dataimport.repository.EncounterActivityRepository;
import csi.vidaplus.rcm.dataimport.repository.EncounterInvoiceRepository;
import csi.vidaplus.rcm.dataimport.repository.EncounterRepository;

@Service
public class EncounterServiceImpl implements EncounterService {

	@Autowired
	private EncounterRepository encounterRepository;

	@Autowired
	private EncounterInvoiceService encounterInvoiceService;

	@Autowired
	private EncounterActivityService encounterActivityService;

	@Autowired
	private EncounterDiagnosisService encounterDiagnosisService;
	
	@Autowired
	private EncounterDoctorNotesService encounterDoctorNotesService;
	
	@Autowired
	private EncounterNurseNotesService encounterNurseNotesService;

	@Override
	public List<Encounter> insert(Iterable<Encounter> encounters) {

		encounters.forEach(enc -> enc.setId(null));

		List<Encounter> inserted = encounterRepository.insert(encounters);

		for (Encounter encounter : encounters) {
			List<EncounterInvoice> invoices = encounter.getEncounterInvoices();

			if (invoices != null && invoices.size() > 0) {
				for (EncounterInvoice invoice : invoices) {
					invoice.setEncounterId(encounter.getId());
					List<EncounterActivity> activities = invoice.getEncounterActivities();

					if (activities != null && activities.size() > 0) {
						for (EncounterActivity activity : activities) {
							activity.setEncounterInvoiceNo(invoice.getId());
						}
						encounterActivityService.insert(activities);
					}
					invoice.setEncounterActivities(activities);
				}
				encounterInvoiceService.insert(invoices);
			}

			List<EncounterDiagnosis> diagnosis = encounter.getEncounterDiagnosis();
			if (diagnosis != null && diagnosis.size() > 0) {
				diagnosis.stream().forEach(diagnos -> diagnos.setEncounterId(encounter.getId()));
				encounterDiagnosisService.insert(diagnosis);
			}
			
			List<DoctorNotes> doctorNotes = encounter.getDoctorNotes();
			if (doctorNotes != null && doctorNotes.size() > 0) {
				doctorNotes.stream().forEach(doctorNote -> doctorNote.setEncounterId(encounter.getId()));
				encounterDoctorNotesService.insert(doctorNotes);
			}
			
			List<NurseNotes> nurseNotes = encounter.getNurseNotes();
			if (nurseNotes != null && nurseNotes.size() > 0) {
				nurseNotes.stream().forEach(nurseNote -> nurseNote.setEncounterId(encounter.getId()));
				encounterNurseNotesService.insert(nurseNotes);
			}

			encounter.setEncounterInvoices(invoices);
			encounter.setEncounterDiagnosis(diagnosis);
			encounter.setDoctorNotes(doctorNotes);
			encounter.setNurseNotes(nurseNotes);
		}

		return inserted;
	}

	@Override
	public List<Encounter> update(Iterable<Encounter> encounters) {

		List<Encounter> savedencounter = encounterRepository.save(encounters);

		for (Encounter encounter : encounters) {
			List<EncounterInvoice> invoices = encounter.getEncounterInvoices();

			if (invoices != null && invoices.size() > 0) {
				for (EncounterInvoice invoice : invoices) {
					List<EncounterActivity> activities = invoice.getEncounterActivities();

					if (activities != null && activities.size() > 0) {
						encounterActivityService.update(activities);
					}
					invoice.setEncounterActivities(activities);
				}
				encounterInvoiceService.update(invoices);
			}

			List<EncounterDiagnosis> diagnosis = encounter.getEncounterDiagnosis();
			if (diagnosis != null && diagnosis.size() > 0) {
				diagnosis = encounterDiagnosisService.update(diagnosis);
			}
			
			List<DoctorNotes> doctorNotes = encounter.getDoctorNotes();
			if (doctorNotes != null && doctorNotes.size() > 0) {
				encounterDoctorNotesService.update(doctorNotes);
			}
			
			List<NurseNotes> nurseNotes = encounter.getNurseNotes();
			if (nurseNotes != null && nurseNotes.size() > 0) {
				encounterNurseNotesService.update(nurseNotes);
			}

			encounter.setEncounterInvoices(invoices);
			encounter.setEncounterDiagnosis(diagnosis);
			encounter.setDoctorNotes(doctorNotes);
			encounter.setNurseNotes(nurseNotes);
		}

		return savedencounter;
	}

	@Override
	public List<Encounter> delete(List<String> ids) {
		List<Encounter> deleteEncounters = new LinkedList<>();

		for (String encounterId : ids) {
			Encounter encounter = encounterRepository.findOne(encounterId);
			encounterRepository.delete(encounter);

			List<EncounterInvoice> encounterInvoices = encounterInvoiceService.deleteByEncounter(encounterId);

			for (EncounterInvoice encounterInvoice : encounterInvoices) {
				List<EncounterActivity> deletedActivities = encounterActivityService
						.deleteByInvoice(encounterInvoice.getInvoiceNo());
				encounterInvoice.setEncounterActivities(deletedActivities);
			}
			List<EncounterDiagnosis> deletedDiagnosis = encounterDiagnosisService.deleteByEncounter(encounterId);
			List<DoctorNotes> deletedDoctorNotes = encounterDoctorNotesService.deleteByEncounter(encounterId);
			List<NurseNotes> deletedNurseNotes = encounterNurseNotesService.deleteByEncounter(encounterId);
			
			encounter.setEncounterInvoices(encounterInvoices);
			encounter.setEncounterDiagnosis(deletedDiagnosis);
			encounter.setDoctorNotes(deletedDoctorNotes);
			encounter.setNurseNotes(deletedNurseNotes);

			deleteEncounters.add(encounter);
		}

		return deleteEncounters;
	}

	@Override
	public List<Encounter> getUnprocessedEncounter() {
		List<Encounter> unprocessed = encounterRepository.unprocessed();
		for (Encounter encounter : unprocessed) {
			List<EncounterInvoice> unprocessedInvoices = encounterInvoiceService
					.unprocessedByEncounterId(encounter.getId());
			for (EncounterInvoice encounterInvoice : unprocessedInvoices) {
				List<EncounterActivity> unprocessedActivites = encounterActivityService
						.unprocessedByInvoiceId(encounterInvoice.getId());
				encounterInvoice.setEncounterActivities(unprocessedActivites);
			}
			encounter.setEncounterInvoices(unprocessedInvoices);

			List<EncounterDiagnosis> unprocessedDiagnosis = encounterDiagnosisService
					.unprocessedByEncounterId(encounter.getId());
			List<DoctorNotes> unprocessedDoctorNotes = encounterDoctorNotesService
					.unprocessedByEncounterId(encounter.getId());
			List<NurseNotes> unprocessedNurseNotes = encounterNurseNotesService
					.unprocessedByEncounterId(encounter.getId());
			
			encounter.setEncounterDiagnosis(unprocessedDiagnosis);
			encounter.setDoctorNotes(unprocessedDoctorNotes);
			encounter.setNurseNotes(unprocessedNurseNotes);
		}

		return unprocessed;
	}

}
