package com.optimize.jpademoapp.common.response;

import com.optimize.jpademoapp.common.enums.ApiStatus;

public class ApiResponse <T>{
    private ApiStatus status;
    private String message;
    private T data;

    public ApiResponse(ApiStatus status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ApiStatus getStatus() {
        return status;
    }

    public void setStatus(ApiStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
