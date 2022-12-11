package com.kochkina.coursework2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundEnoughQuestionsException extends RuntimeException {

    public NotFoundEnoughQuestionsException(){
    }

    public NotFoundEnoughQuestionsException(String message) {
        super(message);
    }
}
