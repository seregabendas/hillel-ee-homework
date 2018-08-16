package com.module1.services;

import com.module1.daos.CityDao;
import com.module1.models2.CityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

  @Autowired
  private CityDao cityDao;

  public List<CityEntity> getCityList() {
    return cityDao.getCityList();
  }

}
