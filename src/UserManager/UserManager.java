package UserManager;

import User.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserManager {
  private ArrayList<User> users;

  public UserManager () {
    users = new ArrayList<>();
  }

  public boolean addUser(String firstName, String lastName) {
    if (checkNameUniqueness(firstName, lastName)) {
      users.add(new User(firstName, lastName));
      return true;
    }
    return false;
  }

  public User getUser(int index) {
    if (index > users.size() || index <= 0) {
      throw new ArrayIndexOutOfBoundsException();
    }
    return users.get(index - 1);
  }

  private boolean checkNameUniqueness(String firstName, String lastName) {
    for (User user : users) {
      if (user.getFirstName().equals(firstName) && user.getLastName().equals(lastName)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public String toString() {
    String results = "User List:\n";
    int counter = 1;
    for (User user : users) {
      results += counter + ".) " + user + "\n";
      counter++;
    }
    return results;
  }
}
