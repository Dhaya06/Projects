package csi.vidaplus.rcm.dataimport.service;

import java.util.List;

import csi.vidaplus.rcm.dataimport.model.Encounter;


public interface EncounterService {

	List<Encounter> insert(Iterable<Encounter> encounters);
	
	List<Encounter> update(Iterable<Encounter> encounters);
	
	List<Encounter> delete(List<String> ids);
	
	List<Encounter> getUnprocessedEncounter();
	
}
