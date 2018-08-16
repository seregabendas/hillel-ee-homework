package com.module1.daos;

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
public class CountryDaoTest {

    @Test
    public void emptyTestMethod() {

    }

    @Autowired
    CountryDao countryDao;

    @Test
    public void shouldGetCountryList() {
        List<CountryEntity> countryList = countryDao.getCountryList();
        assertThat(countryList.size(), is(1));

    }

    @Test
    @Transactional
    public void shouldAddCountry() {
        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setName("China");
        //countryEntity.setId(3);
        countryDao.addCountry(countryEntity);
        List<CountryEntity> countryList = countryDao.getCountryList();
        assertThat(countryList.size(), is(2));
    }

    @Test
    public void shouldGetById() {
        int id = 1;
        CountryEntity countryById = countryDao.getCountryById(id);
        assertThat(countryById.getId(), is(id));
    }

    @Test
    public void shouldGetByName() {
        String name = "Ukraine";
        CountryEntity countryEntity = countryDao.getCountryByName(name);
        assertThat(countryEntity.getName(), is(name));
    }

    @Test
    @Transactional
    public void shouldDelete() {

        int result1 = countryDao.getCountryList().size();

        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setName("China");
        CountryEntity addCountry = countryDao.addCountry(countryEntity);
        int result2 = countryDao.getCountryList().size();
        assertThat(result2, is(result1 + 1));

        countryDao.deleteCountryById(addCountry.getId());
        int result3 = countryDao.getCountryList().size();
        assertThat(result3, is(result2 - 1));
    }
}