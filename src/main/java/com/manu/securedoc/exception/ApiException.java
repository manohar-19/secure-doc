package com.manu.securedoc.exception;


public class ApiException extends RuntimeException{
    public ApiException(){
        super("An error occurred");
    }
    public ApiException(String message){
        super(message);
    }
}
