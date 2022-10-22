package com.restexample.userdata.exception;

public class ApiError {

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ApiError(String message) {
        this.message = message;
    }

    private String message;

}
