package com.codewithfavour.exception;

import org.springframework.stereotype.Service;

public class InvalidDeleteContactException extends RuntimeException {
    public InvalidDeleteContactException(String message) {
        super(message);
    }
}
