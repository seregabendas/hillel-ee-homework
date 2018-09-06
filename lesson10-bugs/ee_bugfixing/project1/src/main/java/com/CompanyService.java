package com;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
 //please use Resource for spring inject
public class CompanyService {

  @Resource
  private CompanyDAO companyDAO;

  public List getAllCompanies() {
    return companyDAO.getAllCompanies();
  }
}
