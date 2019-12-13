package csi.vidaplus.rcm.dataimport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.csi.microservices.base.service.BaseService;

import csi.vidaplus.rcm.dataimport.feign.MinimumDataValidationService;
import csi.vidaplus.rcm.dataimport.model.Encounter;
import csi.vidaplus.rcm.dataimport.service.EncounterService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/rcm/import/encounter")
@RestController
public class EncounterController extends BaseService {

	@Autowired
	private EncounterService encounterService;

	@Autowired
	private MinimumDataValidationService dataValidationService;

	@PostMapping
	@ApiOperation(value = "This api gives the option to import encounters to RCM system. This operation will not do any validations "
			+ "other than basic type validation.", response = Encounter.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created", response = Encounter.class),
			@ApiResponse(code = 500, message = "Failed to save data") })
	public ResponseEntity<List<Encounter>> importEncounter(@RequestBody List<Encounter> encounters) {

		List<Encounter> insertedEncounters = encounterService.insert(encounters);

		dataValidationService.validateMinimumData();

		return new ResponseEntity<List<Encounter>>(insertedEncounters, HttpStatus.CREATED);
	}

	@PutMapping
	@ApiOperation("This api gives the option to update encounters that are already uploaded to RCM system. This operation will not do any validations "
			+ "other than basic type validation. encounter,Activity,Diagnosis should be send with the generated id. If no id provided then new record will be create")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Updated"),
			@ApiResponse(code = 500, message = "Failed to update data") })
	public ResponseEntity<List<Encounter>> updateEncounter(@RequestBody List<Encounter> encounters) {

		List<Encounter> insertencounters = encounterService.update(encounters);

		return new ResponseEntity<List<Encounter>>(insertencounters, HttpStatus.OK);
	}

	@GetMapping("unprocessed")
	public ResponseEntity<List<Encounter>> getUnprocessed() {

		List<Encounter> insertencounters = encounterService.getUnprocessedEncounter();

		return new ResponseEntity<List<Encounter>>(insertencounters, HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<List<Encounter>> deleteEncounter(@RequestParam("encounterIds") List<String> encounters) {

		List<Encounter> deletedEncounters = encounterService.delete(encounters);
		return new ResponseEntity<List<Encounter>>(deletedEncounters, HttpStatus.OK);
	}

}
