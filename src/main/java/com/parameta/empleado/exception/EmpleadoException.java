package com.parameta.empleado.exception;

import org.springframework.http.HttpStatus;

public class EmpleadoException extends RuntimeException{
    private final String code;
    private final HttpStatus status;

    public EmpleadoException(String message, String code, HttpStatus status) {
        super(message);
        this.code = code;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
