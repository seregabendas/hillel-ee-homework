package com.var1.dao;

import com.dao.UserDaoI;
import com.models.User;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao2 implements UserDaoI {

  private List<User> userList = Arrays.asList(new User("name3", 14), new User("name4", 15));

  public List<User> getUserList() {
    return userList;
  }
}
