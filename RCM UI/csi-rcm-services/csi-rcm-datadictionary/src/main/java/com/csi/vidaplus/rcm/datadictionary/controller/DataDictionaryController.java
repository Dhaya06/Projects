/*
 * %W% %E% Firstname Lastname
 *
 * Copyright (c) 1993-1996 Sun Microsystems, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Sun
 * Microsystems, Inc. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 *
 * SUN MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
 * THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 * TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE, OR NON-INFRINGEMENT. SUN SHALL NOT BE LIABLE FOR
 * ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */
package com.csi.vidaplus.rcm.datadictionary.controller;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.DuplicateKeyException;
import com.csi.vidaplus.rcm.datadictionary.document.DataDictionary;
import com.csi.vidaplus.rcm.datadictionary.protocol.RequestEnvelope;
import com.csi.vidaplus.rcm.datadictionary.protocol.ResponseEnvelope;
import com.csi.vidaplus.rcm.datadictionary.service.DataDictionaryService;
import com.csi.vidaplus.rcm.datadictionary.service.SequenceGeneratorService;
import com.csi.vidaplus.rcm.datadictionary.util.Constants;
import com.csi.vidaplus.rcm.datadictionary.util.exception.DataNotFoundException;
import com.csi.vidaplus.rcm.datadictionary.util.exception.InvalidInputException;

/**
 * This class contains the common end points related to data dictionary
 * 
 * @version 1.0 12 Jan 2018
 * @author Mohomad Nusky
 */
@Api(basePath = "/ ", value = "Data Dictionary", description = "All services related to data dictionary", produces = "application/json")
@RestController
@CrossOrigin
public class DataDictionaryController {
	private static Logger logger = LogManager.getLogger(DataDictionaryController.class);

	@Autowired
	private DataDictionaryService dataDictionaryService;
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	@Autowired
	private ObjectMapper objectMapper;

	@GetMapping("/getStatus")
	public ResponseEntity<String> getStatus() {
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	/**
	 * add data dictionary by specifying type and data in requestEnvelope
	 * 
	 * @param requestEnvelope
	 * @return ResponseEntity<ResponseEnvelope>
	 */
	@ApiOperation(value = "add", notes = "This is common builder to add data dictionary by specifying type and body.")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 400, message = "Failed to save data due to invalid Input or Constraint violations"),
			@ApiResponse(code = 500, message = "Failed to save data due to requested type cannot be map to a model") })
	@PostMapping("/add")
	public ResponseEntity<ResponseEnvelope> add(@RequestBody RequestEnvelope requestEnvelope) {
		ResponseEnvelope responseEnvelope = null;
		// validate data dictionary type for null and empty
		validateNullEmpty(requestEnvelope.getType());
		try {
			DataDictionary dataDictionary = (DataDictionary) objectMapper.convertValue(requestEnvelope.getBody(),
					Class.forName(Constants.DATA_DICTIONARY_PACKAGE_PREFIX + requestEnvelope.getType().trim()));
			dataDictionaryService.add(dataDictionary);
			responseEnvelope = new ResponseEnvelope(HttpStatus.CREATED, Constants.DATA_DICTIONARY_ADD_SUCCESS);
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			return handleClassNotFound(ex);
		}
		return new ResponseEntity<>(responseEnvelope, new HttpHeaders(), responseEnvelope.getStatus());
	}

	/**
	 * update data dictionary by specifying type and data in requestEnvelope
	 * 
	 * @param requestEnvelope
	 * @return ResponseEntity<ResponseEnvelope>
	 */
	@ApiOperation(value = "update", notes = "This is the common builder to update data dictionary by type")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Updated"),
			@ApiResponse(code = 400, message = "Failed to update data due to invalid Input or Constraint violations"),
			@ApiResponse(code = 500, message = "Failed to update data due to requested type cannot be map to a model") })
	@PutMapping("/update")
	public ResponseEntity<ResponseEnvelope> update(@RequestBody RequestEnvelope requestEnvelope) {
		ResponseEnvelope responseEnvelope = null;
		// validate data dictionary type for null and empty
		validateNullEmpty(requestEnvelope.getType());
		try {
			DataDictionary dataDictionary = (DataDictionary) objectMapper.convertValue(requestEnvelope.getBody(),
					Class.forName(Constants.DATA_DICTIONARY_PACKAGE_PREFIX + requestEnvelope.getType().trim()));
			dataDictionaryService.edit(dataDictionary);
			responseEnvelope = new ResponseEnvelope(HttpStatus.OK, Constants.DATA_DICTIONARY_EDIT_SUCCESS);
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			return handleClassNotFound(ex);
		}
		return new ResponseEntity<>(responseEnvelope, new HttpHeaders(), responseEnvelope.getStatus());
	}

	/**
	 * delete data dictionary by specifying type and primary id
	 * 
	 * @param type
	 * @param id
	 * @return ResponseEntity<ResponseEnvelope>
	 */
	@ApiOperation(value = "delete", notes = "Common interface to delete data dictionary by id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Deleted"),
			@ApiResponse(code = 400, message = "Failed to delete data due to invalid Input or Constraint violations"),
			@ApiResponse(code = 500, message = "Failed to delete data due to requested type cannot be map to a model") })
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseEnvelope> delete(@RequestParam String type, @RequestParam String id) {
		ResponseEnvelope responseEnvelope = null;
		// validate data dictionary type for null and empty
		validateNullEmpty(type);
		// validate id for null and empty
		validateNullEmpty(id);
		try {
			Class aClass = Class.forName(Constants.DATA_DICTIONARY_PACKAGE_PREFIX + type);
			dataDictionaryService.delete(id, aClass);
			responseEnvelope = new ResponseEnvelope(HttpStatus.OK, Constants.DATA_DICTIONARY_DELETE_SUCCESS);
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			return handleClassNotFound(ex);
		}
		return new ResponseEntity<>(responseEnvelope, new HttpHeaders(), responseEnvelope.getStatus());
	}

	/**
	 * get all data dictionary related to a type
	 * 
	 * @param type
	 * @return RequestEnvelope<DataDictionary>
	 */
	@ApiOperation(value = "getAll", notes = "Get All data dictionary by type")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Retrieved All"),
			@ApiResponse(code = 204, message = "No data found for the requested type"),
			@ApiResponse(code = 500, message = "Failed to retrieve data due to requested type cannot be map to a model") })
	@GetMapping("/getAll")
	public ResponseEntity<ResponseEnvelope> getAll(@RequestParam String type) {
		ResponseEnvelope responseEnvelope = null;
		// validate data dictionary type for null and empty
		validateNullEmpty(type);
		try {
			Class aClass = Class.forName(Constants.DATA_DICTIONARY_PACKAGE_PREFIX + type);
			List<DataDictionary> dataDictionaryList = dataDictionaryService.getAll(aClass);
			// validate data dictionary response
			validateResponseData(dataDictionaryList, type);
			responseEnvelope = new ResponseEnvelope(HttpStatus.OK, Constants.DATA_DICTIONARY_GET_SUCCESS);
			responseEnvelope.setBody(dataDictionaryList);
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			return handleClassNotFound(ex);
		}
		return new ResponseEntity<>(responseEnvelope, HttpStatus.OK);
	}

	/**
	 * Get data dictionary by specifying type and primary id
	 * 
	 * @param type
	 * @param id
	 * @return ResponseEntity<ResponseEnvelope>
	 */
	@ApiOperation(value = "getById", notes = "Common interface to get All data dictionary by type and Id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Retrieved by Id"),
			@ApiResponse(code = 204, message = "No data found for the requested type"),
			@ApiResponse(code = 500, message = "Failed to retrieve data due to requested type cannot be map to a model") })
	@GetMapping("/getById")
	public ResponseEntity<ResponseEnvelope> getById(@RequestParam String type, @RequestParam String id) {
		ResponseEnvelope responseEnvelope = null;
		// validate data dictionary type for null and empty
		validateNullEmpty(type);
		// validate request type
		validateNullEmpty(id);
		try {
			Class aClass = Class.forName(Constants.DATA_DICTIONARY_PACKAGE_PREFIX + type);
			DataDictionary dataDictionary = dataDictionaryService.getById(id, aClass);
			// validate data dictionary response
			validateResponseData(dataDictionary, type);
			responseEnvelope = new ResponseEnvelope(HttpStatus.OK, Constants.DATA_DICTIONARY_GET_SUCCESS, dataDictionary);
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			return handleClassNotFound(ex);
		}
		return new ResponseEntity<>(responseEnvelope, new HttpHeaders(), responseEnvelope.getStatus());
	}

	/**
	 * Get data dictionary by specifying type , field and value
	 * 
	 * @param type
	 * @param searchField
	 * @param searchValue
	 * @return RequestEnvelope<DataDictionary>
	 */
	@ApiOperation(value = "getAllByField", notes = "Get All data dictionary by type and field")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Retrieved by field"),
			@ApiResponse(code = 204, message = "No data found for the requested type"),
			@ApiResponse(code = 500, message = "Failed to retrieve data due to requested type cannot be map to a model") })
	@GetMapping("/getAllByField")
	public ResponseEntity<ResponseEnvelope> getAllByField(@RequestParam String type, @RequestParam String searchField,
			@RequestParam String searchValue) {
		ResponseEnvelope responseEnvelope = null;
		// validate data dictionary type for null and empty
		validateNullEmpty(type);
		// validate search field
		validateNullEmpty(searchField);
		// validate search value
		validateNullEmpty(searchValue);
		try {
			Class aClass = Class.forName(Constants.DATA_DICTIONARY_PACKAGE_PREFIX + type);
			List<DataDictionary> dataDictionaryList = dataDictionaryService.getAllByField(aClass, searchField, searchValue);
			// validate data dictionary response
			validateResponseData(dataDictionaryList, type);
			responseEnvelope = new ResponseEnvelope(HttpStatus.OK, Constants.DATA_DICTIONARY_GET_SUCCESS);
			responseEnvelope.setBody(dataDictionaryList);
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			return handleClassNotFound(ex);
		}
		return new ResponseEntity<>(responseEnvelope, new HttpHeaders(), responseEnvelope.getStatus());
	}

	/**
	 * Get data dictionary by specifying type and regex
	 * 
	 * @param type
	 * @param searchField
	 * @param searchValue
	 * @return ResponseEntity<ResponseEnvelope>
	 */
	@ApiOperation(value = "getAllByRegex", notes = "Get All data dictionary by type and field regex")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Retrieved by field regex"),
			@ApiResponse(code = 204, message = "No data found for the requested type"),
			@ApiResponse(code = 500, message = "Failed to retrieve data due to requested type cannot be map to a model") })
	@GetMapping("/getAllByRegex")
	public ResponseEntity<ResponseEnvelope> getAllByRegex(@RequestParam String type, @RequestParam String searchField,
			@RequestParam String searchValue) {
		ResponseEnvelope responseEnvelope = null;
		// validate data dictionary type for null and empty
		validateNullEmpty(type);
		// validate search field
		validateNullEmpty(searchField);
		// validate search value
		validateNullEmpty(searchValue);
		try {
			Class aClass = Class.forName(Constants.DATA_DICTIONARY_PACKAGE_PREFIX + type);
			List<DataDictionary> dataDictionaryList = dataDictionaryService.getAllByRegex(aClass, searchField, searchValue);
			// validate data dictionary response
			validateResponseData(dataDictionaryList, type);
			responseEnvelope = new ResponseEnvelope(HttpStatus.OK, Constants.DATA_DICTIONARY_GET_SUCCESS);
			responseEnvelope.setBody(dataDictionaryList);
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			return handleClassNotFound(ex);
		}
		return new ResponseEntity<>(responseEnvelope, new HttpHeaders(), responseEnvelope.getStatus());
	}

	/**
	 * validate null or empty
	 * 
	 * @param value
	 */
	private void validateNullEmpty(String value) {
		if (value == null || "".equals(value)) {
			logger.error("Invalid Input:" + value);
			throw new InvalidInputException(value);
		}
	}

	/**
	 * Validate Response data size and null
	 * 
	 * @param dataDictionaryList
	 * @param type
	 */
	private void validateResponseData(List<DataDictionary> dataDictionaryList, String type) {
		if (dataDictionaryList == null || dataDictionaryList.size() == 0) {
			logger.error("Data Not Found for the type:" + type);
			throw new DataNotFoundException(dataDictionaryList, type);
		}
	}

	/**
	 * Validate whether Response data is null
	 * 
	 * @param dataDictionary
	 * @param type
	 */
	private void validateResponseData(DataDictionary dataDictionary, String type) {
		if (dataDictionary == null) {
			logger.error("Data Not Found for the type:" + type);
			throw new DataNotFoundException(dataDictionary, type);
		}
	}

	/**
	 * This to handle constraint violation exception occurred during persistence
	 * 
	 * @param ex
	 * @return ResponseEntity<ResponseEnvelope>
	 */
	private ResponseEntity<ResponseEnvelope> handleClassNotFound(ClassNotFoundException ex) {

		String errorMessage = "Requested data dictionary type cannot map to a model. Please check the input";
		logger.error(errorMessage, ex);
		ResponseEnvelope responseEnvelope = new ResponseEnvelope(HttpStatus.NOT_FOUND, errorMessage, errorMessage);
		return new ResponseEntity<>(responseEnvelope, new HttpHeaders(), responseEnvelope.getStatus());
	}

	/**
	 * This to handle duplicate record exception occurred during persistence
	 * 
	 * @param dke
	 * @param type
	 * @param seq
	 * @return String which contains the cause
	 */
	private String handleDuplicateRecord(DuplicateKeyException dke, String type, int seq) {
		logger.error("Duplicate Record", dke);
		// reset the counter
		sequenceGeneratorService.createOrResetSequence(type, seq);
		return "-1|" + dke.getLocalizedMessage();
	}
}