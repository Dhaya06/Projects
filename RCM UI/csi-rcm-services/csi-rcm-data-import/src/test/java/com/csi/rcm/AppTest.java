package com.csi.rcm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import csi.vidaplus.rcm.dataimport.App;
import csi.vidaplus.rcm.dataimport.model.Encounter;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableFeignClients
@ActiveProfiles("test")
public class AppTest {

	@LocalServerPort
    private int port;
	
	static ConfigurableApplicationContext eurekaServer;

	private static List<Encounter> encounters = new LinkedList<>();
	private static Encounter savedEncounter = null;
	
	@BeforeClass
	public static void init() {
		ClassLoader classLoader = AppTest.class.getClassLoader();
		File file = new File(classLoader.getResource("encounter.json").getFile());

		ObjectMapper mapper = new ObjectMapper();
		try {
			encounters.add(mapper.readValue(file, Encounter.class));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	@Test
	public void saveEncounters() {
		
		RestTemplate    restTemplate  =  new RestTemplate();
	    HttpHeaders 	headers 	  =  new HttpHeaders();
	    
        headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
		
        HttpEntity<List<Encounter>> request = new HttpEntity<>(encounters);
        
        ResponseEntity<List> reponse = restTemplate.postForEntity("http://localhost:"+port+"/rcm/import/encounter", request, List.class);
        List<Encounter> body = reponse.getBody();
        savedEncounter = body.get(0);
        assertNotNull(body.get(0).getId());
	}
	
	
	@Test
	public void updateEncounters() {
		RestTemplate    restTemplate  =  new RestTemplate();
	    HttpHeaders 	headers 	  =  new HttpHeaders();
	    
        headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
		
        HttpEntity<List<Encounter>> request = new HttpEntity<>(encounters);
        
        ResponseEntity<List> reponse = restTemplate.postForEntity("http://localhost:"+port+"/rcm/import/encounter", request, List.class);
        List<Encounter> body = reponse.getBody();
        
        assertEquals(body.size(), encounters.size());
	}
	
	
	@Test
	public void deleteEncounter() {
		RestTemplate    restTemplate  =  new RestTemplate();
	    HttpHeaders 	headers 	  =  new HttpHeaders();
	    
        headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
		
        Map<String,Object> uriVariables = new HashMap<>();
        uriVariables.put("encounterIds", savedEncounter.getId());
        
        ResponseEntity<List> reponse = restTemplate.getForEntity("http://localhost:"+port+"/rcm/import/encounter", List.class, uriVariables);
        List<Encounter> body = reponse.getBody();
        
        assertEquals(body.size(), encounters.size());
	}
}
