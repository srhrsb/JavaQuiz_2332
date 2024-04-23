package controller;

import dao.QuizDAO;
import model.Question;
import view.MainView;

import java.awt.event.ActionEvent;

public class MainController {

    private final MainView view;
    private final QuizDAO quizData;
    private int score = 0;

    public MainController(MainView view, QuizDAO quizData){
        this.view = view;
        this.quizData = quizData;
        nextQuestion(null);
        view.addAnswerButtonHandler( this::nextQuestion);
        view.addRadioButtonsHandler(this::enableAnswerButton);
    }

    public static void main(String[] args) {

        new MainController(
                new MainView(600, 300),
                new QuizDAO()
        );
    }

    private void nextQuestion( ActionEvent actionEvent ){
        Question question = quizData.getNextQuestion();
        if(question != null){
            int activeRadioButton = view.getActiveAnswer();
            if(activeRadioButton != -1){//bei Start wäre -1
                 int correct = question.getCorrect();
                 if(activeRadioButton == correct){
                     //die Antwort war richtig
                     this.score++;

                 }
//                 else{
//                     //die Antwort war falsch
//
//                 }
            }

            view.setAnswersText( question.getAnswersText() );
            view.setQuestionText( question.getQuestionText() );
            view.setScoreText(score);
        }
        else{
            //Ende der Fragen erreicht => Auswertung starten
        }
    }

private void enableAnswerButton(ActionEvent actionEvent){
   view.setAnswerButtonActivity(true);
}

private void evaluate(){}

}