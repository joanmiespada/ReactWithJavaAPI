package com.Schibsted.Business.Context;

import java.sql.Connection;

/**
 * Created by joanmi on 15/6/17.
 */
public interface IDataContext {

    void Open() throws Exception;
    void Close() throws Exception;
    Connection getConnection();
}
