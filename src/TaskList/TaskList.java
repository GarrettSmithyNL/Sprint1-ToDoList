package TaskList;

import Task.Task;

public class TaskList {
  private Node head;
  private int taskListSize;

  public TaskList () {
    taskListSize = 0;
  }

  public void addTask (Task task) {
    Node newNode = new Node(task);
    if (taskListSize == 0) {
      this.head = newNode;
    } else {
      newNode.setNextNode(head);
      head = newNode;
    }
    taskListSize++;
  }

  public boolean markAsComplete (int index) {
    try {
      getSelectedNodeAtIndex(index).getValue().completeTask();
      return true;
    } catch (ArrayIndexOutOfBoundsException e) {
      return false;
    }
  }

  private Node getSelectedNodeAtIndex(int index) {
    if (index > taskListSize || index < 1) throw new ArrayIndexOutOfBoundsException();
    int counter = 1;
    Node selectedNode = head;
    while (counter < index) {
      selectedNode = selectedNode.getNextNode();
      counter++;
    }
    return selectedNode;
  }

  @Override
  public String toString() {
    String results = "Task List: \n";
    int counter = 1;
    Node selectedNode = this.head;
    while (counter <= taskListSize) {
      results += counter + ".) " + selectedNode.getValue();
      selectedNode = selectedNode.getNextNode();
      counter++;
    }
    return results;
  }



  private class Node {
    private Node nextNode;
    private final Task value;

    public Node (Task value) {
      this.value = value;
    }

    public void setNextNode (Node newNextNode) {
      this.nextNode = newNextNode;
    }

    public Task getValue() {
      return this.value;
    }

    public Node getNextNode() {
      return this.nextNode;
    }
  }
}
