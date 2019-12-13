package com.csi.vidaplus.rcm.masterdata.protocol;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
/**
 * Generic class for the response
 *
 * @version 1.0 12 Jan 2018
 * @author Ahsan Shamsudeen
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseEnvelope<T> implements Serializable {
    private HttpStatus status;
    private String message;
    private T body;
    private List<String> errors;


    public ResponseEnvelope(HttpStatus status, String message, T body) {
        super();
        this.status = status;
        this.message = message;
        this.body = body;
    }

    public ResponseEnvelope(HttpStatus status, String message, List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public ResponseEnvelope(HttpStatus status, String message, String error) {
        super();
        this.status = status;
        this.message = message;
        errors = Arrays.asList(error);
    }

    public ResponseEnvelope(HttpStatus status, String message) {
        super();
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}