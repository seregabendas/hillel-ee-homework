package com.var3.test;

import com.var3.services.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserSystemTest {

  public static void main(String[] args) {
    ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
        "spring-application.xml");
    UserService userService = applicationContext.getBean("userService3", UserService.class);
    System.out.println(userService.getUserList1());
    System.out.println(userService.getUserList2());

  }
}
