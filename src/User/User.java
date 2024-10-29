package User;

import Task.Task;
import TaskList.TaskList;

public class User {
  private String firstName;
  private String lastName;
  private TaskList taskList;

  public User (String firstName, String lastName, Task task) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public void addTask (Task task) {
    if (taskList == null) {
      taskList = new TaskList(task);
    } else {
      taskList.addTask(task);
    }
  }


}
