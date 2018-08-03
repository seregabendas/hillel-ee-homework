package com.module1.controllers;

import com.module1.services.CountryService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CountryServlet extends HttpServlet {


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
        "spring-application.xml");
    CountryService countryService = applicationContext
        .getBean("countryService", CountryService.class);
    resp.getWriter().println(countryService.getCountryList());
  }

}
