package com.csi.rcm.minimumdata;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;

import com.csi.microservices.SpringBootApplication;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
public class App extends SpringBootApplication {
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
}