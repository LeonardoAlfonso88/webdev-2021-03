package com.webdev.truckmanagementsystem.Shared.Domain.Bus.Event.RabbitMQ;

import com.webdev.truckmanagementsystem.Shared.Domain.Bus.Event.DomainEvent;
import com.webdev.truckmanagementsystem.Shared.Domain.Bus.Event.RabbitMQ.Serializable.DomainEventJsonDeserializer;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class RabbitMqDomainEventsConsumer {

    private final DomainEventJsonDeserializer deserializer;
    private final DomainEventsInformation information;

    @Autowired
    private final ApplicationContext context;

    public RabbitMqDomainEventsConsumer(DomainEventJsonDeserializer deserializer, DomainEventsInformation information, ApplicationContext context) {
        this.deserializer = deserializer;
        this.information = information;
        this.context = context;
    }

    @RabbitListener(queues = "#{'${rabbit.queues}'.split(',')}")
    public void consume(Message message) throws Exception {
        String serializedMessage = new String(message.getBody());
        DomainEvent domainEvent = deserializer.deserialize(serializedMessage);
        String queueName = message.getMessageProperties().getConsumerQueue();
        Object subscriber = this.subscriberFor(queueName);
        try {
            Method subscriberOnMethod = subscriber.getClass().getMethod("on", domainEvent.getClass());
            subscriberOnMethod.invoke(subscriber, domainEvent);
        }
        catch (Exception error) {
            System.err.println("Error: " + error.toString());
        }
    }

    private Object subscriberFor(String queueName) throws Exception {
        if(!this.information.validateEventSubscriber(queueName)) {
            throw new Exception("No hay listerer asociado a la cola " + queueName);
        }
        String eventSubscriberName = this.information.getEventSubscriber(queueName);
        Object subscriber = context.getBean(eventSubscriberName);
        return subscriber;
    }
}
