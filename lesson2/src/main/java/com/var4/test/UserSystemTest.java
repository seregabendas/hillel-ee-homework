package com.var4.test;

import com.var4.services.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserSystemTest {

  public static void main(String[] args) {
    ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
        "spring-application.xml");
    UserService userService = applicationContext.getBean("userService4", UserService.class);
    System.out.println(userService.getUserList1());
    System.out.println(userService.getUserList2());

  }
}
