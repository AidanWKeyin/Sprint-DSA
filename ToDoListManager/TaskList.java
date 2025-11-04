public class TaskList {
    Task head;

    public TaskList() {
        this.head = null;
    }

    public void addTask(String description) {
        Task newTask = new Task(description);
        if (head == null) {
            head = newTask;
        } else {
            Task current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTask;
        }
    }

    public void markTaskCompleted(String description) {
        Task current = head;
        while (current != null) {
            if (current.description.equalsIgnoreCase(description)) {
                current.markCompleted();
                System.out.println("Task \"" + description + "\" marked as completed.");
                return;
            }
            current = current.next;
        }
        System.out.println("Task \"" + description + "\" not found.");
    }

    public void printTasks() {
        Task current = head;
        if (current == null) {
            System.out.println("No tasks in this list.");
            return;
        }
        while (current != null) {
            System.out.println(" - " + current);
            current = current.next;
        }
    }
}
