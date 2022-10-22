package com.customer.pereference.exception;

import com.customer.pereference.response.RestApiResponse;
import lombok.Getter;

@Getter

public class DataNotFoundException extends RuntimeException {

    private RestApiResponse restApiErrorResponse;

    public DataNotFoundException(final int status, final String message, final String error) {
        super(message);
        restApiErrorResponse = new RestApiResponse(false, status, message, error);
    }

}
