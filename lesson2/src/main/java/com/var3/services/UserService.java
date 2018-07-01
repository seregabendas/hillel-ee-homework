package com.var3.services;

import com.dao.UserDaoI;
import com.models.User;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("userService3")
public class UserService {

  @Resource
  private UserDaoI userDao1Resource;

  @Resource(name="userDao2Resource")
  private UserDaoI userDao2;


  public List<User> getUserList1() {
    return userDao1Resource.getUserList();
  }

  public List<User> getUserList2() {
    return userDao2.getUserList();
  }
}
