package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainView extends JFrame {

    private JButton answerButton;

    private JRadioButton radioButton1, radioButton2, radioButton3, radioButton4;

    private JLabel questionLabel, answer1, answer2, answer3, answer4;

    public MainView(int width, int height){

        setSize(width, height);
        setTitle("Java Quiz");
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        setVisible(true);
        addUIComponents();
    }

    /**
     *Erstellt eine Nutzeroberflaeche
     */
    private void addUIComponents(){
        //Panel erzeugen
        JPanel topPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        JPanel radioButtonPanel = new JPanel();

        //dem Fenster die erzeugten Panel hinzufügen
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(radioButtonPanel, BorderLayout.WEST);
        add(bottomPanel, BorderLayout.SOUTH);

        //Center Panel bekommt flexibles Gridlayout
        centerPanel.setLayout(new GridLayout(4, 1));
        centerPanel.setBorder( new EmptyBorder(5, 5, 5, 5));

        radioButtonPanel.setLayout(new GridLayout(4, 1));
        radioButtonPanel.setBorder( new EmptyBorder(5, 5, 5, 5));

        //Label erzeugen und topPanel hinzufügen
        questionLabel = new JLabel("Frage");
        topPanel.add(questionLabel);

        //Button erzeugen und dem bottomPanel hinzufügen
        answerButton = new JButton("Antworten");
        bottomPanel.add(answerButton);

        //Radio Buttons erzeugen
        radioButton1 = new JRadioButton("A");
        radioButton2 = new JRadioButton("B");
        radioButton3 = new JRadioButton("C");
        radioButton4 = new JRadioButton("D");

        ButtonGroup radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(radioButton1);
        radioButtonGroup.add(radioButton2);
        radioButtonGroup.add(radioButton3);
        radioButtonGroup.add(radioButton4);

        //Label mit Antwortmoeglichkeiten
        answer1 = new JLabel("Antwort 1");
        answer2 = new JLabel("Antwort 2");
        answer3 = new JLabel("Antwort 3");
        answer4 = new JLabel("Antwort 4");

        radioButtonPanel.add(radioButton1);
        centerPanel.add(answer1);
        radioButtonPanel.add(radioButton2);
        centerPanel.add(answer2);
        radioButtonPanel.add(radioButton3);
        centerPanel.add(answer3);
        radioButtonPanel.add(radioButton4);
        centerPanel.add(answer4);
    }

    public void setQuestionText(String question){
          questionLabel.setText(question);
    }

    public void setAnswersText( String[] answers){
        //ToDo Antworten an TextLabel übergeben
    }

    public void addAnswerButtonHandler( ActionListener listener){
        //ToDo Lister an den Antwort übergeben
    }













    /**
     * Fügt einen Eventlistener hinzu, der auf die Methode verweist
     * in dem die eigentliche Funktionalität ausgeführt wird
     */
    public void addInfoButtonHandler( ActionListener listener)
    {
       // openInfo.addActionListener(listener);
    }


    /**
     * Zeigt ein Information für den Nutzer in einem Infofenster
     * @param text - Text der angezeigt werden soll
     */
    public void showInfoWindow( String text){
        JOptionPane.showMessageDialog(this, text, "Information", JOptionPane.ERROR_MESSAGE);
    }

    public boolean confirmWindow(String text){
        return JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, text, "Bitte bestätige!",JOptionPane.YES_NO_OPTION);
    }




}