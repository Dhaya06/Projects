package com.csi.rcm.worklist.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csi.rcm.worklist.model.WorkList;
import com.csi.rcm.worklist.request.WorklistSearchModel;
import com.csi.rcm.worklist.service.WorkListService;

import io.swagger.annotations.ApiOperation;


/**
 * Controller class to manage worklists
 * 
 * @author Kasun
 * @version 1.0
 * @since 2018/01/27
 *
 */
@RestController
@RequestMapping()
@CrossOrigin
public class WorklistController {

	@Autowired
	private WorkListService workListService;
	
	@PostMapping
	@ApiOperation(value = "This api gives option to create new Worklist")
	public ResponseEntity<HttpStatus> save(@RequestBody @Valid WorkList workList){
		workListService.save(workList);
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
	
	
	@PutMapping
	@ApiOperation(value = "This api gives option to update Worklist")
	public ResponseEntity<HttpStatus> update(@RequestBody @Valid WorkList workList){
		workListService.update(workList);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	
	@GetMapping
	@ApiOperation(value = "This api gives option to all Worklists")
	public ResponseEntity<List<WorkList>> getAll(){
		return new ResponseEntity<List<WorkList>>(workListService.getAll(),HttpStatus.OK);
	}
	
	
	@GetMapping("{id}")
	@ApiOperation(value = "This api gives option to specific Worklists")
	public ResponseEntity<WorkList> getById(@PathVariable("id") Long id){
		return new ResponseEntity<WorkList>(workListService.getById(id),HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	@ApiOperation(value = "This api gives option to delete Worklist")
	public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") Long id){
		workListService.deleteById(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	
	@GetMapping("search")
	@ApiOperation(value = "This api gives option to search Worklists")
	public ResponseEntity<List<WorkList>> getSearch(WorklistSearchModel searchModel){
		return new ResponseEntity<List<WorkList>>(workListService.search(searchModel),HttpStatus.OK);
	}
	
	@GetMapping("name/{name}")
	@ApiOperation(value = "This api gives option to get Worklists from given name")
	public ResponseEntity<List<WorkList>> getById(@PathVariable("name") String name){
		return new ResponseEntity<List<WorkList>>(workListService.getWorklistByName(name),HttpStatus.OK);
	}
	
	@GetMapping("active")
	@ApiOperation(value = "This api gives option to get active Worklists")
	public ResponseEntity<List<WorkList>> getActiveWorklists(){
		return new ResponseEntity<List<WorkList>>(workListService.getActiveWorklist() ,HttpStatus.OK);
	}
	
}
