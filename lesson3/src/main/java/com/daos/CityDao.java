package com.daos;

import com.models.City;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CityDao {

  @Autowired
  CountryDao countryDao;

  private List<City> cityList = Arrays.asList(
      new City("Odessa", countryDao.getCountryByIndex(0)),
      new City("Moscow", countryDao.getCountryByIndex(1)));

  public List<City> getCityList() {
    return cityList;
  }

  public City getCityByIndex(int index) {
    return cityList.get(index);
  }

}
