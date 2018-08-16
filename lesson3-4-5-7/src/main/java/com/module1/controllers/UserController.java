package com.module1.controllers;

import com.module1.models2.UserEntity;
import com.module1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user-controller")
public class UserController {


  @Autowired
  UserService userService;

  @RequestMapping(value = "/users", method = RequestMethod.GET)
  public @ResponseBody List<UserEntity> gelAllUsers() {
    return userService.getUserList();
  }


}

