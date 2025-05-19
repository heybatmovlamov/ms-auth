package com.msauth.exception.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private String errorCode;
    private String message;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> additionalFields;

    public ErrorResponse(String errorCode, String message) {
        this(errorCode, message, null);
    }
}
