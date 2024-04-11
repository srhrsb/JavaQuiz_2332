package controller;

import view.MainView;

import java.awt.event.ActionEvent;

public class MainController {

    private final MainView view;

    public MainController(MainView view){
        this.view = view;
        this.view.setQuestionText("Wollen Sie dann Feierabend machen?");
    }

    public static void main(String[] args) {
        new MainController( new MainView(400, 200) );
    }

    private void showInfo( ActionEvent actionEvent ){

    }


}