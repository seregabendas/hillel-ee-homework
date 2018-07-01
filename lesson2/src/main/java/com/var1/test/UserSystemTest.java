package com.var1.test;

import com.var1.services.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserSystemTest {

  public static void main(String[] args) {
    ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
        "spring-application.xml");
    UserService userService = applicationContext.getBean("userService1", UserService.class);
    System.out.println(userService.getUserList1());
    System.out.println(userService.getUserList2());

  }
}
