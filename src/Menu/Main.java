package Menu;

import Task.Task;
import User.User;
import UserManager.UserManager;

public class Main {

  public static void main(String[] args) {
    UserManager userManager = new UserManager();
    createUser(userManager, "John", "Doe");
    createUser(userManager, "Jane", "Doe");
    createUser(userManager, "George", "Doe");
    createUser(userManager, "John", "Doe");
    System.out.println("\n" + userManager);

    addTasksToUser(1, userManager, "Doctors appointment", "Take out trash","Walk dog");
    addTasksToUser(2, userManager, "Put together chair", "Go for walk with son","Complete assignment");
    addTasksToUser(3, userManager, "Watch new episode of GoT", "Doctors appointment","Make supper");

    completeTask(1, 1, userManager, "John walked the dog.");
    completeTask(2,3, userManager, "Jane put the chair together.");
    completeTask(3, 2, userManager, "George went to his doctors appointment.");



  }

  private static void createUser(UserManager userManager, String firstName, String lastName) {
    System.out.println("Adding " + firstName + " " + lastName + " to the list.");
    if (userManager.addUser(firstName, lastName)) {
      System.out.println(firstName + " " + lastName + " added to the list.");
    } else {
      System.out.println("User not created, " + firstName + " " + lastName + " already used.");
    }
  }

  private static void addTasksToUser(int index, UserManager userManager, String task1, String task2, String task3) {
    System.out.println("Selecting User " + index + " from list.");
    User selectedUser = userManager.getUser(index);
    System.out.println("Adding tasks to selected user.");
    selectedUser.addTask(new Task(task1));
    selectedUser.addTask(new Task(task2));
    selectedUser.addTask(new Task(task3));
    System.out.println(selectedUser.getTaskList());
  }

  private static void completeTask(int userIndex, int taskIndex, UserManager userManager, String taskMessage) {
    System.out.println(taskMessage);
    User selectedUser = userManager.getUser(userIndex);
    selectedUser.getTaskList().markAsComplete(taskIndex);
    System.out.println(selectedUser.getTaskList());

  }
}
