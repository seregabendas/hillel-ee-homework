package com.module1.services;

import com.module1.daos.CityDao;
import com.module1.models.City;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

  @Autowired
  CityDao cityDao;

  public List<City> getCityList() {
    return cityDao.getCityList();
  }

}
