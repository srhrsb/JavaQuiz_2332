package dao;

import model.Question;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class QuizDAO {

    private List<Question> questionList = new ArrayList<>();

    public QuizDAO(){
        //ToDo laden der Daten von CSV Datei

        String csv = getTextFromCSV("C:\\Users/priva/javaQuiz.txt");
        System.out.println(csv);
    }

    private String getTextFromCSV( String file ){
        String csv = "";
        try {
            //Funktionalität die Fehler verursachen könnte
           csv = Files.readString( Path.of(file) );
           return csv;
        }
        catch ( IOException error){
            //Fehlerbehandlung
            System.out.println("Fehler: "+ error);
        }

        return csv;
    }




}
