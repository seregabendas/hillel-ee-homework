package com.var1.services;

import com.dao.UserDaoI;
import com.models.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService1")
public class UserService {

  @Autowired
  private UserDaoI userDao1;

  @Autowired
  private UserDaoI userDao2;


  public List<User> getUserList1() {
    return userDao1.getUserList();
  }

  public List<User> getUserList2() {
    return userDao2.getUserList();
  }
}
