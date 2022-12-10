package com.kochkina.coursework2.exception;

public class QuestionAlreadyExistsException extends RuntimeException {

    public QuestionAlreadyExistsException(){
    }

    public QuestionAlreadyExistsException(String message) {
        super(message);
    }

}
