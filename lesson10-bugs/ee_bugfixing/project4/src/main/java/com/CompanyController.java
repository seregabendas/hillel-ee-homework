package com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/test")
public class CompanyController {

  //>>>>> should render on welcome.jsp page;
  @RequestMapping("/page")
  public String getPage() {
    return "/WEB-INF/pages/welcome.jsp";
  }
}
