package com.kochkina.coursework2.service.impl;

import com.kochkina.coursework2.exception.NotFoundEnoughQuestionsException;
import com.kochkina.coursework2.model.QuestionForExam;
import com.kochkina.coursework2.service.ExaminerService;
import com.kochkina.coursework2.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(JavaQuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<QuestionForExam> getQuestions(int amount) {
        if(amount < 1){
            throw new UnsupportedOperationException("Not valid amount value. Should be more than 1");
        }
        if(questionService.getAll().size()<amount){
            throw new NotFoundEnoughQuestionsException();
        }
        Set<QuestionForExam> result = new HashSet<>();
        while (result.size() < amount){
            result.add(questionService.getRandomQuestion());
        }
        return result;
    }
}
