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

    private List<Question> questionList = new ArrayList<>();

    public QuizDAO( String file ){

        String csvText = getTextFromCSV( file );

        if(csvText == null) return;
        questionList = parseCSV(csvText);
        System.out.println( questionList);

    }

    private String getTextFromCSV( String file ){

        String csv = "";

        try {
           csv = Files.readString( Path.of(file) );
           return csv;
        }
        catch ( IOException error){
            System.out.println("Fehler: "+ error);
        }
        return null;
    }

    private List<Question> parseCSV( String csv){

        List<Question>  list = new ArrayList<>();
        String[] lines = csv.split("[\\r\\n]+");

        for( String line : lines){
            String[] words = line.split(",");

            String[] answers = { words[1], words[2], words[3], words[4] };
            int correct = Integer.parseInt(words[5]);

            Question question = new Question( words[0], answers, correct );

            list.add( question );
        }
        return list;
    }

    public Question getNextQuestion() {
        try {
            Question question = questionList.getFirst();
            questionList.remove( question );
            return question;
        }
        catch (Exception e){
            return null;
        }
    }
}
