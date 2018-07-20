package com.module2.controllers;

import com.module2.models.User;
import com.module2.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("userController2")
@RequestMapping("/user-controller2")
public class UserController {

  @Autowired
  UserService userService;


  @RequestMapping(value = "/users", method = RequestMethod.GET)
  public @ResponseBody List<User> getAllUsers() {
    return userService.getUserList();
  }

}
