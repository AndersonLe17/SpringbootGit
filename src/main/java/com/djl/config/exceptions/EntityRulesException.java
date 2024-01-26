package com.djl.config.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

public class EntityRulesException extends RuntimeException {
    private static final long serialVersionUID = 1L;

//    @Getter @Setter
//    private HttpStatus status;
    @Getter @Setter
    private String message;

    public EntityRulesException(String message) {
        super();
//        this.status = status;
        this.message = message;
    }
}
