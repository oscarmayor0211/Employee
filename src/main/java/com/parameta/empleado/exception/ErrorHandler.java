package com.parameta.empleado.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorHandler {
    private String code;
    private String message;
    private List<ErrorDetail> details;
}

@Data
@NoArgsConstructor
class ErrorDetail {
    private String field;
    private String error;
}