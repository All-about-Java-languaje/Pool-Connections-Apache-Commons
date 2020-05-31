package com;

import com.data.PoolConnectionsMySQL;
import com.data.PoolConnectionsOracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestPoolConnections {

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            //Test pool with MySQL
            connection = PoolConnectionsMySQL.getConnection();
            statement = connection.prepareStatement("SELECT * FROM user");
            resultSet = statement.executeQuery();
            System.out.println("MYSQL USE------------------------");
            while (resultSet.next()){
                System.out.println("Id_user: " + resultSet.getInt(1));
                System.out.println("Name: " + resultSet.getString(2));
                System.out.println("Password: " + resultSet.getString(3) + "\n");
            }
            connection.close();

            //Now we gonna test the pool for Oracle
            connection = PoolConnectionsOracle.getConnection();
            statement = connection.prepareStatement("SELECT * FROM employees WHERE employee_id in (100, 101, 102)");
            resultSet =  statement.executeQuery();
            System.out.println("ORACLE USE-----------------------");

            while (resultSet.next()){
                System.out.println("Id_user: " + resultSet.getInt(1));
                System.out.println("Name: " + resultSet.getString(2));
                System.out.println("Password: " + resultSet.getString(3) + "\n");
            }
            //Close connection  to return to pool
            connection.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
