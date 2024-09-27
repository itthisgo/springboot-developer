package com.ithotgi.springbootdeveloper.config.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "E1", "입력값이 올바르지 않음"),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "E2", "잘못된 Method 요청"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "E3", "서버 에러"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "E4", "엔티티가 존재하지 않음"),

    ARTICLE_NOT_FOUND(HttpStatus.NOT_FOUND, "A1", "게시글 정보가 존재하지 않음");

    private final String message;

    private final String code;
    private final HttpStatus status;

    ErrorCode(final HttpStatus status, final String code, final String message){
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
