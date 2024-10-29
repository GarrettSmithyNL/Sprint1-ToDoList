package Task;

public class Task {
  private String description;
  private boolean isComplete;

  public Task (String description) {
    this.description = description;
    this.isComplete = false;
  }

  public void completeTask() {
    this.isComplete = true;
  }

  public boolean isComplete() {
    return isComplete;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
