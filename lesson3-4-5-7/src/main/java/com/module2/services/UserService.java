package com.module2.services;

import com.module2.daos.UserDao;
import com.module2.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService2")
public class UserService {

  @Autowired
  private UserDao userDao;

  public List<User> getUserList() {
    return userDao.getUserList();
  }
}
