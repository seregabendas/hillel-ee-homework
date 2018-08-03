package com.module2.services;

import com.module2.daos.CityDao;
import com.module2.models.City;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("cityService2")
public class CityService {

  @Autowired
  CityDao cityDao;

  public List<City> getCityList() {
    return cityDao.getCityList();
  }

}
