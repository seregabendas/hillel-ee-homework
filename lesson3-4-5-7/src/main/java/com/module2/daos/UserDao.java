package com.module2.daos;

import com.module2.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Repository("userDao2")
public class UserDao {

  @Autowired
  private CityDao cityDao;

  private List<User> userList;

  @PostConstruct
  public void init() {
    userList = Arrays.asList(
        new User("Bob", cityDao.getCityByIndex(0)),
        new User("Petya", cityDao.getCityByIndex(1)));
  }

  public List<User> getUserList() {
    return userList;
  }

}
