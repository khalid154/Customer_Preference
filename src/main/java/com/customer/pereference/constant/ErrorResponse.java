package com.customer.pereference.constant;

public enum ErrorResponse {
    SUCCESS("success", 200),

    NO_DATA_FOUND("No data found", 404),

    INVALID_BRAND_ID("Invalid Brand Id",404),

    INTERNAL_SERVER_ERROR("some error occurred",500),

    ERROR_WHILE_SAVING_IMAGE("Error occurred while saving image",400);

    public String message;
    public int code;

    ErrorResponse(String message, int code) {
        this.message = message;
        this.code = code;
    }
}
