package csi.vidaplus.rcm.datavalidation.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csi.microservices.base.service.BaseService;

import csi.vidaplus.rcm.datavalidation.feign.EncounterImportService;
import csi.vidaplus.rcm.datavalidation.model.Encounter;
import csi.vidaplus.rcm.datavalidation.service.EncounterDataValidationService;

@RestController
@RequestMapping("/datavalidation")
public class MinimumDataValidationController extends BaseService {

	@Autowired
	private EncounterDataValidationService encounterValidationService;
	
	@Autowired
	private EncounterImportService dataImportService;
	
	@GetMapping
	public ResponseEntity<List<Encounter>> validateMinimumData() {

		List<Encounter> encounters = dataImportService.getUnprocessed();
		Set<Encounter> validateEncounters = encounterValidationService.validateEncounters(encounters);
		
		dataImportService.updateencounter(new ArrayList<>(validateEncounters));
		
		return new ResponseEntity<List<Encounter>>(encounters, HttpStatus.OK);
	}
	
}
