package com.djl.config.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Map;

@Data
@AllArgsConstructor @NoArgsConstructor
public class ErrorValid {
    private Date timestamp;
    private Integer status;
    private Map<String, String> errors;
    private String detail;
}
