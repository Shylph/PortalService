package com.tistory.sylphe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteUserStatementStrategy implements StatementStrategy {
    private final Integer id;

    public DeleteUserStatementStrategy(Integer id) {
        this.id = id;
    }

    @Override
    public PreparedStatement makeStatement(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("delete from jeju where id =? ");
        preparedStatement.setInt(1, id);
        return preparedStatement;
    }
}
