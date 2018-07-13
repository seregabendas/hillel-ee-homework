package com.services;

import com.daos.UserDao;
import com.models.User;
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
