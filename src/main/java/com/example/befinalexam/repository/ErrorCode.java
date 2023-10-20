package com.example.befinalexam.repository;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
@Getter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum ErrorCode {

    PRODUCT_NOT_FOUND(404, "GRP-001", "product not found"),
    USER_NOT_FOUND(404, "GRP-001", "User not found"),
    TYPE_NOT_FOUND(404, "GRP-001", "Type not found"),
    UNAUTHORIZED(401, "ACC-002", "Unauthorized"),
    FORBIDDEN(403, "ACC-003", "Forbidden"),
    PRODUCT_EXISTED(409, "GRP-004", "product existed"),
    USER_EXISTED(409, "GRP-004", "user existed"),
    TYPE_EXISTED(409, "GRP-004", "Type existed"),
    INTERNAL_SERVER_ERROR(500, "SYS-001", "Internal server error");

    int status;
    String code;
    String message;
    ErrorCode(int status, String code, String message) {
        this.status=status;
        this.code = code;
        this.message = message;
    }
}
