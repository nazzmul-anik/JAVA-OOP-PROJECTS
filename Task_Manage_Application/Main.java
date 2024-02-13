package Task_Manage_Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        TaskManager taskManager = new TaskManager();
        Scanner input = new Scanner(System.in);
        boolean running = true;

        while(running){
            System.out.println("-------------------****--------------------");
            System.out.println("Task Manager Menu: ");
            System.out.println("1. Add Task");
            System.out.println("2. View Task");
            System.out.println("3. Mark Task as Completed.");
            System.out.println("4. Delete Task");
            System.out.println("5. Filter Tasks by Completion Status");
            System.out.println("6. Save Tasks to File");
            System.out.println("7. Load Tasks to File");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();

            switch(choice){
                case 1:
                    System.out.print("Enter task name: ");
                    String taskName = input.nextLine();
                    System.out.print("Enter task description: ");
                    String taskDescription = input.nextLine();
                    System.out.print("Enter due date (YYYY-MM-DD): ");
                    String date = input.nextLine();
                    Date dueDate = new SimpleDateFormat("yyyy-mm-dd").parse(date);
                    taskManager.addTask(taskName, taskDescription, dueDate);
                    break;
                case 2:
                    taskManager.viewTasks();
                    break;
                case 3:
                    System.out.print("Enter the name of task: ");
                    String taskNameCompleted = input.nextLine();
                    taskManager.markTaskAsCompleted(taskNameCompleted);
                    break;
                case 4:
                    System.out.print("Enter task name to deleted: ");
                    String deleteTaskName = input.nextLine();
                    taskManager.deleteTask(deleteTaskName);
                    break;
                case 5:
                    System.out.print("Enter completion status (true/false): ");
                    boolean completeStatus = input.nextBoolean();
                    taskManager.filterTasks(completeStatus);
                    break;
                case 6:
                    System.out.print("Enter file name to save the task: ");
                    String saveFileName = input.nextLine();
                    taskManager.saveTasks(saveFileName);
                    break;
                case 7:
                    System.out.print("Enter file name to load tasks: ");
                    String loadFileName = input.nextLine();
                    taskManager.loadTasks(loadFileName);
                    break;
                case 8:
                    System.out.println("Thanks for use our 'Task Manager'!!1");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid Choice.");
            }
        }
        input.close();
    }
}
