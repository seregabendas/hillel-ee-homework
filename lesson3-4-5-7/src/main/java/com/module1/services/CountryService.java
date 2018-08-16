package com.module1.services;

import com.module1.daos.CountryDao;
import com.module1.models2.CountryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

  @Autowired
  private CountryDao countryDao;

  public List<CountryEntity> getCountryList() {
    return countryDao.getCountryList();
  }

}
