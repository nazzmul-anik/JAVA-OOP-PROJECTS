package Quiz_Management_Applicatiion;

import java.util.ArrayList;
import java.util.Scanner;

public class QuizApplication implements Quiz{
    private ArrayList<QuizTopic> topics;

    public QuizApplication(){
        topics = new ArrayList<>();
    }

    @Override
    public void displayAvailableTopic() {
        System.out.println("Available Topics: ");
       for(int i=0; i<topics.size(); i++){
            System.out.println((i+1)+". "+topics.get(i).getTopicName());
        }
    }
    @Override
    public void startQuiz(QuizTopic quizTopic){
        int score = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("\nWelcome to the '"+quizTopic.getTopicName()+"' quiz!\n");
        for(QuizQuestion question : quizTopic.getQuestions()){
            System.out.println(question.getQuestion());
            String[] options = question.getOptions();
            for(int i=0; i<options.length; i++){
                System.out.println((i+1)+". "+options[i]);
            }
            System.out.print("\nEnter your choice: ");
            int choice = input.nextInt();
            if(choice == question.getAnswer()){
                score++;
                System.out.println("Correct!");
            }else{
                System.out.println("Incorrect!");
                System.out.println("The Correct choice is : "+options[choice-1]);
            }
            System.out.println();
        }

        System.out.println("Quiz Completed!");
        System.out.println("Your score is : "+score+"/"+quizTopic.getQuestions().size());
    }

    public static void main(String[] args) {
        QuizApplication quizApplication = new QuizApplication();
        Scanner input = new Scanner(System.in);

        QuizTopic quizTopic1 = new QuizTopic("Java Basic");
        quizTopic1.addQuestion(new QuizQuestion("Who Invented Java Programming?", new String[]{"Guido van Rossum", "Dennis Ritchie", "James Gosling", "Bjarne Stroustrup"}, 3));
        quizTopic1.addQuestion(new QuizQuestion("Which one of the following is not a Java feature?", new String[]{"Object-oriented", "Use of pointers", "Portable", "Dynamic and Extensible"}, 2));
        quizTopic1.addQuestion(new QuizQuestion("What is the extension of java code files?", new String[]{".js", ".txt", ".class", ".java"}, 4));
        quizTopic1.addQuestion(new QuizQuestion("Which of the following is not an OOPS concept in Java?", new String[]{"Polymorphism", "Inheritance","Compilation", "Encapsulation"}, 3));
        quizTopic1.addQuestion(new QuizQuestion("Which of the following is a superclass of every class in Java?", new String[]{"Object class", "Abstract class", "ArrayList", "String"}, 1));
        quizApplication.topics.add(quizTopic1);

        QuizTopic quizTopic2 = new QuizTopic("Data Structures");
        quizTopic2.addQuestion(new QuizQuestion("What is a data structure?", new String[]{"A way to store and organize data", "A programming language", "An Algorithm", "A Network Protocol"}, 1));
        quizTopic2.addQuestion(new QuizQuestion("What is an array?", new String[]{"A dynamic data structure", "A non-linear data structure", "A hierarchical data structure", "A linear data structure"}, 4));
        quizTopic2.addQuestion(new QuizQuestion("Which data structure represents a collection of key-value pairs?", new String[]{"Queue", "Stack", "Hash Table", "Tree"}, 3));
        quizTopic2.addQuestion(new QuizQuestion("What is the best-case time complexity of the binary search algorithm?", new String[]{"O(1)", "O(log n)", "O(n)", "O(n^2)"},2));
        quizTopic2.addQuestion(new QuizQuestion("Java is pure Object Oriented Programming Language?", new String[]{"True", "False"}, 2));
        quizApplication.topics.add(quizTopic2);

        quizApplication.displayAvailableTopic();
        System.out.print("Choose Quiz topic number: ");
        int choice = input.nextInt();

        if(choice<1 || choice>quizApplication.topics.size()){
            System.out.println("\nYou choose invalid quiz option.");
            return;
        }
        QuizTopic seletedTopic = quizApplication.topics.get(choice-1);

        quizApplication.startQuiz(seletedTopic);

    }
}
