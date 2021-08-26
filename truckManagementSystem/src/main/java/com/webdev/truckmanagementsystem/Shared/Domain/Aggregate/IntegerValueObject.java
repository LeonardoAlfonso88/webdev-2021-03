package com.webdev.truckmanagementsystem.Shared.Domain.Aggregate;

import java.util.Objects;

public class IntegerValueObject {

    protected Integer value;

    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerValueObject that = (IntegerValueObject) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
