package com.webdev.truckmanagementsystem.Shared.Domain.Bus.Event;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.UUID;

public abstract class DomainEvent {

    private String aggregateId;
    private String eventId;
    private String occurredOn;

    public DomainEvent(String aggregateId) {
        this.aggregateId = aggregateId;
        this.eventId = UUID.randomUUID().toString();
        this.occurredOn = this.dateToString(LocalDateTime.now());
    }

    public DomainEvent(String aggregateId, String eventId, String occurredOn) {
        this.aggregateId = aggregateId;
        this.eventId = eventId;
        this.occurredOn = occurredOn;
    }

    protected DomainEvent() { }

    protected String dateToString(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ISO_DATE_TIME);
    }

    public String aggregateId() {
        return this.aggregateId;
    }

    public String eventId() {
        return this.eventId;
    }

    public String occurredOn() {
        return this.occurredOn;
    }

    public abstract String eventName();

    public abstract HashMap<String, Serializable> toPrimitive();

    public abstract DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body,
                                              String eventId, String occurredOn);

}
