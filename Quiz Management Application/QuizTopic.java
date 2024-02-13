package Quiz_Management_Applicatiion;

import java.util.ArrayList;

public class QuizTopic {
    private String topicName;
    private ArrayList<QuizQuestion> questions;

    public QuizTopic(String topicName){
        this.topicName = topicName;
        questions = new ArrayList<>();
    }
    public String getTopicName(){
        return topicName;
    }
    public ArrayList<QuizQuestion> getQuestions(){
        return questions;
    }
    public void addQuestion(QuizQuestion question){
        questions.add(question);
    }
}
