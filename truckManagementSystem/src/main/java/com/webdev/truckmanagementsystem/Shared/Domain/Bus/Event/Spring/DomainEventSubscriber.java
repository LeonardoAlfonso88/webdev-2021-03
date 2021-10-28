package com.webdev.truckmanagementsystem.Shared.Domain.Bus.Event.Spring;


import com.webdev.truckmanagementsystem.Shared.Domain.Bus.Event.DomainEvent;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface DomainEventSubscriber {
    Class<? extends DomainEvent>[] value();
}
