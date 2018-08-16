package com.module2.services;

import com.module2.daos.CountryDao;
import com.module2.models.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("countryService2")
public class CountryService {

  @Autowired
  private CountryDao countryDao;

  public List<Country> getCountryList() {
    return countryDao.getCountryList();
  }

}
