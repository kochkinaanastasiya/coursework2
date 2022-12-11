package com.kochkina.coursework2.service.impl;

import com.kochkina.coursework2.exception.NotFoundEnoughQuestionsException;
import com.kochkina.coursework2.model.QuestionForExam;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    private final List<QuestionForExam> javaQuestions = new ArrayList<>();

    @BeforeEach
    public void beforeEach(){
        javaQuestions.clear();

        javaQuestions.addAll(
                Stream.of(
                        new QuestionForExam("Вопрос 1 ", "Ответ 1"),
                        new QuestionForExam("Вопрос 2 ", "Ответ 2"),
                        new QuestionForExam("Вопрос 3 ", "Ответ 3")
                ).collect(Collectors.toSet())
        );
        when(javaQuestionService.getAll()).thenReturn(javaQuestions);
    }

    @Test
    public void getQuestionsNegativeTest() {
        assertThatExceptionOfType(NotFoundEnoughQuestionsException.class)
                .isThrownBy(()-> examinerService.getQuestions(-1));
    }

    @Test
    public void getQuestionsPositiveTest() {
        when(javaQuestionService.getRandomQuestion()).thenReturn(
                new QuestionForExam("Вопрос 1 ", "Ответ 1"),
                new QuestionForExam("Вопрос 2 ", "Ответ 2"),
                new QuestionForExam("Вопрос 1 ", "Ответ 1"),
                new QuestionForExam("Вопрос 3 ", "Ответ 3")
        );

        assertThat(examinerService.getQuestions(1))
                .hasSize(1)
                .containsExactlyInAnyOrder(
                        new QuestionForExam("Вопрос 1 ", "Ответ 1"),
                        new QuestionForExam("Вопрос 2 ", "Ответ 2"),
                        new QuestionForExam("Вопрос 3 ", "Ответ 3")
                );
    }
}