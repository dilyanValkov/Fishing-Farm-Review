package com.zasmyano.Fishing_Farm_Review.service.exception;

import lombok.Getter;

@Getter
public class ObjectNotFountException extends RuntimeException{
    private final String url;
    public ObjectNotFountException(String message, String url) {
        super(message);
        this.url = url;
    }


}
