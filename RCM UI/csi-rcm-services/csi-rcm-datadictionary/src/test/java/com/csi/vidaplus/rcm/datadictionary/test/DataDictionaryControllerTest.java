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
package com.csi.vidaplus.rcm.datadictionary.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpStatus;
import org.hamcrest.CoreMatchers;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.csi.vidaplus.rcm.datadictionary.DataDictionaryApplication;
import com.csi.vidaplus.rcm.datadictionary.util.Constants;

/**
 * Test class for the data dictionary builder of RCM module.
 *
 * @version 1.0 12 Jan 2018
 * @author Mohomad Nusky
 */
public class DataDictionaryControllerTest {

	private static final String DB_URI = "mongodb://localhost:27017";
	private static final String DATABASE_NAME = "csi_rcm_data_dictionary";
	private static final String SERVICE_BASE_URI = "http://localhost";
	private static final int SERVICE_PORT = 8096;
	private static MongoClient mongoClient;
	private static DB database;
	private List<String> documentTypes = Arrays.asList("CPT_Codes", "ICD_Australian_Modification_Block", "ICD_Australian_Modification_Dictionary", 
														"ICD_Australian_Modification_Disease", "ICD_Australian_Modification_Morph", "ICD_WHO_Clinical_Modification_Map");
	private Map<String, String> searchIdValues = new HashMap<String, String>() {{
		put("CPT_Codes", "A6");
		put("ICD_Australian_Modification_Block", "6");
		put("ICD_Australian_Modification_Dictionary", "10");
		put("ICD_Australian_Modification_Disease", "A01.0");
		put("ICD_Australian_Modification_Morph", "M8001/3");
		put("ICD_WHO_Clinical_Modification_Map", "9"); 
	}};
	private Map<String, Map<String, String>> searchFieldValues = new HashMap<String, Map<String, String>>() {{
			put("CPT_Codes", new HashMap<String, String>() {{ put("cpt_description", "DRESSING FOR SIX WOUNDS"); }});
			put("ICD_Australian_Modification_Block", new HashMap<String, String>() {{ put("ascii_desc", "Intracranial drainage"); }});
			put("ICD_Australian_Modification_Dictionary", new HashMap<String, String>() {{ put("abbreviation", "simplx"); }});
			put("ICD_Australian_Modification_Disease", new HashMap<String, String>() {{ put("ascii_description", "Paratyphoid fever B"); }});
			put("ICD_Australian_Modification_Morph", new HashMap<String, String>() {{ put("full_description", "Neoplasm, malignant"); }});
			put("ICD_WHO_Clinical_Modification_Map", new HashMap<String, String>() {{ put("icd_10_who", "A01.1"); }});
		}};

	@BeforeClass
	public static void connectToDB() {
		mongoClient = new MongoClient(new MongoClientURI(DB_URI));
		database = mongoClient.getDB(DATABASE_NAME);
		RestAssured.baseURI = SERVICE_BASE_URI;
		RestAssured.port = SERVICE_PORT;
		SpringApplication.run(DataDictionaryApplication.class, new String[] {});
	}

	@AfterClass
	public static void disconnectFromDB() {
		mongoClient.close();
	}

	@Test
	public void testSuccessScenarioOfGetAllRecordsForAllCollections() {
		for (String documentType : documentTypes) {
			DBCursor collection = database.getCollection(documentType.toLowerCase()).find();
			Set<String> dbFieldNames = collection.next().keySet();
			ValidatableResponse response = RestAssured.get("/datadictionary/getAll?type=" + documentType.replace("_", ""))
													.then()
													.body("status", CoreMatchers.equalTo(HttpStatus.OK.getReasonPhrase()))
													.body("message", CoreMatchers.equalTo(Constants.DATA_DICTIONARY_GET_SUCCESS));
			Map<String, List<String>> dataFromDB = new HashMap<>();
			for (String dbFieldName : dbFieldNames) {
				List<String> columnValues = new ArrayList<>();
				for (DBObject dbRecord : collection) {
					columnValues.add(dbRecord.get(dbFieldName).toString());
				}
				dataFromDB.put(dbFieldName, columnValues);
			}
			for (String dbFieldName : dbFieldNames) {
				response.body("body." + dbFieldName, CoreMatchers.hasItems(dataFromDB.get(dbFieldName).toArray()));
			}
		}
	}

	@Test
	public void testFailureScenarioOfGetAllRecordsForCollectionWithEmptyType() {
		RestAssured.get("/datadictionary/getAll?type=").then()
					.body("status", CoreMatchers.equalTo("BAD_REQUEST"))
					.body("message", CoreMatchers.equalTo("Requested type is Null or Empty: "))
					.body("errors", CoreMatchers.hasItem("Requested type is Null or Empty: "));
	}
	
	@Test
	public void testFailureScenarioOfGetAllRecordsForCollectionWithNonExistentType() {
		RestAssured.get("/datadictionary/getAll?type=ICD22").then()
					.body("status", CoreMatchers.equalTo("NOT_FOUND"))
					.body("message", CoreMatchers.equalTo("Requested data dictionary type cannot map to a model. Please check the input"))
					.body("errors", CoreMatchers.hasItem("Requested data dictionary type cannot map to a model. Please check the input"));
	}
	
	@Test
	public void testSuccessScenarioOfGetRecordsByIdForAllCollections() {
		for (String documentType : documentTypes) {
			String recordIdToSearch = searchIdValues.get(documentType);
			DBObject collection = database.getCollection(documentType.toLowerCase()).findOne(new BasicDBObject("_id", recordIdToSearch));
			Set<String> dbFieldNames = collection.keySet();
			ValidatableResponse response = RestAssured.get("/datadictionary/getById?type=" + documentType.replace("_", "") + "&id=" + recordIdToSearch)
													.then()
													.body("status", CoreMatchers.equalTo(HttpStatus.OK.getReasonPhrase()))
													.body("message", CoreMatchers.equalTo(Constants.DATA_DICTIONARY_GET_SUCCESS));
			for (String dbFieldName : dbFieldNames) {
				response.body("body." + dbFieldName, CoreMatchers.equalTo(collection.get(dbFieldName).toString()));
			}
		}
	}
	
	@Test
	public void testFailureScenarioOfGetRecordsByIdForCollectionWithEmptyTypeAndEmptyId() {
		RestAssured.get("/datadictionary/getById?type=&id=").then()
				.body("status", CoreMatchers.equalTo("BAD_REQUEST"))
				.body("message", CoreMatchers.equalTo("Requested type is Null or Empty: "))
				.body("errors", CoreMatchers.hasItem("Requested type is Null or Empty: "));
	}
	
	@Test
	public void testFailureScenarioOfGetRecordsByIdForCollectionWithEmptyIdOnly() {
		RestAssured.get("/datadictionary/getById?type=ICDAustralianModificationBlock&id=").then()
				.body("status", CoreMatchers.equalTo("BAD_REQUEST"))
				.body("message", CoreMatchers.equalTo("Requested type is Null or Empty: "))
				.body("errors", CoreMatchers.hasItem("Requested type is Null or Empty: "));
	}
	
	@Test
	public void testFailureScenarioOfGetRecordsByIdForCollectionWithEmptyTypeOnly() {
		RestAssured.get("/datadictionary/getById?type=&id=1").then()
				.body("status", CoreMatchers.equalTo("BAD_REQUEST"))
				.body("message", CoreMatchers.equalTo("Requested type is Null or Empty: "))
				.body("errors", CoreMatchers.hasItem("Requested type is Null or Empty: "));
	}
	
	@Test
	public void testFailureScenarioOfGetRecordsByIdForCollectionWithNonExistentType() {
		RestAssured.get("/datadictionary/getById?type=ICD22&id=1").then()
				.body("status", CoreMatchers.equalTo("NOT_FOUND"))
				.body("message", CoreMatchers.equalTo("Requested data dictionary type cannot map to a model. Please check the input"))
				.body("errors", CoreMatchers.hasItem("Requested data dictionary type cannot map to a model. Please check the input"));
	}
	
	@Test
	public void testFailureScenarioOfGetRecordsByIdForCollectionWithNonExistentRecordId() {
		RestAssured.get("/datadictionary/getById?type=ICDAustralianModificationBlock&id=1000").asString().equals("");
	}
	
	@Test
	public void testSuccessScenarioOfGetAllRecordsByFieldValueForAllCollections() {
		for (String documentType : documentTypes) {
			String searchFieldName = searchFieldValues.get(documentType).keySet().iterator().next();
			String searchFieldValue = searchFieldValues.get(documentType).get(searchFieldName);
			DBCursor collection = database.getCollection(documentType.toLowerCase())
											.find(new BasicDBObject(searchFieldName, searchFieldValue));
			Set<String> dbFieldNames = collection.next().keySet();
			ValidatableResponse response = RestAssured.get("/datadictionary/getAllByField?type=" + documentType.replace("_", "") 
															+ "&searchField=" + searchFieldName + "&searchValue=" + searchFieldValue)
													.then()
													.body("status", CoreMatchers.equalTo(HttpStatus.OK.getReasonPhrase()))
													.body("message", CoreMatchers.equalTo(Constants.DATA_DICTIONARY_GET_SUCCESS));
			Map<String, List<String>> dataFromDB = new HashMap<>();
			for (String dbFieldName : dbFieldNames) {
				List<String> columnValues = new ArrayList<>();
				for (DBObject dbRecord : collection) {
					columnValues.add(dbRecord.get(dbFieldName).toString());
				}
				dataFromDB.put(dbFieldName, columnValues);
			}
			for (String dbFieldName : dbFieldNames) {
				response.body("body." + dbFieldName, CoreMatchers.hasItems(dataFromDB.get(dbFieldName).toArray()));
			}
		}
	}
	
	@Test
	public void testFailureScenarioOfGetAllRecordsByFieldValueForCollectionWithEmptyTypeAndEmptySearchFieldAndEmptySearchValue() {
		RestAssured.get("/datadictionary/getAllByField?type=&searchField=&searchValue=").then()
				.body("status", CoreMatchers.equalTo("BAD_REQUEST"))
				.body("message", CoreMatchers.equalTo("Requested type is Null or Empty: "))
				.body("errors", CoreMatchers.hasItem("Requested type is Null or Empty: "));
	}
	
	@Test
	public void testFailureScenarioOfGetAllRecordsByFieldValueForCollectionWithEmptyTypeOnly() {
		RestAssured.get("/datadictionary/getAllByField?type=&searchField=effective_date&searchValue=00:00.0").then()
				.body("status", CoreMatchers.equalTo("BAD_REQUEST"))
				.body("message", CoreMatchers.equalTo("Requested type is Null or Empty: "))
				.body("errors", CoreMatchers.hasItem("Requested type is Null or Empty: "));
	}
	
	@Test
	public void testFailureScenarioOfGetAllRecordsByFieldValueForCollectionWithEmptySearchFieldNameOnly() {
		RestAssured.get("/datadictionary/getAllByField?type=ICDAustralianModificationBlock&searchField=&searchValue=00:00.0").then()
				.body("status", CoreMatchers.equalTo("BAD_REQUEST"))
				.body("message", CoreMatchers.equalTo("Requested type is Null or Empty: "))
				.body("errors", CoreMatchers.hasItem("Requested type is Null or Empty: "));
	}
	
	@Test
	public void testFailureScenarioOfGetAllRecordsByFieldValueForCollectionWithEmptySearchFieldValueOnly() {
		RestAssured.get("/datadictionary/getAllByField?type=ICDAustralianModificationBlock&searchField=effective_date&searchValue=").then()
				.body("status", CoreMatchers.equalTo("BAD_REQUEST"))
				.body("message", CoreMatchers.equalTo("Requested type is Null or Empty: "))
				.body("errors", CoreMatchers.hasItem("Requested type is Null or Empty: "));
	}
	
	@Test
	public void testFailureScenarioOfGetAllRecordsByFieldValueForCollectionWithNonExistentType() {
		RestAssured.get("/datadictionary/getAllByField?type=ICD22&searchField=effective_date&searchValue=00:00.0").then()
				.body("status", CoreMatchers.equalTo("NOT_FOUND"))
				.body("message", CoreMatchers.equalTo("Requested data dictionary type cannot map to a model. Please check the input"))
				.body("errors", CoreMatchers.hasItem("Requested data dictionary type cannot map to a model. Please check the input"));
	}
	
	@Test
	public void testFailureScenarioOfGetAllRecordsByFieldValueForCollectionWithNonExistentSearchFieldName() {
		RestAssured.get("/datadictionary/getAllByField?type=ICD22&searchField=effective_date2&searchValue=00:00.0").then()
				.body("status", CoreMatchers.equalTo("NOT_FOUND"))
				.body("message", CoreMatchers.equalTo("Requested data dictionary type cannot map to a model. Please check the input"))
				.body("errors", CoreMatchers.hasItem("Requested data dictionary type cannot map to a model. Please check the input"));
	}
	
	@Test
	public void testFailureScenarioOfGetAllRecordsByFieldValueForCollectionWithNonExistentSearchFieldValue() {
		RestAssured.get("/datadictionary/getAllByField?type=ICDAustralianModificationBlock&searchField=effective_date&searchValue=00:00.00000").asString().equals("");
	}
}