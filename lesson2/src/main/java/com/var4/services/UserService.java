package com.var4.services;

import com.models.User;
import com.var4.dao.UserDao1;
import com.var4.dao.UserDao2;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService4")
public class UserService {

  //by Name; by Type
  @Resource
  private UserDao1 userDao3;

  //by Type; by Name
  @Autowired
  private UserDao2 userDao1;


  public List<User> getUserList1() {
    return userDao3.getUserList();
  }

  public List<User> getUserList2() {
    return userDao1.getUserList();
  }
}
