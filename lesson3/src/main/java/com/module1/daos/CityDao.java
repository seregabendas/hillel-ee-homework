package com.module1.daos;

import com.module1.models.City;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CityDao {

  @Autowired
  CountryDao countryDao;

  private List<City> cityList/* = Arrays.asList(
      new City("Odessa", countryDao.getCountryByIndex(0)),
      new City("Moscow", countryDao.getCountryByIndex(1)))*/;
  @PostConstruct
  public void init() {
    cityList = Arrays.asList(
        new City("Odessa", countryDao.getCountryByIndex(0)),
        new City("Moscow", countryDao.getCountryByIndex(1)));
  }
  public List<City> getCityList() {
    return cityList;
  }

  public City getCityByIndex(int index) {
    return cityList.get(index);
  }

}
