package Task_Flow_CLI;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class TaskManager {


    public void removeTaskByID(ArrayList<Task> list, int idToRemove) {

        boolean found = false;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getID() == idToRemove) {
                list.remove(i);
                System.out.println("Task (ID: " + idToRemove + ") removed Successfully!");
                found = true;
                break;

            }
        }
        if (!found) {
            System.out.println("Task, ID: " + idToRemove + " is not found! ");
        }

    }

    public void markTaskAsCompleted(ArrayList<Task> list, int id) {
        boolean theStatus = false;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getID() == id) {
                list.get(i).setCompleted(true);
                System.out.println("Status changed...");

                theStatus = true;
                break;

            }
        }

        if (!theStatus) {
            System.out.println("Task, ID: " + id + " is not found! ");
        }
    }

    public void displayStatistics(ArrayList<Task> list) {

        int total = list.size();
        int completedCount = 0;
        int pendingCount = 0;

        for (Task t : list) {

            if (t.getCompleted()) {
                completedCount++;

            } else {
                pendingCount++;
            }
        }

        System.out.println("======== Statistics of Tasks ========\n");
        System.out.println("Total: " + total);
        System.out.println("Completed: " + completedCount);
        System.out.println("Not finished: " + pendingCount);

        if (total > 0) {
            double percent = (double) completedCount / total * 100;
            System.out.println("Progress: " + percent + "%");

        }
        System.out.println("----------------------------\n");

    }

    public void sortByPriority(ArrayList<Task> list) {

        System.out.println("Sorted List: \n");
        list.sort(Comparator.comparingInt(Task::getPriority));

        for (Task t : list) {
            System.out.println(t);
        }
    }

    public void searchTask(ArrayList<Task> list, String query) {

        boolean found = false;

        for (Task t : list) {
            String search = query.trim().toLowerCase();

            if (t.getTitle() != null && t.getTitle().toLowerCase().contains(search)) {
                System.out.println("Content is Found: ");
                System.out.println(t);
                found = true;
                System.out.println();

            }
        }

        if (!found) {
            System.out.println("Content is not Found!");
            System.out.println();
        }

    }
}

