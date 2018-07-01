package com.var2.services;

import com.dao.UserDaoI;
import com.models.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("userService2")
public class UserService {

  @Autowired
  @Qualifier("userDao1Ver2")
  private UserDaoI userDao1;

  @Autowired
  @Qualifier("userDao2Ver2")
  private UserDaoI userDao2;


  public List<User> getUserList1() {
    return userDao1.getUserList();
  }

  public List<User> getUserList2() {
    return userDao2.getUserList();
  }
}
