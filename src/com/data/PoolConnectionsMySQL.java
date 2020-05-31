package com.data;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class PoolConnectionsMySQL {

    public static DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        //When we use pool connections the library load Driver path automatically
        //dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        dataSource.setUrl("jdbc:mysql://localhost/person?useSSL=false&serverTimezone=UTC");

        //Definimos el tamaño del pool de conexiones
        dataSource.setInitialSize(5);
        return dataSource;
    }

    public static Connection getConnection() throws SQLException{
        return getDataSource().getConnection();
    }
}
