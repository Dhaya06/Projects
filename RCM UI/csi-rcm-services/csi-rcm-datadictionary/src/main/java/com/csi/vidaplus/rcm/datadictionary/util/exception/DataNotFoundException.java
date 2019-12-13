package com.csi.vidaplus.rcm.datadictionary.util.exception;

import java.util.List;

import com.csi.vidaplus.rcm.datadictionary.document.DataDictionary;

/**
 * Class to handle Data Not Found Exception
 *
 * @version 1.0 12 Jan 2018
 * @author Firstname Lastname
 */
public class DataNotFoundException extends RuntimeException {
	private List<DataDictionary> dataDictionaryList;
	private DataDictionary dataDictionary;
	private String type;

	public DataNotFoundException(List<DataDictionary> dataDictionaryList, String type) {
		super("Data Not Found for the type: " + type);
		this.dataDictionaryList = dataDictionaryList;
		this.type = type;
	}

	public DataNotFoundException(DataDictionary dataDictionary, String type) {
		super("Data Not Found for the type: " + type);
		this.dataDictionary = dataDictionary;
		this.type = type;
	}
}