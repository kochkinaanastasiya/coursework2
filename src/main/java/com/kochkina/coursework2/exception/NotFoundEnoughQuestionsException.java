package com.kochkina.coursework2.exception;

public class NotFoundEnoughQuestionsException extends RuntimeException {

    public NotFoundEnoughQuestionsException(){
    }

    public NotFoundEnoughQuestionsException(String message) {
        super(message);
    }
}
