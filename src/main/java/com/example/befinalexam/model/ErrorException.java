package com.example.befinalexam.model;

import com.example.befinalexam.repository.ErrorCode;
import com.example.befinalexam.repository.ErrorCodeException;

public class ErrorException extends ErrorCodeException {
    public ErrorException(ErrorCode errorCode, String description) {
        super(errorCode, description);
    }
}
