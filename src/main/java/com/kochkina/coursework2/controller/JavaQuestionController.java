package com.kochkina.coursework2.controller;

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

    @GetMapping("/add")
        public QuestionForExam addQuestion(
                @RequestParam String question,
                @RequestParam String answer) {
        System.out.println("question" + question + "answer" + answer);
            return questionService.add(question, answer);
        }

        @GetMapping("/remove")
        public QuestionForExam removeQuestion(
                @RequestParam String question,
                @RequestParam String answer) {
            return questionService.remove(question, answer);
        }

        @GetMapping()
        public Collection<QuestionForExam> getAllQuestion() {
            return questionService.getAll();
        }
}
