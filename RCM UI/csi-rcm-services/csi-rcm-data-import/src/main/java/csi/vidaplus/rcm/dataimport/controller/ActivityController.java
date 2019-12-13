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

import csi.vidaplus.rcm.dataimport.model.EncounterActivity;
import csi.vidaplus.rcm.dataimport.service.EncounterActivityService;

@RestController
@RequestMapping("/rcm/import/encounteractivity")
public class ActivityController extends BaseService {

	@Autowired
	private EncounterActivityService activityService;

	@PostMapping
	public ResponseEntity<List<EncounterActivity>> importEncounterActivity(
			@RequestBody List<EncounterActivity> encounterActivities) {

		List<EncounterActivity> insertedActivities = activityService.insert(encounterActivities);

		return new ResponseEntity<List<EncounterActivity>>(insertedActivities, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<List<EncounterActivity>> updateEncounterActivity(
			@RequestBody List<EncounterActivity> encounterActivities) {

		List<EncounterActivity> updatedActivities = activityService.update(encounterActivities);

		return new ResponseEntity<List<EncounterActivity>>(updatedActivities, HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<List<EncounterActivity>> deleteEncounterActivity(@RequestParam("ids") List<String> ids) {

		List<EncounterActivity> deletedActivities = activityService.delete(ids);

		return new ResponseEntity<List<EncounterActivity>>(deletedActivities, HttpStatus.OK);
	}

}
