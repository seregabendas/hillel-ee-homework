package com.daos;

import com.models.User;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

  @Autowired
  CityDao cityDao;

  private List<User> userList = Arrays.asList(
      new User("Sergey", cityDao.getCityByIndex(0)),
      new User("Ivan", cityDao.getCityByIndex(1)));

  public List<User> getUserList() {
    return userList;
  }

}
