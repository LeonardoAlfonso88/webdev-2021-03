package com.webdev.truckmanagementsystem.Shared.Domain.Bus.Event.RabbitMQ.Serializable;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webdev.truckmanagementsystem.Shared.Domain.Bus.Event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;

public class DomainEventJsonSerializable {

    public static String serialize(DomainEvent domainEvent) {
        HashMap<String, Serializable> attributes = domainEvent.toPrimitive();
        attributes.put("id", domainEvent.aggregateId());

        HashMap<String, Serializable> message = new HashMap<>();

        message.put("data", new HashMap<String, Serializable>() {{
            put("id", domainEvent.eventId());
            put("type", domainEvent.eventName());
            put("occurred_on", domainEvent.occurredOn());
            put("attributes", attributes);
        }});

        message.put("meta", new HashMap<String, Serializable>());
        return jsonEncode(message);
    }

    public static String jsonEncode(HashMap<String, Serializable> map) {
        try {
            return new ObjectMapper().writeValueAsString(map);
        }
        catch(Exception e) {
            return "";
        }
    }

}
