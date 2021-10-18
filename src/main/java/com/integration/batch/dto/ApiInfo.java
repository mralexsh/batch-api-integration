package com.integration.batch.dto;
import org.springframework.beans.factory.annotation.Value;


public class ApiInfo {
    @Value("${api.version}")
    private String version;

    @Value("${api.description}")
    private String description;

    public String getVersion() {
        return version;
    }

    public String getDescription() {
        return description;
    }
}
