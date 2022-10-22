package com.customer.pereference.response;

import lombok.Builder;
import lombok.Data;

/**
 * @author : Khalid Hasan
 */

@Data
@Builder
public class RestApiResponse {
    private boolean isSuccess;
    private int status;
    private String message;
    private Object data;

    public RestApiResponse() {
    }

    public RestApiResponse(boolean isSuccess, int status, String message, Object data) {
        this.isSuccess = isSuccess;
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
