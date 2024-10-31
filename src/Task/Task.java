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
    return this.isComplete;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    String results = "";
    results += this.description;
    if(isComplete) { results += " - Completed"; }
    return results + "\n";
  }
}
