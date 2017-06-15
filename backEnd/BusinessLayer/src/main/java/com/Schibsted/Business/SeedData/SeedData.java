package com.Schibsted.Business.SeedData;

import com.Schibsted.Business.Context.DataContext;
import com.Schibsted.Business.Context.IDataContext;
import com.Schibsted.Business.Utils.CipherHelper;
import lombok.NonNull;

import java.sql.Statement;

/**
 * Created by joanmi on 15/6/17.
 */
public class SeedData {

    private IDataContext ctx = null;

    public SeedData(IDataContext ctx)
    {
        this.ctx = ctx;
    }

    protected void CreateTable() throws Exception
    {
        Statement stmt = null;

        if(ctx.getConnection()==null)
            throw new Exception("No connection opened");

        stmt = this.ctx.getConnection().createStatement();

        String sql = "DROP TABLE IF EXISTS USER";
        stmt.executeUpdate(sql);

        sql = "CREATE TABLE USER " +
                "(ID INT PRIMARY KEY     NOT NULL," +
                " NAME           TEXT    NOT NULL, " +
                " PASSWORD       TEXT    NOT NULL, " +
                " ROLES          TEXT)";
        stmt.executeUpdate(sql);
        stmt.close();
    }



    protected void InsertFirstData() throws Exception
    {
        Statement stmt = null;

        if(this.ctx.getConnection()==null)
            throw new Exception("No connection opened");

        stmt = this.ctx.getConnection().createStatement();

        String  sql = "INSERT INTO USER VALUES (1, 'Jhon',    '"+ CipherHelper.Encript("123456")+ "','admin')";stmt.executeUpdate(sql);
        sql = "INSERT INTO USER VALUES (2, 'Michael', '"+ CipherHelper.Encript("123456")+ "','page1')";stmt.executeUpdate(sql);
        sql = "INSERT INTO USER VALUES (3, 'Sword',   '"+ CipherHelper.Encript("123456")+ "','page2')";stmt.executeUpdate(sql);
        sql = "INSERT INTO USER VALUES (4, 'Black',   '"+ CipherHelper.Encript("123456")+ "','page3')";stmt.executeUpdate(sql);
        sql = "INSERT INTO USER VALUES (5, 'Ruben',   '"+ CipherHelper.Encript("123456")+ "','page1,page2')";stmt.executeUpdate(sql);

        stmt.close();
    }

    public void SeedData()throws Exception
    {
        CreateTable();
        InsertFirstData();
    }

}
