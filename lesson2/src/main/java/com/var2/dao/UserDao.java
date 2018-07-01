package com.var2.dao;

import com.dao.UserDaoI;
import com.models.User;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository("userDao1Ver2")
public class UserDao implements UserDaoI {

  private List<User> userList = Arrays.asList(new User("name11", 12), new User("name21", 13));

  public List<User> getUserList() {
    return userList;
  }
}
