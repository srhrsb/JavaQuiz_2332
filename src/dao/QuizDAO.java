package dao;

import model.Question;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuizDAO {

    //enthält alle Fragen vom Quiz
    private List<Question> questionList = new ArrayList<>();

    public QuizDAO(){
        //ToDo laden der Daten von CSV Datei

         //es wird der Text der CSV Datei geholt
        String csvText = getTextFromCSV("C:\\Users/priva/javaQuiz.txt");

        //übergabe des Textes an unseren Parser, der uns die Liste der Fragen
        //zurückgibt
        if(csvText == null) return;
        questionList = parseCSV(csvText);
        System.out.println( questionList);

    }

    private String getTextFromCSV( String file ){
        //wir erzeugen einen leeren String
        String csv = "";

        //da solche Operation(Dateisystem, Server, etc.) Fehler verursachen können
        //muss eine Fehlerbehandlung erfolgen
        try {
            //Funktionalität die Fehler verursachen könnte
           csv = Files.readString( Path.of(file) );
           return csv;
        }
        catch ( IOException error){
            //Fehlerbehandlung
            System.out.println("Fehler: "+ error);
        }
        return null;
    }

    private List<Question> parseCSV( String csv){

        List<Question>  list = new ArrayList<>();
        //Text in Zeilen aufteilen, mit Angabe des Trenners
        //für den Zeilenumbruch
        String[] lines = csv.split("[\\r\\n]+");

        for( String line : lines){
            String[] words = line.split(",");
            //Object von Question erzeugen
            //Object der List zuweisen
            String[] answers = { words[1], words[2], words[3], words[4] };
            int correct = Integer.parseInt(words[5]);
            //Erzeugen des Question-Objektes
            // mit den geparsten Daten
            Question question = new Question( words[0], answers, correct );
            //Das Objekt der Liste hinzufügen
            list.add( question );
        }
        return list;
    }

    public Question getNextQuestion() {
        Question question = questionList.getFirst();
        questionList.remove( question );
        return question;
    }


}
