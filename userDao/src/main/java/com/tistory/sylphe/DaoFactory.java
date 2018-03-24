package com.tistory.sylphe;

public class DaoFactory {
    private UserDao userDao;


    public UserDao getUserDao() {
        return new UserDao(getConnectionMaker());
    }

    private ConnectionMaker getConnectionMaker() {
        return new JejuConnectionMaker();
    }
}
