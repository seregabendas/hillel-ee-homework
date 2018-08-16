package com.module1.daos;

import com.module1.models2.UserEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<UserEntity> getUserList() {
        return entityManager.createQuery("from UserEntity").getResultList();
    }


    public UserEntity getUserById(int id) {
        Query query = entityManager.createQuery("from UserEntity where id= :id");
        query.setParameter("id", id);
        List<UserEntity> userEntityList = query.getResultList();

        if (userEntityList.size() == 0) {
            return null;
        }
        return userEntityList.get(0);
    }

    public List<UserEntity> getAllUsersByName(String name) {
        Query query = entityManager.createQuery("from UserEntity where name = :name");
        query.setParameter("name", name);
        return (List<UserEntity>) query.getResultList();
    }

    public UserEntity addUser(UserEntity userEntity) {
        if (userEntity.getId() == null) {
            entityManager.persist(userEntity);
        } else {
            entityManager.merge(userEntity);
        }
        return userEntity;
    }


    public void deleteUserById(Integer id) {
        UserEntity userEntity = entityManager.find(UserEntity.class, id);
        entityManager.remove(userEntity);
    }
}
