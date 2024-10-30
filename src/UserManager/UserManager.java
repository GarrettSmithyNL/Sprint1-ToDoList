package UserManager;

import User.User;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
  private List<User> users;

  public UserManager () {
    users = new ArrayList<>();
  }

  public void addUser(User user) {
    users.add(user);
  }
  public User getUser(int index) {
    if (index > users.size() || index <= 0) {
      throw new ArrayIndexOutOfBoundsException();
    }
    return users.get(index - 1);
  }
}
