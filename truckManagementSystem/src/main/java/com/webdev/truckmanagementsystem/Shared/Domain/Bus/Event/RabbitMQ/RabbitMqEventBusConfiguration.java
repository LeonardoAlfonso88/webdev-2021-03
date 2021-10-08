package com.webdev.truckmanagementsystem.Shared.Domain.Bus.Event.RabbitMQ;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class RabbitMqEventBusConfiguration {

    @Autowired
    private Environment env;

    public RabbitMqEventBusConfiguration(Environment env) {
        this.env = env;
    }

    @Bean
    public CachingConnectionFactory connection() {
        CachingConnectionFactory factory = new CachingConnectionFactory();

        factory.setHost(env.getProperty("rabbit.host"));
        factory.setPort(Integer.parseInt(env.getProperty("rabbit.port")));
        factory.setUsername(env.getProperty("rabbit.user"));
        factory.setPassword(env.getProperty("rabbit.password"));

        return factory;
    }
}
