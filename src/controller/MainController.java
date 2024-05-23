package controller;

import dao.QuizDAO;
import model.Question;
import view.MainView;

import java.awt.event.ActionEvent;

public class MainController {

    private final MainView view;
    Question currentQuestion;

    private QuizDAO quizData;
    private int score = 0;

    public MainController(MainView view){
        this.view = view;
        startQuiz("quizData/javaQuiz.txt");
        view.addAnswerButtonHandler( this::nextQuestion);
        view.addRadioButtonsHandler(this::enableAnswerButton);
    }

    public static void main(String[] args) {
        new MainController(
                new MainView(600, 300)
        );
    }

    private void nextQuestion( ActionEvent actionEvent ){

        view.setAnswerButtonActivity( false );
        int activeRadioButton = view.getActiveAnswer();

        if(activeRadioButton != -1 && currentQuestion != null){//bei Start wäre -1

            if(activeRadioButton == currentQuestion.getCorrect())
                this.score++;
        }

        view.setScoreText(score);

        currentQuestion = quizData.getNextQuestion();

        if(currentQuestion != null){
            view.setAnswersText( currentQuestion.getAnswersText() );
            view.setQuestionText( currentQuestion.getQuestionText() );
        }
        else{
            evaluate(score);
        }

        view.uncheckAllRadioButtons();
    }

    private void enableAnswerButton(ActionEvent actionEvent){
            view.setAnswerButtonActivity(true);
    }

    private void startQuiz( String file ){
        quizData = new QuizDAO(file);
        nextQuestion(null);
    }

    private void evaluate( int score ){
        String message = "Du hast es geschafft!\n";
        message +="Richtig beantwortete Fragen: "+score+"\n\n";
        message +="Möchtest Du nochmal spielen?\n\n";

        if(view.confirmWindow(message)){
            startQuiz("quizData/javaQuiz.txt");
        }
        else{
            System.exit(0);
        }
    }

}