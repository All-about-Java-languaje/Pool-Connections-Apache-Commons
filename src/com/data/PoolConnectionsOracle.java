package com.data;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class PoolConnectionsOracle {
    public static DataSource getDataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        //When we use pool connections the library load Driver path automatically
        //dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUsername("HR");
        dataSource.setPassword("hr");
        dataSource.setUrl("jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=localhost)(PORT=1521)))(CONNECT_DATA=(SERVICE_NAME=xepdb1)))");

        //Again we gonna define the size for pool connections
        dataSource.setInitialSize(5);
        return dataSource;
    }

    public static Connection getConnection() throws SQLException{
        return getDataSource().getConnection();
    }
}
