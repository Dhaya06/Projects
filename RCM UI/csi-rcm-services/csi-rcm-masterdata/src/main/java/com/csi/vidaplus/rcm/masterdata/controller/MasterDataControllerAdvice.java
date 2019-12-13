package com.csi.vidaplus.rcm.masterdata.controller;

import com.csi.vidaplus.rcm.masterdata.protocol.ResponseEnvelope;
import com.csi.vidaplus.rcm.masterdata.util.exception.DataNotFoundException;
import com.csi.vidaplus.rcm.masterdata.util.exception.InvalidInputException;
import com.mongodb.DuplicateKeyException;
import com.mongodb.MongoSocketOpenException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class all the run time exceptions related to MasterDataController
 * 
 * @version 1.0 12 Jan 2018
 * @author Firstname Lastname
 */
@ControllerAdvice(basePackageClasses = MasterDataController.class)
@RequestMapping(produces = "application/json")
public class MasterDataControllerAdvice extends ResponseEntityExceptionHandler {

	/**
	 * This handle the consttaint violation exception
	 * 
	 * @param ex
	 *            exception
	 * @param request
	 *            Request
	 * @return ResponseEntity<ResponseEnvelope>
	 */
	@ExceptionHandler({ ConstraintViolationException.class })
	public ResponseEntity<ResponseEnvelope> handleConstraintViolation(ConstraintViolationException ex,
			WebRequest request) {
		List<String> errors = new ArrayList<>();
		for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
			errors.add(violation.getMessage());
		}
		ResponseEnvelope responseEnvelope = new ResponseEnvelope(HttpStatus.BAD_REQUEST, "Input Constraints Violated",
				errors);
		return new ResponseEntity<>(responseEnvelope, new HttpHeaders(), responseEnvelope.getStatus());
	}

	/**
	 * This handle the class not found exception
	 * 
	 * @param ex
	 *            ClassNotFoundException
	 * @param request
	 * @return ResponseEntity<ResponseEnvelope>
	 */
	@ExceptionHandler({ ClassNotFoundException.class })
	protected ResponseEntity<ResponseEnvelope> handleClassNotFound(ClassNotFoundException ex, WebRequest request) {
		String error = "Class Not Found";
		ResponseEnvelope responseEnvelope = new ResponseEnvelope(HttpStatus.NOT_FOUND, ex.getLocalizedMessage(), error);
		return new ResponseEntity<>(responseEnvelope, new HttpHeaders(), responseEnvelope.getStatus());
	}

	/**
	 * This handle the invalid input from the client
	 * 
	 * @param ex
	 *            InvalidInputException
	 * @param request
	 * @return ResponseEntity<ResponseEnvelope>
	 */
	@ExceptionHandler({ InvalidInputException.class })
	protected ResponseEntity<ResponseEnvelope> handleInvalidInput(InvalidInputException ex, WebRequest request) {
		String error = ex.getMessage();
		ResponseEnvelope responseEnvelope = new ResponseEnvelope(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),
				error);
		return new ResponseEntity<>(responseEnvelope, new HttpHeaders(), responseEnvelope.getStatus());
	}

	/**
	 * This handle the no data or content
	 * 
	 * @param ex
	 *            InvalidInputException
	 * @param request
	 *            DataNotFoundException
	 * @return ResponseEntity<ResponseEnvelope>
	 */
	@ExceptionHandler({ DataNotFoundException.class })
	protected ResponseEntity<ResponseEnvelope> handleNoResponseData(DataNotFoundException ex, WebRequest request) {
		String error = ex.getMessage();
		ResponseEnvelope responseEnvelope = new ResponseEnvelope(HttpStatus.NOT_FOUND, ex.getLocalizedMessage(),
				error);
		return new ResponseEntity<>(responseEnvelope, new HttpHeaders(), responseEnvelope.getStatus());
	}

	/**
	 * This handle all the unchecked exceptions
	 * 
	 * @param ex
	 * @param request
	 * @return ResponseEntity<ResponseEnvelope>
	 */
	@ExceptionHandler({ ConnectException.class, MongoSocketOpenException.class,
			DataAccessResourceFailureException.class })
	protected ResponseEntity<ResponseEnvelope> handleConnectionException(ConnectException ex, WebRequest request) {
		String error = "Database Connection Failure";
		ResponseEnvelope responseEnvelope = new ResponseEnvelope(HttpStatus.INTERNAL_SERVER_ERROR,
				"Database Connection Failure", error);
		return new ResponseEntity<>(responseEnvelope, new HttpHeaders(), responseEnvelope.getStatus());
	}

	/**
	 * This handle all the unchecked exceptions
	 *
	 * @param ex
	 * @param request
	 * @return ResponseEntity<ResponseEnvelope>
	 */
	@ExceptionHandler({DuplicateKeyException.class})
	protected ResponseEntity<ResponseEnvelope> handleDuplicateKey(ConnectException ex, WebRequest request) {
		String error = "Duplicate Key";
		ResponseEnvelope responseEnvelope = new ResponseEnvelope(HttpStatus.BAD_REQUEST,
				"Duplicate Key", error);
		return new ResponseEntity<>(responseEnvelope, new HttpHeaders(), responseEnvelope.getStatus());
	}

	/**
	 * This handle all the unchecked exceptions
	 * 
	 * @param ex
	 *            Exception
	 * @param request
	 * @return ResponseEntity<ResponseEnvelope>
	 */
	@ExceptionHandler({ Exception.class })
	protected ResponseEntity<ResponseEnvelope> handleUncheckedException(Exception ex, WebRequest request) {
		String error = "Master Data Exception occurred";
		ResponseEnvelope responseEnvelope = new ResponseEnvelope(HttpStatus.INTERNAL_SERVER_ERROR,
				ex.getLocalizedMessage(), error);
		return new ResponseEntity<>(responseEnvelope, new HttpHeaders(), responseEnvelope.getStatus());
	}

}