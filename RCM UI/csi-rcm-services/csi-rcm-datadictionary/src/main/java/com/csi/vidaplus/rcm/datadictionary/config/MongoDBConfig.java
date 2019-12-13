package com.csi.vidaplus.rcm.datadictionary.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
/**
 * This class intialize mongo db configurations
 * @version 1.0 12 Jan 2018
 * @author Firstname Lastname
 */
@Configuration
public class MongoDBConfig {

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

}
