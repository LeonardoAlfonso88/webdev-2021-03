package com.webdev.truckmanagementsystem.Shared.Domain.Bus.Event.RabbitMQ;

import com.webdev.truckmanagementsystem.Shared.Domain.Bus.Event.DomainEvent;
import com.webdev.truckmanagementsystem.Shared.Domain.Bus.Event.EventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.util.List;

public class RabbitMqEventBus implements EventBus {

    private final RabbitMqPublisher publisher;
    private final String exchangeName;

    @Autowired
    private Environment env;

    public RabbitMqEventBus(RabbitMqPublisher publisher, Environment env) {
        this.publisher = publisher;
        this.env = env;
        this.exchangeName = env.getProperty("rabbit.exchange");
    }

    @Override
    public void publish(List<DomainEvent> events) {
        events.forEach(this::publish);
    }

    public void publish(DomainEvent domainEvent) {
        this.publisher.publish(domainEvent, exchangeName);
    }

}
