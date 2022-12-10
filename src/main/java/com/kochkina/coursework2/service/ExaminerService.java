package com.kochkina.coursework2.service;

import com.kochkina.coursework2.exception.NotFoundEnoughQuestionsException;
import com.kochkina.coursework2.model.QuestionForExam;

import java.util.Collection;

public interface ExaminerService {

    Collection<QuestionForExam> getQuestions(int amount) throws NotFoundEnoughQuestionsException;






}
