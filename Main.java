import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User[] users = new User[5];
        int userCount = 0;

        while (true) {
            System.out.println("\n=== TO-DO LIST MANAGER ===");
            System.out.println("1. Add User");
            System.out.println("2. Add Task");
            System.out.println("3. Mark Task Completed");
            System.out.println("4. View Tasks");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    if (userCount >= users.length) {
                        System.out.println("User limit reached.");
                        break;
                    }
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    users[userCount++] = new User(username);
                    System.out.println("User added: " + username);
                    break;

                case 2:
                    System.out.print("Enter username: ");
                    username = scanner.nextLine();
                    User user = findUser(users, userCount, username);
                    if (user != null) {
                        System.out.print("Enter task description: ");
                        String task = scanner.nextLine();
                        user.addTask(task);
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter username: ");
                    username = scanner.nextLine();
                    user = findUser(users, userCount, username);
                    if (user != null) {
                        System.out.print("Enter task description to mark completed: ");
                        String taskDesc = scanner.nextLine();
                        user.markTaskCompleted(taskDesc);
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 4:
                    for (int i = 0; i < userCount; i++) {
                        users[i].printAllTasks();
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static User findUser(User[] users, int count, String name) {
        for (int i = 0; i < count; i++) {
            if (users[i].name.equalsIgnoreCase(name)) {
                return users[i];
            }
        }
        return null;
    }
}
