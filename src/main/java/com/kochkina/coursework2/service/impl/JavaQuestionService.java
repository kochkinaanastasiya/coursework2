package com.kochkina.coursework2.service.impl;

import com.kochkina.coursework2.exception.QuestionAlreadyExistsException;
import com.kochkina.coursework2.exception.QuestionNotFoundException;
import com.kochkina.coursework2.model.QuestionForExam;
import com.kochkina.coursework2.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {

    private final Random random = new Random();
    private final List<QuestionForExam> questionForExamList = new ArrayList<>();

    @Override
    public QuestionForExam add(String question, String answer) {
        QuestionForExam questionForExam = new QuestionForExam(question, answer);
        System.out.println("question" + questionForExam.getQuestion() + "answer" + questionForExam.getAnswer());
        return add(questionForExam);
    }

    @Override
    public QuestionForExam add(QuestionForExam questionForExam) {
        if(questionForExamList.contains(questionForExam)){
            throw new QuestionAlreadyExistsException();
        } else {
            System.out.println("добавляем");
            questionForExamList.add(questionForExam);
            return questionForExam;
        }
    }

    @Override
    public QuestionForExam remove (String question, String answer) {
        QuestionForExam questionForExam = new QuestionForExam(question, answer);
        return remove(questionForExam);
    }

    @Override
    public QuestionForExam remove (QuestionForExam questionForExam) {
        if(!questionForExamList.contains(questionForExam)){
            throw new QuestionNotFoundException();
        } else {
            questionForExamList.remove(questionForExam);
            return questionForExam;
        }
    }

    @Override
    public Collection<QuestionForExam> getAll(){
        return new ArrayList<>(questionForExamList);
    }

    @Override
    public QuestionForExam getRandomQuestion(){
        return questionForExamList.get(random.nextInt(0,questionForExamList.size()));
    }
}
