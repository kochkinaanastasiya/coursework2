package com.kochkina.coursework2.model;

public class QuestionForExam {

    private final String question;
    private final String answer;


    public QuestionForExam(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion(){
        return question;
    }

    public String getAnswer(){
        return answer;
    }

    @Override
    public String toString(){
        return String.format("Вопрос, ответ");
    }
}
