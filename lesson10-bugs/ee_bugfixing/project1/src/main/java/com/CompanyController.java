package com;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CompanyController {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
            "spring-resource/spring-application.xml");
        CompanyService service = applicationContext.getBean(CompanyService.class);
        List allCompanies = service.getAllCompanies();
        System.out.println(allCompanies);
    }
}
