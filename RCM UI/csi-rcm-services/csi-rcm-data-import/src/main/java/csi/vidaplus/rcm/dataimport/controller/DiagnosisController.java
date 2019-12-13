package csi.vidaplus.rcm.dataimport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.csi.microservices.base.service.BaseService;

import csi.vidaplus.rcm.dataimport.model.EncounterDiagnosis;
import csi.vidaplus.rcm.dataimport.service.EncounterDiagnosisService;

@RestController
@RequestMapping("/rcm/import/encounterdiagnosis")
public class DiagnosisController extends BaseService {

	@Autowired
	private EncounterDiagnosisService diagnosisService;

	@PostMapping
	public ResponseEntity<List<EncounterDiagnosis>> importEncounterDiagnosis(
			@RequestBody List<EncounterDiagnosis> encounterDiagnosis) {

		List<EncounterDiagnosis> insertedDiagnosis = diagnosisService.insert(encounterDiagnosis);

		return new ResponseEntity<List<EncounterDiagnosis>>(insertedDiagnosis, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<List<EncounterDiagnosis>> updateEncounterDiagnosis(
			@RequestBody List<EncounterDiagnosis> encounterDiagnosis) {

		List<EncounterDiagnosis> insertedDiagnosis = diagnosisService.update(encounterDiagnosis);

		return new ResponseEntity<List<EncounterDiagnosis>>(insertedDiagnosis, HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<List<EncounterDiagnosis>> deleteEncounterDiagnosis(@RequestParam("ids") List<String> ids) {

		List<EncounterDiagnosis> deletedEncounters = diagnosisService.delete(ids);

		return new ResponseEntity<List<EncounterDiagnosis>>(deletedEncounters, HttpStatus.OK);
	}

}
