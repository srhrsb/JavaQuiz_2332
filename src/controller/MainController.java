package controller;

import dao.QuizDAO;
import model.Question;
import view.MainView;

import java.awt.event.ActionEvent;

public class MainController {

    private final MainView view;
    private final QuizDAO quizData;

    public MainController(MainView view, QuizDAO quizData){
        this.view = view;
        this.quizData = quizData;
        nextQuestion(null);
        view.addAnswerButtonHandler( this::nextQuestion);
    }

    public static void main(String[] args) {

        new MainController(
                new MainView(400, 200),
                new QuizDAO()
        );
    }

    private void nextQuestion( ActionEvent actionEvent ){

        Question question = quizData.getNextQuestion();
        if(question != null){
            view.setAnswersText( question.getAnswersText() );
            view.setQuestionText( question.getQuestionText() );
        }
        else{
            //Ende der Fragen erreicht => Auswertung starten
        }
    }


    private void evaluate(){

    }

}