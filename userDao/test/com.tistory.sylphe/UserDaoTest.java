package com.tistory.sylphe;

import org.junit.Test;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class UserDaoTest {

    @Test
    public void get() throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDao();
        int id=1;
        User user = userDao.get(id);

        assertThat(user.getId(), is(1));

        assertThat(user.getName(), is("허윤호"));

        assertThat(user.getPassword(), is("1234"));

    }
}
