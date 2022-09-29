package com.example.ej7.crudvalidation.exceptions;

import lombok.Data;

import java.util.Date;

@Data
public class EntityNotFoundException extends RuntimeException
{
    Date timestamp;
    int httpCode;

    public EntityNotFoundException(String message, int httpCode)
    {
        super(message);
        setTimestamp(new Date());
        setHttpCode(httpCode);
    }
}
