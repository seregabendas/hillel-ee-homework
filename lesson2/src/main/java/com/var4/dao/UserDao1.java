package com.var4.dao;

import com.dao.UserDaoI;
import com.models.User;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository("userDao3")
public class UserDao1 implements UserDaoI {

  private List<User> userList = Arrays.asList(new User("name1123", 12), new User("name2123", 13));

  public List<User> getUserList() {
    return userList;
  }
}
