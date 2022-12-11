package com.kochkina.coursework2.service;

import com.kochkina.coursework2.model.QuestionForExam;

import java.util.Collection;

public interface QuestionService {

    QuestionForExam add(String question, String answer);

    QuestionForExam add(QuestionForExam questionForExam);

    QuestionForExam remove (String question, String answer);

    QuestionForExam remove (QuestionForExam questionForExam);

    Collection<QuestionForExam>getAll();

    QuestionForExam getRandomQuestion();





}

