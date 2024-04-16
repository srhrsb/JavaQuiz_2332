package controller;

import dao.QuizDAO;
import view.MainView;

import java.awt.event.ActionEvent;

public class MainController {

    private final MainView view;
    private final QuizDAO quizData;

    public MainController(MainView view, QuizDAO quizData){
        this.view = view;
        this.quizData = quizData;

    }

    public static void main(String[] args) {

        new MainController(
                new MainView(400, 200),
                new QuizDAO()
        );
    }

    private void showInfo( ActionEvent actionEvent ){

    }


}