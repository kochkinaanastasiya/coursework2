package com.kochkina.coursework2.service;

import com.kochkina.coursework2.exception.QuestionAlreadyExistsException;
import com.kochkina.coursework2.exception.QuestionNotFoundException;
import com.kochkina.coursework2.model.QuestionForExam;

import java.util.Collection;

public interface QuestionService {

    QuestionForExam add(String question, String answer) throws QuestionAlreadyExistsException;

    QuestionForExam add(QuestionForExam questionForExam) throws QuestionAlreadyExistsException;

    QuestionForExam remove (String question, String answer) throws QuestionNotFoundException;

    QuestionForExam remove (QuestionForExam questionForExam) throws QuestionNotFoundException;

    Collection<QuestionForExam>getAll();

    QuestionForExam getRandomQuestion();





}

