package com.module2.services;

import com.module2.daos.UserDao;
import com.module2.models.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService2")
public class UserService {

  @Autowired
  UserDao userDao;

  public List<User> getUserList() {
    return userDao.getUserList();
  }
}
