package com.eCom.restdemo.exception;

public class CloudVendorNotFoundexception extends RuntimeException{

    public CloudVendorNotFoundexception(String message) {
        super(message);
    }

    public CloudVendorNotFoundexception(String message, Throwable cause) {
        super(message, cause);
    }

}
