package Task_Flow_CLI;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int idCounter = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        String desc = "";
        int prio = 0;
        String category = "";
        String title = "";

        Task formerTask = new Task(idCounter++, desc, prio, category, false, title);

        String command = "";
        String message = "Begin to work (Type 'BEGIN')";

        ArrayList<Task> taskList = new ArrayList<>();

        System.out.println("Code is running...");
        System.out.println(message);

        command = scanner.nextLine();
        System.out.println();
        System.out.println("Program is Activated...\n");

        while (!command.equalsIgnoreCase("CLose")) {
            command = scanner.nextLine().trim();

            if (command.trim().equalsIgnoreCase("Add")) {

                    System.out.println("Enter Task title: ");
                    title = scanner.nextLine();

                    System.out.print("Enter the task: ");
                    desc = scanner.nextLine();

                    System.out.println("Priority (1-5)");
                    prio = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Category: (Study, Home, Work...)");
                    category = scanner.nextLine();

                    formerTask = new Task(idCounter++, desc, prio, category, false, title);

                taskList.add(formerTask);
                System.out.println();
                System.out.println("<<< Tasks are added >>>\n");

                for (Task t : taskList) {
                    System.out.println(t);
                }
                System.out.println("---------------------------------------------------");
                System.out.println();

            }

            else if (command.trim().equalsIgnoreCase("Remove")) {

                System.out.println("Which task you wanna remove? \n Enter the ID: ");
                int removeId = scanner.nextInt();
                System.out.println(removeId);
                scanner.nextLine();

                manager.removeTaskByID(taskList, removeId);

                System.out.println();

                System.out.println("Remaining tasks: \n");
                for (Task a : taskList) {
                    System.out.println(a);
                }
                System.out.println();

                // (Failed!)
            }

            else if (command.trim().equalsIgnoreCase("Status")) {

                System.out.println("Which task's status you wanna change? \n Enter the ID: ");
                int statusID = scanner.nextInt();
                System.out.println(statusID);
                scanner.nextLine();

                System.out.println("Enter the status: ");

                String statusChange = scanner.nextLine();
                System.out.println(statusChange);
                System.out.println();
                for (Task f : taskList) {
                    System.out.println(f);
                }
                System.out.println();


                if (statusChange.equalsIgnoreCase("Done") ||
                        statusChange.equalsIgnoreCase("Completed")) {

                    manager.markTaskAsCompleted(taskList, statusID);

                    System.out.println();

                    System.out.println("Status of Tasks: \n");
                    for (Task c : taskList) {
                        System.out.println(c);

                    }
                }
                System.out.println();

            }

            else if (command.trim().equalsIgnoreCase("Stats")) {

                manager.displayStatistics(taskList);

                System.out.println("Statistics of Tasks: \n");

                for (Task e : taskList) {
                    System.out.println(e);
                }
                System.out.println();


            }

            else if (command.trim().equalsIgnoreCase("Sort")) {

                manager.sortByPriority(taskList);
                System.out.println();

            }

            else if (command.trim().equalsIgnoreCase("Search")) {

                System.out.println("Which task are you searching for? Enter some info: ");
                String search = scanner.nextLine();
                System.out.println(search);

                manager.searchTask(taskList, search);
                System.out.println();


            }
        }
    }
}