package com.kochkina.coursework2.model;

import java.util.Objects;

public class QuestionForExam {

    private final String question;
    private final String answer;

    public QuestionForExam(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        QuestionForExam that = (QuestionForExam) o;
        return Objects.equals(getQuestion(), that.getQuestion()) && Objects.equals(getAnswer(), that.getAnswer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuestion(), getAnswer());
    }

    public String getQuestion(){
        return question;
    }

    public String getAnswer(){
        return answer;
    }

    @Override
    public String toString(){
        return String.format("Вопрос %s, ответ %s",question,answer);
    }
}
