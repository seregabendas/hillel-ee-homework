package com.var3.dao;

import com.dao.UserDaoI;
import com.models.User;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao1Resource implements UserDaoI {

  private List<User> userList = Arrays.asList(new User("name112", 12), new User("name212", 13));

  public List<User> getUserList() {
    return userList;
  }
}
