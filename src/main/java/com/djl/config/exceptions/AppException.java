package com.djl.config.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

public class AppException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    @Getter @Setter
    private HttpStatus status;
    @Getter @Setter
    private String message;

    public AppException(HttpStatus estado, String mensaje) {
        super();
        this.status = estado;
        this.message = mensaje;
    }

}
