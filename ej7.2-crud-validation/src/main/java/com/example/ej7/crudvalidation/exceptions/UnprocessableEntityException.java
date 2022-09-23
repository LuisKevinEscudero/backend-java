package com.example.ej7.crudvalidation.exceptions;


import lombok.Data;

import java.util.Date;

@Data
public class UnprocessableEntityException extends RuntimeException
{
    Date timestamp;
    int httpCode;

    public UnprocessableEntityException(String message, int httpCode)
    {
        super(message);
        System.out.println(message);
        setTimestamp(new Date());
        setHttpCode(httpCode);
    }
}

