package com.csi.rcm.worklist.cqrs.config;


import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for rcmworklist Queue.
 */

@Configuration
public class QueueConfiguration {
	
    @Bean
    public Exchange exchange() {
        return ExchangeBuilder.fanoutExchange("rcmworklist").build();
    }

    @Bean
    public Queue queue() {
        return QueueBuilder.durable("rcmworklist").build();
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(exchange()).with("*").noargs();
    }

    @Autowired
    public void configure(AmqpAdmin admin) {
        admin.declareExchange(exchange());
        admin.declareQueue(queue());
        admin.declareBinding(binding());
    }
}
