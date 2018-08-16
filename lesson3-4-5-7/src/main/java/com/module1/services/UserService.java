package com.module1.services;

import com.module1.daos.UserDao;
import com.module1.models2.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  @Autowired
  private UserDao userDao;

  public List<UserEntity> getUserList() {
    return userDao.getUserList();
  }
}
