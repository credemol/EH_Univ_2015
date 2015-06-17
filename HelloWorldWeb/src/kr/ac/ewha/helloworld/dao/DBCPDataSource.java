package kr.ac.ewha.helloworld.dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class DBCPDataSource {

    private static DBCPDataSource     datasource;
    private BasicDataSource ds;

    private DBCPDataSource() throws IOException, SQLException, PropertyVetoException {
        ds = new BasicDataSource();
        ds.setDriverClassName("org.apache.derby.jdbc.ClientDriver");
        //ds.setUsername("root");
        //ds.setPassword("root");
        ds.setUrl("jdbc:derby://localhost:1527/seconddb;create=true");
       
     // the settings below are optional -- dbcp can work with defaults
        ds.setInitialSize(10);
        ds.setMinIdle(5);
        ds.setMaxIdle(20);
        ds.setMaxOpenPreparedStatements(180);
        
        

    }

    public static DBCPDataSource getInstance() throws IOException, SQLException, PropertyVetoException {
        if (datasource == null) {
            datasource = new DBCPDataSource();
            return datasource;
        } else {
            return datasource;
        }
    }

    public Connection getConnection() throws SQLException {
        return this.ds.getConnection();
    }

}