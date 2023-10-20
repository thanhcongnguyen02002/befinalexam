package com.example.befinalexam.config;

import com.example.befinalexam.repository.ErrorCode;
import com.example.befinalexam.repository.ErrorCodeException;
import com.example.befinalexam.repository.ErrorReponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.nio.file.AccessDeniedException;
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    private ResponseEntity<ErrorReponse> buildResponseEntity(ErrorCodeException ex) {
        var errCode = ex.getErrorCode();
        var errorResponse = new ErrorReponse(errCode.getStatus(), errCode.getCode(), errCode.getMessage(), ex.getDescription());
        return ResponseEntity
                .status(errCode.getStatus())
                .body(errorResponse);
    }

    @ExceptionHandler(ErrorCodeException.class)
    public ResponseEntity<ErrorReponse> handleDepartmentExistedException(ErrorCodeException ex) {
        log.error("Has error: ", ex);
        return buildResponseEntity(ex);
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ValidationErrorResp> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
//        log.error("Has error: ", ex);
//
//        var violations = ex.getBindingResult().getFieldErrors().stream()
//                .map(fieldError -> ValidationErrorResp.Violation.builder().fieldName(fieldError.getObjectName() + "." + fieldError.getField()).message(fieldError.getDefaultMessage()).build())
//                .toList();
//
//        var errCode = ErrorCode.METHOD_ARGUMENT_NOT_VALID;
//        var error = new ValidationErrorResp(errCode.getStatus(), errCode.getCode(), errCode.getMessage(), violations);
//        return ResponseEntity.of(Optional.of(error));
//    }

//    @ExceptionHandler(ConstraintViolationException.class)
//    public ResponseEntity<ValidationErrorResp> handleMethodArgumentNotValidException(ConstraintViolationException ex) {
//        log.error("Has error: ", ex);
//
//        var violations = ex.getConstraintViolations().stream()
//                .map(fieldError -> ValidationErrorResp.Violation.builder().fieldName(fieldError.getPropertyPath().toString()).message(fieldError.getMessage()).build())
//                .toList();
//
//        var errCode = ErrorCode.METHOD_ARGUMENT_NOT_VALID;
//        var error = new ValidationErrorResp(errCode.getStatus(), errCode.getCode(), errCode.getMessage(), violations);
//        return ResponseEntity.of(Optional.of(error));
//    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorReponse> handleAccessDeniedException(AccessDeniedException ex) {
        log.error("Has error: ", ex);
        var errCode = ErrorCode.FORBIDDEN;
        var errorResponse = new ErrorReponse(errCode.getStatus(), errCode.getCode(), errCode.getMessage(), ex.getMessage());
        return ResponseEntity
                .status(errCode.getStatus())
                .body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorReponse> handleException(Exception ex) {
        log.error("Has error: ", ex);
        var errCode = ErrorCode.INTERNAL_SERVER_ERROR;
        var errorResponse = new ErrorReponse(errCode.getStatus(), errCode.getCode(), errCode.getMessage(), ex.getMessage());
        return  ResponseEntity
                .status(errCode.getStatus())
                .body(errorResponse);
    }
}
