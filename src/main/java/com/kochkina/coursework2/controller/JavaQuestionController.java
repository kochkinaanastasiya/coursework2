package com.kochkina.coursework2.controller;

import com.kochkina.coursework2.exception.QuestionAlreadyExistsException;
import com.kochkina.coursework2.exception.QuestionNotFoundException;
import com.kochkina.coursework2.model.QuestionForExam;
import com.kochkina.coursework2.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
        private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/add")
        public QuestionForExam addQuestion(
                @RequestParam String question,
                @RequestParam String answer) throws QuestionAlreadyExistsException {
        System.out.println("question" + question + "answer" + answer);
            return questionService.add(question, answer);
        }

        @DeleteMapping("/remove")
        public QuestionForExam removeQuestion(
                @RequestParam String question,
                @RequestParam String answer) throws QuestionNotFoundException {
            return questionService.remove(question, answer);
        }

        @GetMapping()
        public Collection<QuestionForExam> getAllQuestion() {
            return questionService.getAll();
        }
}
