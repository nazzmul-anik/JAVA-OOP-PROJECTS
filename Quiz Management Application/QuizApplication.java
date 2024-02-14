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
        System.out.println("For Quiz Available Topics Are: ");
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
            int answer = question.getAnswer();
            if(choice == question.getAnswer()){
                score++;
                System.out.println("Correct!");
            }else{
                System.out.println("Incorrect!");
                System.out.println("The Correct choice is : "+options[answer-1]);
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

        QuizTopic quizTopic3 = new QuizTopic("Database");
        quizTopic3.addQuestion(new QuizQuestion("What is the full form of DBMS?", new String[]{"Data of Binary Management System", "Database Management System", "Database Management Service", "Data Backup Management System"}, 2));
        quizTopic3.addQuestion(new QuizQuestion("What is DBMS?", new String[]{"DBMS is a collection of queries", "DBMS is a high-level language", "DBMS is a programming language", "DBMS stores, modifies and retrieves data"}, 4));
        quizTopic3.addQuestion(new QuizQuestion("In which of the following formats data is stored in the database management system?", new String[]{"Image", "Text", "Table", "Graph"}, 3));
        quizTopic3.addQuestion(new QuizQuestion("Which of the following is not an example of DBMS?", new String[]{"MySQL", "Microsoft Access", "IBM DB2", "Google"}, 4));
        quizTopic3.addQuestion(new QuizQuestion("Which command is used to remove a relation from an SQL?", new String[]{"Drop table", "Delete", "Purge", "Remove"}, 1));
        quizApplication.topics.add(quizTopic3);

        QuizTopic quizTopic4 = new QuizTopic("Networking");
        quizTopic4.addQuestion(new QuizQuestion(" What is a computer network?", new String[]{"A device used to display information on a computer screen", "A collection of interconnected computers and devices that can communicate and share resources", "A type of software used to create documents and presentations", "The physical casing that protects a computer’s internal components"}, 2));
        quizTopic4.addQuestion(new QuizQuestion("What is internet?", new String[]{"A network of interconnected local area networks", "A collection of unrelated computers", "Interconnection of wide area networks", "A single network"}, 3));
        quizTopic4.addQuestion(new QuizQuestion("What is the term for the data communication system within a building or campus?", new String[]{"MAN", "LAN", "PAN", "WAN"}, 2));
        quizTopic4.addQuestion(new QuizQuestion("Which network topology requires a central controller or hub?", new String[]{"Star","Mesh", "Ring", "Bus"}, 1));
        quizTopic4.addQuestion(new QuizQuestion("Which protocol assigns IP address to the client connected in the internet?", new String[]{"DHCP", "IP", "RPS", "RSVP"}, 1));
        quizApplication.topics.add(quizTopic4);

        QuizTopic quizTopic5 = new QuizTopic("Web Programming");
        quizTopic5.addQuestion(new QuizQuestion("HTML stands for __________", new String[]{"HyperText Markup Language", "HyperText Machine Language", "HyperText Marking Language", "HighText Marking Language"}, 1));
        quizTopic5.addQuestion(new QuizQuestion("What is the correct syntax of doctype in HTML5?", new String[]{"</doctype html>", "<doctype html>", "<doctype html!>", "<!doctype html>"}, 4));
        quizTopic5.addQuestion(new QuizQuestion("Which technology is primarily responsible for the styling of web pages?", new String[]{"JavaScript", "HTML", "CSS", "Python"}, 3));
        quizTopic5.addQuestion(new QuizQuestion("Which programming language is mainly used for adding interactivity to websites?", new String[]{"HTML", "CSS", "JavaScript", "Python"}, 3));
        quizTopic5.addQuestion(new QuizQuestion("Which part of web development is responsible for handling data storage and retrieval?", new String[]{"Front-end development", "Back-end development", "Full-stack development", "Middleware development"}, 2));
        quizApplication.topics.add(quizTopic5);

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
