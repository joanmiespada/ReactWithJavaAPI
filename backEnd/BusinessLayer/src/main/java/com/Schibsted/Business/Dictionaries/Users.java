package com.Schibsted.Business.Dictionaries;

import com.Schibsted.Business.Context.IDataContext;
import com.Schibsted.Business.Entities.User;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by joanmi on 15/6/17.
 */
public class Users extends Dictionary implements IUsers {


    public List<User> GetAllUsers() throws Exception
    {
        List<User> result = new ArrayList<>();

        Statement stmt = null;

        if(this.ctx.getConnection()==null)
            throw new Exception("No connection opened");


        stmt = this.ctx.getConnection().createStatement();

        String sql = "SELECT ID,NAME,PASSWORD,ROLES FROM USER;";
        ResultSet rs = stmt.executeQuery(sql);
        while ( rs.next() ) {
            User foo = new User();
            foo.setId(rs.getInt("ID"));
            foo.setName(rs.getString("NAME"));
            foo.setPassword(rs.getString("PASSWORD"));
            foo.setRoles(rs.getString("ROLES"));

            result.add(foo);
        }
        rs.close();
        stmt.close();

        return result;
    }



}
