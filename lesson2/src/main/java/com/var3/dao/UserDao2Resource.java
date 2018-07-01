package com.var3.dao;

import com.dao.UserDaoI;
import com.models.User;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao2Resource implements UserDaoI {

  private List<User> userList = Arrays.asList(new User("name312", 14), new User("name412", 15));

  public List<User> getUserList() {
    return userList;
  }
}
