package com.jalasoft.ocrwebservice.exception;

public class ParameterInvalidException extends Exception {
    private int code;
    private String message;
    private String params;

    public ParameterInvalidException(int code, String params) {
        this.code = code;
        this.params = params;
    }

    public String getMessage() {
        switch (this.code) {
            case 10:
                this.message = "the param " + params + "is null";
                break;
            case 11:
                this.message = "the param " + params + "is empty";
                break;
            case 12:
                this.message = "the param " + params + " does not exist in dataset";
                break;
        }
        return message;
    }
}
