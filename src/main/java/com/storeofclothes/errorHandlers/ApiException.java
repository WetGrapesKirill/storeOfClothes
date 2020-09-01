package com.storeofclothes.errorHandlers;

public class ApiException extends RuntimeException{
    private final String message;
    private final int code;

    public ApiException(String message, int code){
        super(message);
        this.message = message;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getMessage(){
        return message;
    }
}

