package com.csi.rcm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.csi.rcm.minimumdata.model.FieldType;
import com.csi.rcm.minimumdata.model.ValidationClass;
import com.csi.rcm.minimumdata.model.ValidationField;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=AppTest.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@SpringBootApplication
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppTest {

	static ConfigurableApplicationContext eurekaServer;
	
	@LocalServerPort
    private int port;
	
	private FieldType fieldType;
	
	private ValidationClass validationClass;
	
	@Test
	public void acreateFieldTypeTest() {
		RestTemplate    restTemplate  =  new RestTemplate();
	    HttpHeaders 	headers 	  =  new HttpHeaders();
	    headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
	    
	    FieldType fieldType = new FieldType();
	    fieldType.setName("String");
	    
	    HttpEntity<FieldType> request = new HttpEntity<>(fieldType);
	    ResponseEntity<HttpEntity> postForEntity = restTemplate.postForEntity("http://localhost:"+port+"/minimumdataset/fieldtype", request, HttpEntity.class);
	    postForEntity.getStatusCode();
	    
	    assertEquals(postForEntity.getStatusCode(), HttpStatus.CREATED);
	}
	
	
	@Test
	public void bgetAllFieldTypeTest() {
		RestTemplate    restTemplate  =  new RestTemplate();
	    HttpHeaders 	headers 	  =  new HttpHeaders();
	    headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
	    
	    ResponseEntity<List> postForEntity = restTemplate.getForEntity("http://localhost:"+port+"/minimumdataset/fieldtype", List.class);
	    List<Map<String, Object>> fieldTypes = postForEntity.getBody();
	    
	    ObjectMapper mapper = new ObjectMapper(); 
	    fieldType = mapper.convertValue(fieldTypes.get(0),FieldType.class);
	    assertNotNull(fieldType);
	}
	
	
	@Test
	public void cupdateFieldTypeTest() {
		
		bgetAllFieldTypeTest();
		
		RestTemplate    restTemplate  =  new RestTemplate();
	    HttpHeaders 	headers 	  =  new HttpHeaders();
	    headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
	    
	    fieldType.setName("Integer");
	    
	    HttpEntity<FieldType> request = new HttpEntity<>(fieldType);
	    restTemplate.put("http://localhost:"+port+"/minimumdataset/fieldtype", request);
	    
	    bgetAllFieldTypeTest();
	    
	    assertEquals("Integer", fieldType.getName());
	}
	
	
	@Test
	public void dcreateValidationClassTest() {
		
		bgetAllFieldTypeTest();
		
		RestTemplate    restTemplate  =  new RestTemplate();
	    HttpHeaders 	headers 	  =  new HttpHeaders();
	    headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
	    
	    ValidationClass validationClass = new ValidationClass();
	    validationClass.setClassName("Encounter");
	    
	    List<ValidationField> systemFields =  new ArrayList<>();
	    ValidationField systemField =  new ValidationField(); 
	    systemField.setFieldName("patientId");
	    systemField.setMandatory(Boolean.TRUE);
	    systemField.setMessage("Patinet Id is required");
	    systemField.setSystemField(Boolean.TRUE);
	    systemField.setType(fieldType);
	    systemFields.add(systemField);
	    
	    List<ValidationField> addionalFields =  new ArrayList<>();
	    ValidationField addionalField =  new ValidationField(); 
	    addionalField.setFieldName("patientName");
	    addionalField.setMandatory(Boolean.TRUE);
	    addionalField.setMessage("Patinet Name is required");
	    addionalField.setSystemField(Boolean.FALSE);
	    addionalField.setType(fieldType);
	    addionalFields.add(addionalField);
	    
	    List<ValidationField> attachments =  new ArrayList<>();
	    
	    validationClass.setSystemDefinedFields(systemFields);
	    validationClass.setAdditionalFields(addionalFields);
	    validationClass.setAttachments(attachments);
	    
	    HttpEntity<ValidationClass> request = new HttpEntity<>(validationClass);
	    ResponseEntity<HttpEntity> postForEntity = restTemplate.postForEntity("http://localhost:"+port+"/minimumdataset/validationclass", request, HttpEntity.class);
	    postForEntity.getStatusCode();
	    
	    assertEquals(postForEntity.getStatusCode(), HttpStatus.CREATED);
	}
	
	@Test
	public void egetAllValidationClassTest() {
		RestTemplate    restTemplate  =  new RestTemplate();
	    HttpHeaders 	headers 	  =  new HttpHeaders();
	    headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
	    
	    ResponseEntity<List> postForEntity = restTemplate.getForEntity("http://localhost:"+port+"/minimumdataset/validationclass", List.class);
	    List<Map<String, Object>> fieldTypes = postForEntity.getBody();
	    
	    ObjectMapper mapper = new ObjectMapper();
	    validationClass = mapper.convertValue(fieldTypes.get(0), ValidationClass.class);
	    
	    assertNotNull(validationClass);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(AppTest.class, args);
	}
	
}
