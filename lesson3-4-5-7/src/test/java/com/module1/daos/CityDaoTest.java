package com.module1.daos;

import com.module1.models2.CityEntity;
import com.module1.models2.CountryEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/resources/spring-application-test.xml")
public class CityDaoTest {

    @Autowired
    private CityDao cityDao;

    @Autowired
    private CountryDao countryDao;
    @Test
    public void shouldGetCityList() {
        List<CityEntity> cityList = cityDao.getCityList();
        assertThat(cityList.size(), is(3));
    }

    @Test
    public void shouldGetCityById() {
        int id = 2;
        CityEntity cityById = cityDao.getCityById(id);
        assertThat(cityById.getId(), is(id));
    }

    @Test
    @Transactional
    public void shouldGetAllCitiesByName() {

        CountryEntity countryEntity = countryDao.getCountryById(1);
        String cityName = "TestName";
        CityEntity cityEntity1 = new CityEntity();
        cityEntity1.setName(cityName);
        cityEntity1.setCountry(countryEntity);
        cityDao.addCity(cityEntity1);
        CityEntity cityEntity2 = new CityEntity();
        cityEntity2.setName(cityName);
        cityEntity2.setCountry(countryEntity);
        cityDao.addCity(cityEntity2);
        List<CityEntity> allCitiesByName = cityDao.getAllCitiesByName(cityName);
        assertThat(allCitiesByName.size(), is(2));
    }

    @Test
    @Transactional
    public void shouldAddCity() {
        int size1 = cityDao.getCityList().size();
        CountryEntity countryById = countryDao.getCountryById(1);
        CityEntity cityEntity = new CityEntity();
        cityEntity.setCountry(countryById);
        cityEntity.setName("Test");
        cityDao.addCity(cityEntity);
        int size2 = cityDao.getCityList().size();
        assertThat(size2, is(size1 + 1));

        CityEntity cityEntity2 = new CityEntity();
        cityEntity2.setCountry(countryById);
        cityEntity2.setName("Test");
        cityDao.addCity(cityEntity2);
        int size3 = cityDao.getCityList().size();
        assertThat(size3, is(size2 + 1));

        CityEntity cityEntity3 = new CityEntity();
        cityEntity3.setCountry(countryById);
        cityEntity3.setName("Test");
        cityEntity3.setId(cityEntity2.getId());
        cityDao.addCity(cityEntity3);
        int size4 = cityDao.getCityList().size();
        assertThat(size4, is(size3));


    }

    @Test
    @Transactional
    public void shouldDeleteCityById() {
        CountryEntity countryById = countryDao.getCountryById(1);
        CityEntity cityEntity = new CityEntity();
        cityEntity.setName("Test");
        cityEntity.setCountry(countryById);
        cityDao.addCity(cityEntity);
        CityEntity cityById = cityDao.getCityById(cityEntity.getId());
        assertThat(cityById, is(cityEntity));
        cityDao.deleteCityById(cityById.getId());
        CityEntity cityById1 = cityDao.getCityById(cityById.getId());
        assertThat(cityById1 == null, is(true));
    }
}