package com.csi.vidaplus.rcm.masterdata.util.exception;

/**
 * Class to handle Invalid Input Exception
 *
 * @version 1.0 12 Jan 2018
 * @author Firstname Lastname
 */
public class InvalidInputException extends RuntimeException {
    private String value;
    private String field;

    public InvalidInputException(String value) {
        super("Requested type is Null or Empty: " + value);
        this.value = value;
    }

    public InvalidInputException(String  field,String value) {
        super("Invalid Field or value. Field:" +field +", Value:"+value);
        this.field = field;
        this.value = value;
    }
}