package com.tistory.sylphe;

import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserDaoTest {

    private UserDao userDao;


    @Before
    public void setup(){
        DaoFactory daoFactory = new DaoFactory();
        userDao = daoFactory.getUserDao();

    }

    @Test
    public void get() throws SQLException, ClassNotFoundException {
         int id=1;
        User user = userDao.get(id);

        assertThat(user.getId(), is(1));
        assertThat(user.getName(), is("헐크"));
        assertThat(user.getPassword(), is("1111"));

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
