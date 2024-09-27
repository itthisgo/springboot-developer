package com.ithotgi.springbootdeveloper.config.error.exception;

import com.ithotgi.springbootdeveloper.config.error.ErrorCode;
import org.aspectj.weaver.ast.Not;

public class NotFoundExcption extends BusinessBaseException{
    public NotFoundExcption(ErrorCode errorCode){
        super(errorCode.getMessage(), errorCode);
    }

    public NotFoundExcption(){
        super(ErrorCode.NOT_FOUND);
    }
}
