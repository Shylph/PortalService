package com.tistory.sylphe;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserDaoTest {

    private UserDao userDao;


    @Before
    public void setup() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DaoFactory.class);
        userDao = applicationContext.getBean("userDao", UserDao.class);
    }

    @Test
    public void get() throws SQLException {
        int id = 1;
        User user = userDao.queryForObject(id);

        assertThat(user.getId(), is(1));
        assertThat(user.getName(), is("헐크"));
        assertThat(user.getPassword(), is("1111"));

    }

    @Test
    public void add() throws SQLException {
        User user = new User();
        user.setName("헐크");
        user.setPassword("1111");
        Integer id = userDao.insert(user);

        User insertedUser = userDao.queryForObject(id);

        assertThat(insertedUser.getId(), is(id));
        assertThat(insertedUser.getName(), is(user.getName()));
        assertThat(insertedUser.getPassword(), is(user.getPassword()));
    }

    @Test
    public void update() throws SQLException {
        User user = new User();
        user.setName("헐크");
        user.setPassword("1111");
        Integer id = userDao.insert(user);

        user.setId(id);
        user.setName("강상훈");
        user.setPassword("1234");
        userDao.update(user);

        User updatedUser = userDao.queryForObject(id);

        assertThat(updatedUser.getId(), is(updatedUser.getId()));
        assertThat(updatedUser.getName(), is(user.getName()));
        assertThat(updatedUser.getPassword(), is(user.getPassword()));
    }

    @Test
    public void delete() throws SQLException {
        User user = new User();
        user.setName("헐크");
        user.setPassword("1111");
        Integer id = userDao.insert(user);

        userDao.delete(id);

        User updatedUser = userDao.queryForObject(id);

        assertThat(updatedUser, nullValue());
    }
}
