package model;

public class Question {


    //4 Antworten, 1Frage, welche Antwort ist richtig

    private String questionText;
    private String[] answersText;
    private int correct;

    public Question(String questionText, String[] answersText, int correct) {
        this.questionText = questionText;
        this.answersText = answersText;
        this.correct = correct;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String[] getAnswersText() {
        return answersText;
    }

    public void setAnswersText(String[] answersText) {
        this.answersText = answersText;
    }

    public int getCorrect() {
        return this.correct;
    }
    public void setCorrect(int correct) {
        this.correct = correct;
    }
}
