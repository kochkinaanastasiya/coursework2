package com.kochkina.coursework2.controller;

import com.kochkina.coursework2.exception.NotFoundEnoughQuestionsException;
import com.kochkina.coursework2.model.QuestionForExam;
import com.kochkina.coursework2.service.ExaminerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public Collection<QuestionForExam> getQuestions(@PathVariable int amount) throws NotFoundEnoughQuestionsException {
        return examinerService.getQuestions(amount);
    }
}
