package Task_Manage_Application;

import java.io.Serializable;
import java.util.Date;

public class Task implements Serializable {
    private String name;
    private String description;
    private Date dueDate;
    private boolean completed;

    //Set everything by Task Constructor
    public Task(String name, String description, Date dueDate){
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = false;
    }
    //Get everything by getMethod()
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public Date getDueDate(){
        return dueDate;
    }
    public void setCompleted(boolean completed){
        this.completed = completed;
    }
    public boolean isCompleted(){
        return completed;
    }

    @Override
    public String toString(){
        return "\nTask Name: "+name + "\nDescription: "+description+"\nDue Date: "+dueDate+"\nCompleted: "+completed;
    }
}
