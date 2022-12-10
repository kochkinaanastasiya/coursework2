package com.kochkina.coursework2.service.impl;

import com.kochkina.coursework2.exception.NotFoundEnoughQuestionsException;
import com.kochkina.coursework2.model.QuestionForExam;
import com.kochkina.coursework2.service.ExaminerService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final JavaQuestionService javaQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public Collection<QuestionForExam> getQuestions(int amount) throws NotFoundEnoughQuestionsException {
        if(javaQuestionService.getAll().size()<amount){
            throw new NotFoundEnoughQuestionsException();
        }
        Set<QuestionForExam> questions = new HashSet<>();
        while (questions.size() < amount){
            questions.add(javaQuestionService.getRandomQuestion());
        }
        return questions;
    }
}
