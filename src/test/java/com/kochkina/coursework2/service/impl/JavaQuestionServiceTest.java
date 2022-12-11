package com.kochkina.coursework2.service.impl;

import com.kochkina.coursework2.exception.QuestionAlreadyExistsException;
import com.kochkina.coursework2.exception.QuestionNotFoundException;
import com.kochkina.coursework2.model.QuestionForExam;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {

    private final JavaQuestionService javaQuestionService = new JavaQuestionService();

    @Test
    public void add1Test() {
        String question = "test ";
        String answer = "test";
        QuestionForExam q = new QuestionForExam(question,answer);
        javaQuestionService.add(question,answer);

        assertThatExceptionOfType(QuestionAlreadyExistsException.class)
                .isThrownBy(()-> javaQuestionService.add(new QuestionForExam(question,answer)));
        assertThat(javaQuestionService.getAll()).containsExactlyInAnyOrder(q);
    }

    @Test
    public void add2Test() {
        javaQuestionService.add(new QuestionForExam("test ", "test"));

        assertThatExceptionOfType(QuestionAlreadyExistsException.class)
                .isThrownBy(()-> javaQuestionService.add(new QuestionForExam("test ", "test")));
        assertThat(javaQuestionService.getAll())
                .containsExactlyInAnyOrder(new QuestionForExam("test ", "test"));
    }

    @Test
    public void removeTest() {
        javaQuestionService.add(new QuestionForExam("test ", "test"));
        javaQuestionService.remove(new QuestionForExam("test ", "test"));

        assertThatExceptionOfType(QuestionNotFoundException.class)
                .isThrownBy(()-> javaQuestionService.remove(new QuestionForExam("test ", "test")));
    }

    @ParameterizedTest
    @MethodSource("questions")
    public void getRandomQuestionTest(Set<QuestionForExam> questions) {
        questions.forEach(javaQuestionService::add);

        assertThat(javaQuestionService.getRandomQuestion()).isIn(javaQuestionService.getAll());
    }

    public static Stream<Arguments> questions(){
        return Stream.of(
                Arguments.of(
                        Set.of(
                                new QuestionForExam("Question1 ", "Answer1"),
                                new QuestionForExam("Question2 ", "Answer2"),
                                new QuestionForExam("Question3 ", "Answer3")
                        )
                )
        );
    }
}