public class User {
    String name;
    TaskList taskList;

    public User(String name) {
        this.name = name;
        this.taskList = new TaskList();
    }

    public void addTask(String description) {
        taskList.addTask(description);
    }

    public void markTaskCompleted(String description) {
        taskList.markTaskCompleted(description);
    }

    public void printAllTasks() {
        System.out.println("\nTasks for user: " + name);
        taskList.printTasks();
    }
}
