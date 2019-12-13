package com.csi.rcm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import antlr.collections.List;
import csi.vidaplus.rcm.datavalidation.App;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableFeignClients
@ActiveProfiles("test")
public class AppTest {

	@LocalServerPort
    private int port;
	
	static ConfigurableApplicationContext eurekaServer;

	@Test
	public void saveEncounters() {
		
		RestTemplate    restTemplate  =  new RestTemplate();
	    HttpHeaders 	headers 	  =  new HttpHeaders();
	    
        headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
		
        restTemplate.getForEntity("http://localhost:"+port+"/datavalidation", List.class);
        
	}
	
}
