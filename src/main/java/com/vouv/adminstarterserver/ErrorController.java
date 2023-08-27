package com.vouv.adminstarterserver;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(Exception.class)
    public Resp ExceptionHandler(Exception e) {
        return Resp.fail(e.getMessage());
    }

}
