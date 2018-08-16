package com.module2.services;

import com.module2.daos.CityDao;
import com.module2.models.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cityService2")
public class CityService {

  @Autowired
  private CityDao cityDao;

  public List<City> getCityList() {
    return cityDao.getCityList();
  }

}
