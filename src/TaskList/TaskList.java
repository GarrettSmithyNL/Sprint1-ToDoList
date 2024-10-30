package TaskList;

import Task.Task;

public class TaskList {
  private Node head;
  private Node tail;
  private int taskListSize;

  public TaskList (Task task) {
    Node newNode = new Node(task);
    this.head = newNode;
    this.tail = newNode;
    taskListSize = 1;
  }

  public boolean addTask (Task task) {
    Node newNode = new Node(task);
    newNode.setNextNode(head);
    head = newNode;
    return true;
  }

  public boolean removeTask(int index) {
    try {
      Node selectedNode = getSelectedNodeAtIndex(index);
      Node previousNode = getPreviousNodeToSelected(index);
      previousNode.setNextNode(selectedNode.getNextNode());
      return true;
    } catch (ArrayIndexOutOfBoundsException e) {
      return false;
    }
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
    while (counter <= index) {
      selectedNode = selectedNode.getNextNode();
      counter++;
    }
    return selectedNode;
  }

  private Node getPreviousNodeToSelected(int indexOfSelected) {
    return getSelectedNodeAtIndex(indexOfSelected - 1);
  }

  @Override
  public String toString() {
    String results = "";
    int counter = 1;
    Node selectedNode = head;
    while (counter <= taskListSize) {
      results += counter + ".) " + selectedNode.getValue().getDescription() + "\n";
      selectedNode = selectedNode.getNextNode();
    }
    return results;
  }



  private class Node {
    private Node nextNode;
    private Task value;

    public Node (Task value) {
      this.value = value;
      this.nextNode = null;
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
