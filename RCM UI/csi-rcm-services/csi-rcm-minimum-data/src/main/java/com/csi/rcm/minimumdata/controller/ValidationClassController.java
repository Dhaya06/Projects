package com.csi.rcm.minimumdata.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csi.microservices.base.service.BaseService;
import com.csi.rcm.minimumdata.model.ValidationClass;
import com.csi.rcm.minimumdata.service.ValidationClassService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/validationclass")
public class ValidationClassController extends BaseService {

	@Autowired
	private ValidationClassService service;

	@PostMapping
	@ApiOperation(value = "This api give option to create Validation class. Validation class can contains all the values.")
	public ResponseEntity<HttpStatus> save(@RequestBody @Valid ValidationClass validationClass) {
		service.save(validationClass);
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}

	@PutMapping
	@ApiOperation(value = "This api give option to update Validation class and its child elements. To remove any values from these systemDefinedFields, additionalFields, attachments fields "
			+ "request should be send without the relevant value")
	public ResponseEntity<HttpStatus> update(@RequestBody @Valid ValidationClass validationClass) {
		service.update(validationClass);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@GetMapping
	@ApiOperation(value = "This api gives option to get all the ValidationClasses including child elements")
	public ResponseEntity<List<ValidationClass>> getAll() {
		return new ResponseEntity<List<ValidationClass>>(service.getAll(), HttpStatus.OK);
	}

	@GetMapping("{className}")
	@ApiOperation(value = "This api is used get specific Validation class, <b>className</b> should be the name of the validation classs")
	public ResponseEntity<ValidationClass> getByClassName(@PathVariable String className) {
		return new ResponseEntity<ValidationClass>(service.getByClassName(className), HttpStatus.OK);
	}

}
