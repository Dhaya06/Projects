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
package com.csi.vidaplus.rcm.masterdata.test;

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
import com.csi.vidaplus.rcm.masterdata.MasterDataApplication;
import com.csi.vidaplus.rcm.masterdata.util.Constants;

/**
 * Test class for the master data builder of RCM module.
 *
 * @version 1.0 12 Jan 2018
 * @author Firstname Lastname
 */
public class MasterDataControllerTest {

	private static final String DB_URI = "mongodb://localhost:27017";
	private static final String DATABASE_NAME = "csi_rcm_master_data";
	private static final String SERVICE_BASE_URI = "http://localhost";
	private static final int SERVICE_PORT = 8095;
	private static MongoClient mongoClient;
	private static DB database;
	private List<String> documentTypes = Arrays.asList("Clinic", "Clinic_Group", "Company", "Company_Group", "Company_Profile", "Company_Rules", "Doctor", 
														"Hospital", "Patient", "Procedure", "Procedure_Price", "Procedure_Group", "Procedure_Sub_Group","Payment_Mode","Encounter_Type");
	private Map<String, Map<String, String>> searchFieldValues = new HashMap<String, Map<String, String>>() {{
			put("Clinic", new HashMap<String, String>() {{ put("clinic_description", "PEDIATRIC"); }});
			put("Clinic_Group", new HashMap<String, String>() {{ put("group_description", "GENERAL PRACTITIONER"); }});
			put("Company", new HashMap<String, String>() {{ put("company_name", "WSO2 (Pvt) Ltd"); }});
			put("Company_Group", new HashMap<String, String>() {{ put("group_name", "MEDISERV"); }});
			put("Company_Profile", new HashMap<String, String>() {{ put("submission_format", "DB2DB"); }});
			put("Company_Rules", new HashMap<String, String>() {{ put("company_id", "53"); }});
			put("Doctor", new HashMap<String, String>() {{ put("doctor_name", "Jayani Weerathunga"); }});
			put("Hospital", new HashMap<String, String>() {{ put("hospital_name", "ALLIED DIAGNOSTIC CENTRE"); }});
			put("Patient", new HashMap<String, String>() {{ put("patient_name", "Hasitha Jayathilaka"); }});
			put("Procedure", new HashMap<String, String>() {{ put("procedure_name", "CONSULTATION RETURN VISIT"); }});
			put("Procedure_Price", new HashMap<String, String>() {{ put("price", "150"); }});
			put("Procedure_Group", new HashMap<String, String>() {{ put("group_description", "EMERGENCY"); }});
			put("Procedure_Sub_Group", new HashMap<String, String>() {{ put("alias", "CONSULTATION SERVICES"); }});
			put("Payment_Mode", new HashMap<String, String>() {{ put("description", "Staff Discount"); }});
			put("Encounter_Type", new HashMap<String, String>() {{ put("encounter_speciality", "Cardiology"); }});
		}};

	@BeforeClass
	public static void connectToDB() {
		mongoClient = new MongoClient(new MongoClientURI(DB_URI));
		database = mongoClient.getDB(DATABASE_NAME);
		RestAssured.baseURI = SERVICE_BASE_URI;
		RestAssured.port = SERVICE_PORT;
		SpringApplication.run(MasterDataApplication.class, new String[] {});
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
			ValidatableResponse response = RestAssured.get("/masterdata/getAll?type=" + documentType.replace("_", ""))
													.then()
													.body("status", CoreMatchers.equalTo(HttpStatus.OK.getReasonPhrase()))
													.body("message", CoreMatchers.equalTo(Constants.MASTER_DATA_GET_SUCCESS));
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
		RestAssured.get("/masterdata/getAll?type=").then()
					.body("status", CoreMatchers.equalTo("BAD_REQUEST"))
					.body("message", CoreMatchers.equalTo("Requested type is Null or Empty: "))
					.body("errors", CoreMatchers.hasItem("Requested type is Null or Empty: "));
	}
	
	@Test
	public void testFailureScenarioOfGetAllRecordsForCollectionWithNonExistentType() {
		RestAssured.get("/masterdata/getAll?type=Clinic2").then()
					.body("status", CoreMatchers.equalTo("NOT_FOUND"))
					.body("message", CoreMatchers.equalTo("Requested master data type cannot map to a model. Please check the input"))
					.body("errors", CoreMatchers.hasItem("Requested master data type cannot map to a model. Please check the input"));
	}
	
	@Test
	public void testSuccessScenarioOfGetRecordsByIdForAllCollections() {
		for (String documentType : documentTypes) {
			DBObject collection = database.getCollection(documentType.toLowerCase()).findOne(new BasicDBObject("_id", "2"));
			Set<String> dbFieldNames = collection.keySet();
			ValidatableResponse response = RestAssured.get("/masterdata/getById?type=" + documentType.replace("_", "") + "&id=2")
													.then()
													.body("status", CoreMatchers.equalTo(HttpStatus.OK.getReasonPhrase()))
													.body("message", CoreMatchers.equalTo(Constants.MASTER_DATA_GET_SUCCESS));
			for (String dbFieldName : dbFieldNames) {
				response.body("body." + dbFieldName, CoreMatchers.equalTo(collection.get(dbFieldName).toString()));
			}
		}
	}
	
	@Test
	public void testFailureScenarioOfGetRecordsByIdForCollectionWithEmptyTypeAndEmptyId() {
		RestAssured.get("/masterdata/getById?type=&id=").then()
				.body("status", CoreMatchers.equalTo("BAD_REQUEST"))
				.body("message", CoreMatchers.equalTo("Requested type is Null or Empty: "))
				.body("errors", CoreMatchers.hasItem("Requested type is Null or Empty: "));
	}
	
	@Test
	public void testFailureScenarioOfGetRecordsByIdForCollectionWithEmptyIdOnly() {
		RestAssured.get("/masterdata/getById?type=Clinic&id=").then()
				.body("status", CoreMatchers.equalTo("BAD_REQUEST"))
				.body("message", CoreMatchers.equalTo("Requested type is Null or Empty: "))
				.body("errors", CoreMatchers.hasItem("Requested type is Null or Empty: "));
	}
	
	@Test
	public void testFailureScenarioOfGetRecordsByIdForCollectionWithEmptyTypeOnly() {
		RestAssured.get("/masterdata/getById?type=&id=1").then()
				.body("status", CoreMatchers.equalTo("BAD_REQUEST"))
				.body("message", CoreMatchers.equalTo("Requested type is Null or Empty: "))
				.body("errors", CoreMatchers.hasItem("Requested type is Null or Empty: "));
	}
	
	@Test
	public void testFailureScenarioOfGetRecordsByIdForCollectionWithNonExistentType() {
		RestAssured.get("/masterdata/getById?type=Clinic2&id=1").then()
				.body("status", CoreMatchers.equalTo("NOT_FOUND"))
				.body("message", CoreMatchers.equalTo("Requested master data type cannot map to a model. Please check the input"))
				.body("errors", CoreMatchers.hasItem("Requested master data type cannot map to a model. Please check the input"));
	}
	
	@Test
	public void testFailureScenarioOfGetRecordsByIdForCollectionWithNonExistentRecordId() {
		RestAssured.get("/masterdata/getById?type=Clinic&id=100").asString().equals("");
	}
	
	@Test
	public void testSuccessScenarioOfGetAllRecordsByFieldValueForAllCollections() {
		for (String documentType : documentTypes) {
			String searchFieldName = searchFieldValues.get(documentType).keySet().iterator().next();
			String searchFieldValue = searchFieldValues.get(documentType).get(searchFieldName);
			DBCursor collection = database.getCollection(documentType.toLowerCase())
											.find(new BasicDBObject(searchFieldName, searchFieldValue));
			Set<String> dbFieldNames = collection.next().keySet();
			ValidatableResponse response = RestAssured.get("/masterdata/getAllByField?type=" + documentType.replace("_", "") 
															+ "&searchField=" + searchFieldName + "&searchValue=" + searchFieldValue)
													.then()
													.body("status", CoreMatchers.equalTo(HttpStatus.OK.getReasonPhrase()))
													.body("message", CoreMatchers.equalTo(Constants.MASTER_DATA_GET_SUCCESS));
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
		RestAssured.get("/masterdata/getAllByField?type=&searchField=&searchValue=").then()
				.body("status", CoreMatchers.equalTo("BAD_REQUEST"))
				.body("message", CoreMatchers.equalTo("Requested type is Null or Empty: "))
				.body("errors", CoreMatchers.hasItem("Requested type is Null or Empty: "));
	}
	
	@Test
	public void testFailureScenarioOfGetAllRecordsByFieldValueForCollectionWithEmptyTypeOnly() {
		RestAssured.get("/masterdata/getAllByField?type=&searchField=clinic_description&searchValue=PEDIATRIC").then()
				.body("status", CoreMatchers.equalTo("BAD_REQUEST"))
				.body("message", CoreMatchers.equalTo("Requested type is Null or Empty: "))
				.body("errors", CoreMatchers.hasItem("Requested type is Null or Empty: "));
	}
	
	@Test
	public void testFailureScenarioOfGetAllRecordsByFieldValueForCollectionWithEmptySearchFieldNameOnly() {
		RestAssured.get("/masterdata/getAllByField?type=Clinic&searchField=&searchValue=PEDIATRIC").then()
				.body("status", CoreMatchers.equalTo("BAD_REQUEST"))
				.body("message", CoreMatchers.equalTo("Requested type is Null or Empty: "))
				.body("errors", CoreMatchers.hasItem("Requested type is Null or Empty: "));
	}
	
	@Test
	public void testFailureScenarioOfGetAllRecordsByFieldValueForCollectionWithEmptySearchFieldValueOnly() {
		RestAssured.get("/masterdata/getAllByField?type=Clinic&searchField=clinic_description&searchValue=").then()
				.body("status", CoreMatchers.equalTo("BAD_REQUEST"))
				.body("message", CoreMatchers.equalTo("Requested type is Null or Empty: "))
				.body("errors", CoreMatchers.hasItem("Requested type is Null or Empty: "));
	}
	
	@Test
	public void testFailureScenarioOfGetAllRecordsByFieldValueForCollectionWithNonExistentType() {
		RestAssured.get("/masterdata/getAllByField?type=Clinic2&searchField=clinic_description&searchValue=PEDIATRIC").then()
				.body("status", CoreMatchers.equalTo("NOT_FOUND"))
				.body("message", CoreMatchers.equalTo("Requested master data type cannot map to a model. Please check the input"))
				.body("errors", CoreMatchers.hasItem("Requested master data type cannot map to a model. Please check the input"));
	}
	
	@Test
	public void testFailureScenarioOfGetAllRecordsByFieldValueForCollectionWithNonExistentSearchFieldName() {
		RestAssured.get("/masterdata/getAllByField?type=Clinic2&searchField=clinic_description2&searchValue=PEDIATRIC").then()
				.body("status", CoreMatchers.equalTo("NOT_FOUND"))
				.body("message", CoreMatchers.equalTo("Requested master data type cannot map to a model. Please check the input"))
				.body("errors", CoreMatchers.hasItem("Requested master data type cannot map to a model. Please check the input"));
	}
	
	@Test
	public void testFailureScenarioOfGetAllRecordsByFieldValueForCollectionWithNonExistentSearchFieldValue() {
		RestAssured.get("/masterdata/getAllByField?type=Clinic&searchField=clinic_description&searchValue=PEDIATRIC222").asString().equals("");
	}
}