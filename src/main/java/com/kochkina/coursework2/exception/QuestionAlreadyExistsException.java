package com.kochkina.coursework2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class QuestionAlreadyExistsException extends RuntimeException {

    public QuestionAlreadyExistsException(){
    }

    public QuestionAlreadyExistsException(String message) {
        super(message);
    }

}
