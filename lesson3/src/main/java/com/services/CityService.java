package com.services;

import com.daos.CityDao;
import com.models.City;
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
