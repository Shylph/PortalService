package com.tistory.sylphe;


import java.sql.Connection;
import java.sql.SQLException;

interface ConnectionMaker {
    Connection getConnection() throws ClassNotFoundException, SQLException;
}