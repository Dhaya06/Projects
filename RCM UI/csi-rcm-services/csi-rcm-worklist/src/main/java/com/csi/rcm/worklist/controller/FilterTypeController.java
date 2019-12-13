package com.csi.rcm.worklist.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csi.microservices.base.service.BaseService;
import com.csi.rcm.worklist.model.FilterType;
import com.csi.rcm.worklist.service.FilterTypeService;

import io.swagger.annotations.ApiOperation;

/**
 * Controller class for FilterType
 * 
 * @author Kasun
 * @version 1.0
 * @since 2018/01/27
 *
 */
@RestController
@RequestMapping("filtertype")
@CrossOrigin
public class FilterTypeController extends BaseService{

	@Autowired
	private FilterTypeService filterTypeService;
	
	@PostMapping
	@ApiOperation(value = "This api is used to create FilterTypes")
	public ResponseEntity<HttpStatus> save(@RequestBody @Valid FilterType filterType){
		filterTypeService.save(filterType);
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
	
	
	@PutMapping
	@ApiOperation(value = "This api is used to update FilterTypes")
	public ResponseEntity<HttpStatus> update(@RequestBody @Valid FilterType filterType){
		filterTypeService.update(filterType);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
}
