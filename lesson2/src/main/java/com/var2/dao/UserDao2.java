package com.var2.dao;

import com.dao.UserDaoI;
import com.models.User;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository("userDao2Ver2")
public class UserDao2 implements UserDaoI {

  private List<User> userList = Arrays.asList(new User("name31", 14), new User("name41", 15));

  public List<User> getUserList() {
    return userList;
  }
}
