package com.webdev.truckmanagementsystem.Shared.Domain.Bus.Event.Spring;

import com.webdev.truckmanagementsystem.Shared.Domain.Bus.Event.DomainEvent;
import com.webdev.truckmanagementsystem.Shared.Domain.Bus.Event.EventBus;
import org.springframework.context.ApplicationEventPublisher;

import java.util.List;

public class SpringApplicationEventBus implements EventBus {

    private final ApplicationEventPublisher publisher;

    public SpringApplicationEventBus(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void publish(List<DomainEvent> events) {
        events.forEach(this::publish);
    }

    private void publish(final DomainEvent event) {
        this.publisher.publishEvent(event);
    }
}
