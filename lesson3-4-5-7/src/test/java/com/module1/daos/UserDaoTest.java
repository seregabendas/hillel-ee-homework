package com.module1.daos;

import com.module1.models2.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/resources/spring-application-test.xml")
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void shouldGetUserList() {
        List<UserEntity> userList = userDao.getUserList();
        assertThat(userList.size(), is(6));
    }

    @Test
    public void shouldGetUserById() {
        UserEntity userById = userDao.getUserById(1);
        assertThat(userById.getId(), is(1));
        UserEntity userById1 = userDao.getUserById(7);
        assertThat(userById1 == null, is(true));
    }

    @Test
    public void shouldGetAllUsersByName() {
        List<UserEntity> allUsersByName = userDao.getAllUsersByName("Sergey");
        assertThat(allUsersByName.size(), is(1));
    }

    @Test
    @Transactional
    public void shouldAddUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setName("Sergey");
        userDao.addUser(userEntity);
        List<UserEntity> allUsersByName = userDao.getAllUsersByName("Sergey");
        assertThat(allUsersByName.size(), is(2));

    }

    @Test
    @Transactional
    public void shouldDeleteUserById() {
        UserEntity userById = userDao.getUserById(1);
        assertThat(userById == null, is(false));
        userDao.deleteUserById(1);
        UserEntity userById1 = userDao.getUserById(1);
        assertThat(userById1 == null, is(true));


    }
}