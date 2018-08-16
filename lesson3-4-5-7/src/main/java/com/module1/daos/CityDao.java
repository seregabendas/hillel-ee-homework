package com.module1.daos;

import com.module1.models2.CityEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class CityDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<CityEntity> getCityList() {
        return entityManager.createQuery("from CityEntity").getResultList();
    }


    public CityEntity getCityById(int id) {
        Query query = entityManager.createQuery("from CityEntity where id= :id");
        query.setParameter("id", id);
        List<CityEntity> cityEntityList =  query.getResultList();

        if (cityEntityList.size()==0) {
            return null;
        }
        return cityEntityList.get(0);
    }

    public List<CityEntity> getAllCitiesByName(String name) {
        Query query = entityManager.createQuery("from CityEntity where name = :name");
        query.setParameter("name", name);
        List<CityEntity> resultList = query.getResultList();
        return resultList;
    }

    public CityEntity addCity(CityEntity cityEntity) {

        if (cityEntity.getId() == null) {
            entityManager.persist(cityEntity);
        } else {
            entityManager.merge(cityEntity);
        }
        return cityEntity;
    }


    public void deleteCityById(Integer id) {
        CityEntity cityEntity = entityManager.find(CityEntity.class, id);
        entityManager.remove(cityEntity);
    }
}
