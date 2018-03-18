package com.tistory.sylphe;

import main.java.sylphe.User;
import main.java.sylphe.UserDao;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class UserDaoTest {

    private UserDao userDao;

    @Before
    public void setup(){
        userDao = new UserDao();
    }

    @Test
    public void get() throws SQLException, ClassNotFoundException {
        int id=1;
        User user = userDao.get(id);

        assertThat(user.getId(), is(1));
        assertThat(user.getName(), is("허윤호"));
        assertThat(user.getPassword(), is("1234"));

    }

    @Test
    public void add() throws SQLException, ClassNotFoundException {
        User user = new User();
        user.setName("헐크");
        user.setPassword("1111");
        Integer id = userDao.insert(user);

        User insertedUser = userDao.get(id);

        assertThat(insertedUser.getId(), is(id));
        assertThat(insertedUser.getName(), is(user.getName()));
        assertThat(insertedUser.getPassword(), is(user.getPassword()));
    }
}