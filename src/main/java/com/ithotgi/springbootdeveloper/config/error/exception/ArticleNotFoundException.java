package com.ithotgi.springbootdeveloper.config.error.exception;

import com.ithotgi.springbootdeveloper.config.error.ErrorCode;

public class ArticleNotFoundException extends BusinessBaseException{

    public ArticleNotFoundException(){
        super(ErrorCode.ARTICLE_NOT_FOUND);
    }
}
