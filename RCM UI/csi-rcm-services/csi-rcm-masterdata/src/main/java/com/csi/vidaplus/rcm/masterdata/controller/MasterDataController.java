package com.csi.vidaplus.rcm.masterdata.controller;

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
import com.csi.vidaplus.rcm.masterdata.service.MasterDataService;
import com.csi.vidaplus.rcm.masterdata.util.Constants;
import com.csi.vidaplus.rcm.masterdata.protocol.RequestEnvelope;
import com.csi.vidaplus.rcm.masterdata.document.MasterData;
import com.csi.vidaplus.rcm.masterdata.service.SequenceGeneratorService;
import com.csi.vidaplus.rcm.masterdata.protocol.ResponseEnvelope;
import com.csi.vidaplus.rcm.masterdata.util.exception.DataNotFoundException;
import com.csi.vidaplus.rcm.masterdata.util.exception.InvalidInputException;

/**
 * This class contains the common end points related to master data
 * 
 * @version 1.0 12 Jan 2018
 * @author Ahsan Shamsudeen
 */
@Api(basePath = "/ ", value = "Master Data", description = "All services related to Master Data", produces = "application/json")
@RestController
@CrossOrigin
public class MasterDataController {
	private static Logger logger = LogManager.getLogger(MasterDataController.class);

	@Autowired
	private MasterDataService masterDataService;
	@Autowired
	SequenceGeneratorService sequenceGeneratorService;
	@Autowired
	private ObjectMapper objectMapper;

	@GetMapping("/getStatus")
	public ResponseEntity<String> getStatus() {
		System.out.println("request received");
		return new ResponseEntity<>("success", new HttpHeaders(), HttpStatus.OK);
	}

	/*@GetMapping("/getMaxDiscount")
	public ResponseEntity<Double> getMaxDiscount() {
		System.out.println("request received");
		return new ResponseEntity<Double>(10.0, new HttpHeaders(), HttpStatus.OK);
	}*/

	/**
	 * add master by specifying type and data in requestEnvelope
	 * 
	 * @param requestEnvelope
	 * @return ResponseEntity<ResponseEnvelope>
	 */
	@ApiOperation(value = "add", notes = "This is common builder to add master data by specifying type and body.")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 400, message = "Failed to save data due to invalid Input or Constraint violations"),
			@ApiResponse(code = 500, message = "Failed to save data due to requested type cannot be map to a model") })
	@PostMapping("/add")
	public ResponseEntity<ResponseEnvelope> add(@RequestBody RequestEnvelope requestEnvelope) {
		ResponseEnvelope responseEnvelope = null;
		// validate master data type for null and empty
		validateNullEmpty(requestEnvelope.getType());
		try {
			MasterData masterData = (MasterData) objectMapper.convertValue(requestEnvelope.getBody(),
					Class.forName(Constants.MASTER_DATA_PACKAGE_PREFIX + requestEnvelope.getType().trim()));
			masterDataService.add(masterData);
			responseEnvelope = new ResponseEnvelope(HttpStatus.CREATED, Constants.MASTER_DATA_ADD_SUCCESS);
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			return handleClassNotFound(ex);
		}
		return new ResponseEntity<>(responseEnvelope, new HttpHeaders(), responseEnvelope.getStatus());
	}

	/**
	 * update master by specifying type and data in requestEnvelope
	 * 
	 * @param requestEnvelope
	 * @return ResponseEntity<ResponseEnvelope>
	 */
	@ApiOperation(value = "update", notes = "This is the common builder to update Master Data by type")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Updated"),
			@ApiResponse(code = 400, message = "Failed to update data due to invalid Input or Constraint violations"),
			@ApiResponse(code = 500, message = "Failed to update data due to requested type cannot be map to a model") })
	@PutMapping("/update")
	public ResponseEntity<ResponseEnvelope> update(@RequestBody RequestEnvelope requestEnvelope) {
		ResponseEnvelope responseEnvelope = null;
		// validate master data type for null and empty
		validateNullEmpty(requestEnvelope.getType());
		try {
			MasterData masterData = (MasterData) objectMapper.convertValue(requestEnvelope.getBody(),
					Class.forName(Constants.MASTER_DATA_PACKAGE_PREFIX + requestEnvelope.getType().trim()));
			masterDataService.edit(masterData);
			responseEnvelope = new ResponseEnvelope(HttpStatus.OK, Constants.MASTER_DATA_EDIT_SUCCESS);
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			return handleClassNotFound(ex);
		}
		return new ResponseEntity<>(responseEnvelope, new HttpHeaders(), responseEnvelope.getStatus());
	}

	/**
	 * delete master data by specifying type and primary id
	 * 
	 * @param type
	 * @param id
	 * @return ResponseEntity<ResponseEnvelope>
	 */
	@ApiOperation(value = "delete", notes = "Common interface to delete master data by id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Deleted"),
			@ApiResponse(code = 400, message = "Failed to delete data due to invalid Input or Constraint violations"),
			@ApiResponse(code = 500, message = "Failed to delete data due to requested type cannot be map to a model") })
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseEnvelope> delete(@RequestParam String type, @RequestParam String id) {
		ResponseEnvelope responseEnvelope = null;
		// validate master data type for null and empty
		validateNullEmpty(type);
		// validate id for null and empty
		validateNullEmpty(id);
		try {
			Class aClass = Class.forName(Constants.MASTER_DATA_PACKAGE_PREFIX + type);
			masterDataService.delete(id, aClass);
			responseEnvelope = new ResponseEnvelope(HttpStatus.OK, Constants.MASTER_DATA_DELETE_SUCCESS);
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			return handleClassNotFound(ex);
		}
		return new ResponseEntity<>(responseEnvelope, new HttpHeaders(), responseEnvelope.getStatus());
	}

	/**
	 * get all master data related to a type
	 * 
	 * @param type
	 * @return RequestEnvelope<MasterData>
	 */
	@ApiOperation(value = "getAll", notes = "Get All master Data by type")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Retrieved All"),
			@ApiResponse(code = 204, message = "No data found for the requested type"),
			@ApiResponse(code = 500, message = "Failed to retrieve data due to requested type cannot be map to a model") })
	@GetMapping("/getAll")
	public ResponseEntity<ResponseEnvelope> getAll(@RequestParam String type) {
		ResponseEnvelope responseEnvelope = null;
		// validate master data type for null and empty
		validateNullEmpty(type);
		try {
			Class aClass = Class.forName(Constants.MASTER_DATA_PACKAGE_PREFIX + type);
			List<MasterData> masterDataList = masterDataService.getAll(aClass);
			// validate master data response
			validateResponseData(masterDataList, type);
			responseEnvelope = new ResponseEnvelope(HttpStatus.OK, Constants.MASTER_DATA_GET_SUCCESS);
			responseEnvelope.setBody(masterDataList);
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			return handleClassNotFound(ex);
		}
		return new ResponseEntity<>(responseEnvelope, HttpStatus.OK);
	}

	/**
	 * Get master data by specifying type and primary id
	 * 
	 * @param type
	 * @param id
	 * @return ResponseEntity<ResponseEnvelope>
	 */
	@ApiOperation(value = "getById", notes = "Common interface to get All master Data by type and Id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Retrieved by Id"),
			@ApiResponse(code = 204, message = "No data found for the requested type"),
			@ApiResponse(code = 500, message = "Failed to retrieve data due to requested type cannot be map to a model") })
	@GetMapping("/getById")
	public ResponseEntity<ResponseEnvelope> getById(@RequestParam String type, @RequestParam String id) {
		ResponseEnvelope responseEnvelope = null;
		// validate master data type for null and empty
		validateNullEmpty(type);
		// validate request type
		validateNullEmpty(id);
		try {
			Class aClass = Class.forName(Constants.MASTER_DATA_PACKAGE_PREFIX + type);
			MasterData masterData = masterDataService.getById(id, aClass);
			// validate master data response
			validateResponseData(masterData, type);
			responseEnvelope = new ResponseEnvelope(HttpStatus.OK, Constants.MASTER_DATA_GET_SUCCESS, masterData);
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			return handleClassNotFound(ex);
		}
		return new ResponseEntity<>(responseEnvelope, new HttpHeaders(), responseEnvelope.getStatus());
	}

	/**
	 * Get master data by specifying type , field and value
	 * 
	 * @param type
	 * @param searchField
	 * @param searchValue
	 * @return RequestEnvelope<MasterData>
	 */
	@ApiOperation(value = "getAllByField", notes = "Get All master Data by type and field")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Retrieved by field"),
			@ApiResponse(code = 204, message = "No data found for the requested type"),
			@ApiResponse(code = 500, message = "Failed to retrieve data due to requested type cannot be map to a model") })
	@GetMapping("/getAllByField")
	public ResponseEntity<ResponseEnvelope> getAllByField(@RequestParam String type, @RequestParam String searchField,
			@RequestParam String searchValue) {
		ResponseEnvelope responseEnvelope = null;
		// validate master data type for null and empty
		validateNullEmpty(type);
		// validate search field
		validateNullEmpty(searchField);
		// validate search value
		validateNullEmpty(searchValue);
		try {
			Class aClass = Class.forName(Constants.MASTER_DATA_PACKAGE_PREFIX + type);
			List<MasterData> masterDataList = masterDataService.getAllByField(aClass, searchField, searchValue);
			// validate master data response
			validateResponseData(masterDataList, type);
			responseEnvelope = new ResponseEnvelope(HttpStatus.OK, Constants.MASTER_DATA_GET_SUCCESS);
			responseEnvelope.setBody(masterDataList);
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			return handleClassNotFound(ex);
		}
		return new ResponseEntity<>(responseEnvelope, new HttpHeaders(), responseEnvelope.getStatus());
	}

	/**
	 * Get master data by specifying type and regex
	 * 
	 * @param type
	 * @param searchField
	 * @param searchValue
	 * @return ResponseEntity<ResponseEnvelope>
	 */
	@ApiOperation(value = "getAllByRegex", notes = "Get All master Data by type and field regex")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Retrieved by field regex"),
			@ApiResponse(code = 204, message = "No data found for the requested type"),
			@ApiResponse(code = 500, message = "Failed to retrieve data due to requested type cannot be map to a model") })
	@GetMapping("/getAllByRegex")
	public ResponseEntity<ResponseEnvelope> getAllByRegex(@RequestParam String type, @RequestParam String searchField,
			@RequestParam String searchValue) {
		ResponseEnvelope responseEnvelope = null;
		// validate master data type for null and empty
		validateNullEmpty(type);
		// validate search field
		validateNullEmpty(searchField);
		// validate search value
		validateNullEmpty(searchValue);
		try {
			Class aClass = Class.forName(Constants.MASTER_DATA_PACKAGE_PREFIX + type);
			List<MasterData> masterDataList = masterDataService.getAllByRegex(aClass, searchField, searchValue);
			// validate master data response
			validateResponseData(masterDataList, type);
			responseEnvelope = new ResponseEnvelope(HttpStatus.OK, Constants.MASTER_DATA_GET_SUCCESS);
			responseEnvelope.setBody(masterDataList);
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
	 * @param masterDataList
	 * @param type
	 */
	private void validateResponseData(List<MasterData> masterDataList, String type) {
		if (masterDataList == null || masterDataList.size() == 0) {
			logger.error("Data Not Found for the type:" + type);
			throw new DataNotFoundException(masterDataList, type);
		}
	}

	/**
	 * Validate whether Response data is null
	 * 
	 * @param masterData
	 * @param type
	 */
	private void validateResponseData(MasterData masterData, String type) {
		if (masterData == null) {
			logger.error("Data Not Found for the type:" + type);
			throw new DataNotFoundException(masterData, type);
		}
	}

	/**
	 * This to handle constraint violation exception occurred during persistence
	 * 
	 * @param ex
	 * @return ResponseEntity<ResponseEnvelope>
	 */
	private ResponseEntity<ResponseEnvelope> handleClassNotFound(ClassNotFoundException ex) {

		String errorMessage = "Requested master data type cannot map to a model. Please check the input";
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