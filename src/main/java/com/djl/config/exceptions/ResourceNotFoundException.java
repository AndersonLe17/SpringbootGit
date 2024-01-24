package com.djl.config.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String resource;
    @Getter @Setter
    private String property;
    @Getter @Setter
    private Long value;

    public ResourceNotFoundException(String resource, String property, long value) {
        super(String.format("%s no encontrado con: %s = '%s'",resource,property,value));
        this.resource = resource;
        this.property = property;
        this.value = value;
    }
}
