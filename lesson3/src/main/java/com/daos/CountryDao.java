package com.daos;

import com.models.Country;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository("countryDao")
public class CountryDao {

  private List<Country> countryList = Arrays.asList(new Country("Ukraine"), new Country("Russia"));

  public List<Country> getCountryList() {
    return countryList;
  }

  public Country getCountryByIndex(int index) {
    return countryList.get(index);
  }


}
