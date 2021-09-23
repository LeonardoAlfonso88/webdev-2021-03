package com.webdev.truckmanagementsystem.Trucks.Trip.Infrastructure.Schema;

import io.swagger.v3.oas.annotations.media.Schema;

public class ErrorSchema {

    @Schema(description = "Description of the presented error", example = "Invalid UUID")
    private String error;

    public ErrorSchema() {
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
