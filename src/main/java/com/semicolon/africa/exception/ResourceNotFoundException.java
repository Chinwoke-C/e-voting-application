package com.semicolon.africa.exception;

public class ResourceNotFoundException extends BusinessLogicException {
    public ResourceNotFoundException(String election, String id, Long id1) {
        super(id);
    }
}
