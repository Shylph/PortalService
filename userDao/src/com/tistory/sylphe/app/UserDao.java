package com.tistory.sylphe.app;

import java.sql.*;


public class UserDao {
    public User get(int id) throws SQLException, ClassNotFoundException {


        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.0.54/jeju", "jeju", "jejupw");
        PreparedStatement preparedStatement = connection.prepareStatement("select * from userinfo where id=?");
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));

        resultSet.close();
        preparedStatement.close();
        connection.close();
        return user;
    }
}
