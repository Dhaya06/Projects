package com.csi.rcm.minimumdata.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csi.microservices.base.service.BaseService;
import com.csi.rcm.minimumdata.model.FieldType;
import com.csi.rcm.minimumdata.service.FieldTypeService;

import io.swagger.annotations.ApiOperation;

/**
 * Controller class for FieldType
 * 
 * @author Kasun
 * @version 1.0
 * @since 2018/01/23
 *
 */
@RestController
@RequestMapping("/fieldtype")
public class FieldTypeController extends BaseService {

	@Autowired
	private FieldTypeService typeService;
	
	@PostMapping
	@ApiOperation(value = "This api gives option to create new FieldTypes")
	public ResponseEntity<HttpStatus> save(@RequestBody @Valid FieldType fieldType) {
		typeService.save(fieldType);
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
	
	@PutMapping
	@ApiOperation(value = "This api gives option to update new FieldTypes")
	public ResponseEntity<HttpStatus> update(@RequestBody @Valid FieldType fieldType) {
		typeService.update(fieldType);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	
	@GetMapping
	@ApiOperation(value = "This api gives option to gte all the FieldTypes")
	public ResponseEntity<List<FieldType>> getAll() {
		List<FieldType> allFieldTypes = typeService.getAll();
		return new ResponseEntity<List<FieldType>>(allFieldTypes,HttpStatus.OK);
	}
}
