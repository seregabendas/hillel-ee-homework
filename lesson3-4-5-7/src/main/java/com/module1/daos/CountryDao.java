package com.module1.daos;

import com.module1.models2.CountryEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("countryDao")
@Transactional
public class CountryDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<CountryEntity> getCountryList() {
        return entityManager.createQuery("from CountryEntity").getResultList();
    }


    public CountryEntity getCountryById(int id) {


        Query query = entityManager.createQuery("from CountryEntity where id= :id");
        query.setParameter("id", id);
        CountryEntity countryEntity = (CountryEntity) query.getSingleResult();

        return countryEntity;
    }

    public CountryEntity getCountryByName(String name) {
        Query query = entityManager.createQuery("from CountryEntity where name = :name");
        query.setParameter("name", name);
        List<CountryEntity> countryEntityList = query.getResultList();
        if (countryEntityList.size() == 0) {
            return null;
        }
        return countryEntityList.get(0);
    }

    public CountryEntity addCountry(CountryEntity countryEntity) {
        if (countryEntity.getId() == null) {
            entityManager.persist(countryEntity);
        } else {
            entityManager.merge(countryEntity);
        }
        return countryEntity;
    }


    public void deleteCountryById(Integer id) {
        CountryEntity countryEntity = entityManager.find(CountryEntity.class, id);
        entityManager.remove(countryEntity);
    }
}
