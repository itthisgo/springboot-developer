package com.ithotgi.springbootdeveloper.config.error;

import com.ithotgi.springbootdeveloper.config.error.exception.BusinessBaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    // 요청 메서드가 맞지 않을 경우에 대한 핸들러 정의
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ResponseEntity<ErrorResponse> handle(HttpRequestMethodNotSupportedException e){
        log.error("HttpRequestMethodNotSuppoerException: ", e);
        return createErrorResponseEntity(ErrorCode.METHOD_NOT_ALLOWED);
    }

    // 비즈니스 로직 요청에 대한 예외 발생 시 핸들러 정의
    @ExceptionHandler(BusinessBaseException.class)
    protected ResponseEntity<ErrorResponse> handle(BusinessBaseException e){
        e.printStackTrace();
        log.error("BusinessException:", e);
        return createErrorResponseEntity(e.getErrorCode());
    }

    // 지정되지 않은 모든 예외에 대한 핸들러 정의
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handle(Exception e){
        e.printStackTrace();
        log.error("Exception:", e);
        return createErrorResponseEntity(ErrorCode.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ErrorResponse> createErrorResponseEntity(ErrorCode errorCode){
        return new ResponseEntity<>(
                ErrorResponse.of(errorCode),
                errorCode.getStatus()
        );
    }


}
