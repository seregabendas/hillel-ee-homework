package com.module1.services;

import com.module1.daos.UserDao;
import com.module1.models.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  UserDao userDao;

  public List<User> getUserList() {
    return userDao.getUserList();
  }
}
