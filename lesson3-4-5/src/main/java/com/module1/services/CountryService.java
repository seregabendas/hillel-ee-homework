package com.module1.services;

import com.module1.daos.CountryDao;
import com.module1.models.Country;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

  @Autowired
  CountryDao countryDao;

  public List<Country> getCountryList() {
    return countryDao.getCountryList();
  }

}
