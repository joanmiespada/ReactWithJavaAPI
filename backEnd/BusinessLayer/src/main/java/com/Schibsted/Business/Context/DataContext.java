package com.Schibsted.Business.Context;

/**
 * Created by joanmi on 15/6/17.
 */

import lombok.Getter;

import java.sql.*;

public class DataContext implements IDataContext {

    protected Connection connection = null;

    public Connection getConnection(){ return this.connection; }

    public void Open() throws Exception
    {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:database.db");
        } catch ( Exception e ) {
            //System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            throw e; // new Exception(e);
        }
    }

    public void Close() throws Exception
    {
        try {
            if (connection != null) {
                connection.close();
            }
        }catch (SQLException e)
        {
            throw new Exception(e);
        }
    }




}
