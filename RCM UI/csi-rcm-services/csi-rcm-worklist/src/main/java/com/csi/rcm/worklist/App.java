package com.csi.rcm.worklist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class App extends com.csi.microservices.SpringBootApplication implements CommandLineRunner{
	@Autowired
	InitialStat state;
    
	public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
//          .paths(PathSelectors.ant("/minimumdataset/**"))                          
          .build();                                           
    }

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("database Url :  "+ state.getUrl());
		System.out.println("host rabbit :  "+ state.getHost());

	}
}