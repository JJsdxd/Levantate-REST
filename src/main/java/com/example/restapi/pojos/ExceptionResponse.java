package com.example.restapi.pojos;

import java.util.Date;

public class ExceptionResponse {
    private final Date timestamp;
    private final  String message;
    private final String details;
    private final String httpCodeMessage;

    public ExceptionResponse(Date timestamp, String message, String details,String httpCodeMessage) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.httpCodeMessage=httpCodeMessage;
    }

    public String getHttpCodeMessage() {
        return httpCodeMessage;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

}
