package com.module1.daos;

import com.module1.models.Country;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository("countryDao")
public class CountryDao {

  private List<Country> countryList = Arrays.asList(new Country(1, "Ukraine"), new Country(2, "Russia"));

  public List<Country> getCountryList() {
    return countryList;
  }

  public Country getCountryByIndex(int index) {
    return countryList.get(index);
  }


}
