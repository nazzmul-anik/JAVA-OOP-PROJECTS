package Task_Manage_Application;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class TaskManager {
    private HashMap<String, Task> tasks;
    public TaskManager(){
        tasks = new HashMap<>();
    }

    // add task feature is adding name as key, and task as value
    public void addTask(String name, String description, Date dueDate){
        Task task = new Task(name, description, dueDate);
        tasks.put(name, task);
    }

    // view task feature is view all task are in list
    public void viewTasks(){
        if(tasks.isEmpty()){
            System.out.println("No tasks found.");
            return;
        }
        for(Task task : tasks.values()){
            System.out.println(task.toString());
        }
        System.out.println();
    }

    // mark as completed feature is to check that: task are completed or not
    public void markTaskAsCompleted(String name){
        Task task = tasks.get(name);
        if(task != null){
            task.setCompleted(true);
            System.out.println("Task marked as completed: "+task.getName());
        }else{
            System.out.println("Task not found.");
        }
    }

    // delete task feature is to delete the task
    public void deleteTask(String name){
        Task task = tasks.remove(name);
        if(task != null){
            System.out.println("Task deleted: "+task.getName());
        }else{
            System.out.println("Task not found.");
        }
    }

    // filter task feature is based on their completion status
    public void filterTasks(boolean completed){
        ArrayList<Task> filteredTask = new ArrayList<>();
        for(Task task : tasks.values()){
            if(task.isCompleted()==completed){
                filteredTask.add(task);
            }
        }

        if(filteredTask.isEmpty()){
            System.out.println("No tasks found.");
            return;
        }

        System.out.println("Filtered tasks: ");
        for(Task task: filteredTask){
            System.out.println(task.toString());
        }
    }

    // save task
    public void saveTasks(String fileName){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))){
            out.writeObject(tasks);
            System.out.println("Task saved to file: "+fileName);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    // load task
    public void loadTasks(String fileName){
        try(ObjectInputStream in = new ObjectInputStream (new FileInputStream(fileName))){
            tasks = (HashMap<String, Task>) in.readObject();
            System.out.println("Tasks loaded from file: "+fileName);
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

    }
}
