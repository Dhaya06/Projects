package com.csi.rcm;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.csi.rcm.worklist.model.FilterType;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes=AppTest.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@SpringBootApplication
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppTest {

//	@LocalServerPort
//    private int port;
//	
//	@Test
//	public void createFilterType() {
//		RestTemplate    restTemplate  =  new RestTemplate();
//	    HttpHeaders 	headers 	  =  new HttpHeaders();
//	    headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
//	    
//	    FilterType filterType = new FilterType();
//	    filterType.setName("Payer");
//	    
//	    HttpEntity<FilterType> request = new HttpEntity<>(filterType);
//	    ResponseEntity<HttpEntity> postForEntity = restTemplate.postForEntity("http://localhost:"+port+"/minimumdataset/filtertype", request, HttpEntity.class);
//	    postForEntity.getStatusCode();
//	    
//	    assertEquals(postForEntity.getStatusCode(), HttpStatus.CREATED);
//	    
//	}
//	
//	public static void main(String[] args) {
//		SpringApplication.run(AppTest.class, args);
//	}
	
}
