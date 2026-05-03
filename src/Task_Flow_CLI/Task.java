package Task_Flow_CLI;

import java.util.Scanner;

public class Task {

    Scanner sc = new Scanner(System.in);

    private int ID;
    private String description;
    private int priority;
    private String category;
    private boolean isCompleted;
    private String title;

    Task (int ID, String description, int priority, String category, boolean isCompleted, String title) {

        this.ID = ID;
        this.description = description;
        this.category = category;
        this.priority = priority;
        this.isCompleted = isCompleted;
        this.title = title;
    }

    @Override
    public String toString() {
        return "[ ] ID: " + ID + " | " + description + " | Priority: " + priority + " | " +
                " Category: " + category + " | isCompleted: " + isCompleted;

    }

    public int getID() {
        return ID;

    }

    public boolean setID (int newID) {
        this.ID = newID;
        return false;
    }

    public String getDescription() {
        return description;

    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriority() {
        return priority;

    }

    public String getCategory() {
        return category;

    }

    public boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted (boolean completed){
        isCompleted = completed;
    }
}
