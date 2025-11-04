public class Task {
    String description;
    boolean completed;
    Task next; // for linked list

    public Task(String description) {
        this.description = description;
        this.completed = false;
        this.next = null;
    }

    public void markCompleted() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return description + " [" + (completed ? "Completed" : "Pending") + "]";
    }
}
