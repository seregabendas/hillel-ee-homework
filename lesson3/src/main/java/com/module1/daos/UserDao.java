package com.module1.daos;

import com.module1.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Repository
public class UserDao {

  @Autowired
  CityDao cityDao;

  private List<User> userList;

  @PostConstruct
  public void init() {
    userList = Arrays.asList(
        new User(1, "Sergey", cityDao.getCityByIndex(0)),
        new User(2, "ivan", cityDao.getCityByIndex(1)));
  }

  public List<User> getUserList() {
    return userList;
  }

}
