package User;

import Task.Task;
import TaskList.TaskList;

public class User {
  private String firstName;
  private String lastName;
  private TaskList taskList;

  public User (String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
    taskList = new TaskList();
  }

  public void addTask (Task task) {
    taskList.addTask(task);
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public TaskList getTaskList() {
    return taskList;
  }

  public void setTaskList(TaskList taskList) {
    this.taskList = taskList;
  }

  @Override
  public String toString() {
    return this.firstName + " " + this.lastName;
  }
}
