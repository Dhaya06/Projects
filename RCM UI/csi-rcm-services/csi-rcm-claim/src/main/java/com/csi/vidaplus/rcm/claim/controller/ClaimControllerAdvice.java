package com.csi.vidaplus.rcm.claim.controller;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.PersistenceException;


/**
 * This class all the run time exceptions related to MasterDataController
 * 
 * @version 1.0 12 Jan 2018
 * @author Firstname Lastname
 */
@ControllerAdvice(basePackageClasses =ClaimController.class)
@RequestMapping(produces = "application/json")
public class ClaimControllerAdvice extends ResponseEntityExceptionHandler {



	/**
	 * This handle all the unchecked exceptions
	 * 
	 * @param ex
	 *            Exception
	 * @param request
	 * @return ResponseEntity<ResponseEnvelope>
	 */
	@ExceptionHandler({ Exception.class })
	protected ResponseEntity<HttpStatus> handleUncheckedException(Exception ex, WebRequest request) {
		String error = "Master Data Exception occurred";
		return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * This handle all the persistence exceptions
	 *
	 * @param ex
	 *            Exception
	 * @param request
	 * @return ResponseEntity<ResponseEnvelope>
	 */
	@ExceptionHandler({ PersistenceException.class })
	protected ResponseEntity<HttpStatus> handleClassNotFound(ClassNotFoundException ex, WebRequest request) {
		return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}