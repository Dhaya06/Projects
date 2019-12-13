 package com.csi.vidaplus.rcm.masterdata.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.mongodb.Mongo;
/**
 * This class intialize mongo db configurations
 * @version 1.0 12 Jan 2018
 * @author Firstname Lastname
 */
@Configuration
public class MongoDBConfig {
	
	@Autowired 
    MongoDbFactory mongoDbFactory;
    
    @Autowired 
    MongoMappingContext mongoMappingContext;
	

    /**
     * initlaize mongo event listener
     * @return
     */
    @Bean
    public ValidatingMongoEventListener validatingMongoEventListener() {
        return new ValidatingMongoEventListener(validator());
    }

    /**
     * initlaize mongo validatir
     * @return
     */
    @Bean
    public LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }
    
    /**
     * MappingMongoConverter remove _class
     * @return
     */
    @Bean
    public MappingMongoConverter mappingMongoConverter() {
     DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDbFactory);
     MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, mongoMappingContext);
     converter.setTypeMapper(new DefaultMongoTypeMapper(null));
     return converter;
    }


    


}
