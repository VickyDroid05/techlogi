package com.logitech.testapp.core.error;

public class Failure {

    private String errorCode;
    private String errorMessage;
    private String errorDescription;


    public Failure(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Failure(String errorCode, String errorMessage, String errorDescription) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorDescription = errorDescription;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorDescription() {
        return errorDescription;
    }
}
