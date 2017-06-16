package com.Schibsted.Business.Dictionaries;

import com.Schibsted.Business.Securities.*;
import com.Schibsted.Business.Entities.User;
import com.Schibsted.Business.Utils.CipherHelper;
import com.sun.tools.javac.util.Pair;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by joanmi on 15/6/17.
 */
public class Users extends Dictionary implements IUsers {


    public Pair< List<User>, Long> GetAllUsers(int page ,int pageSize ) throws Exception
    {
        List<User> result = new ArrayList<>();

        Statement stmt;

        if(this.ctx.getConnection()==null)
            throw new Exception("No connection opened");


        stmt = this.ctx.getConnection().createStatement();



        String sql = "SELECT ID,NAME,PASSWORD,ROLES FROM USER LIMIT "+page+", "+pageSize ;
        ResultSet rs = stmt.executeQuery(sql);
        while ( rs.next() ) {
            User foo = new User();
            foo.setId(rs.getLong("ID"));
            foo.setName(rs.getString("NAME"));
            foo.setPassword(rs.getString("PASSWORD"));
            foo.setRoles(rs.getString("ROLES"));

            result.add(foo);
        }
        rs.close();

        long totalItems = GetMaxId();

        stmt.close();

        Pair<List<User>,Long> res = new Pair< List<User> ,Long>(result,totalItems);

        return res;
    }

    protected long GetMaxId() throws Exception
    {
        Statement stmt = this.ctx.getConnection().createStatement();
        String sql = "SELECT COUNT(ID) FROM USER";
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        long result= rs.getLong(1);
        rs.close();
        return result;
    }


    public User Add(User user) throws Exception {
        Statement stmt = null;

        if (this.ctx.getConnection() == null)
            throw new Exception("No connection opened");

        long totalItems = GetMaxId();

        stmt = this.ctx.getConnection().createStatement();

        String passEncript = CipherHelper.Encript(user.getPassword());
        String sql = "INSERT INTO USER VALUES (" + ++totalItems + ", '" + user.getName() + "','" + passEncript + "','" + user.getRoles() + "')";
        stmt.executeUpdate(sql);

        User res = new User(user);
        res.setId(totalItems);
        res.setPassword(passEncript);

        stmt.close();

        return res;
    }

    public Boolean Delete(long id) throws Exception
    {
        Statement stmt = null;

        if (this.ctx.getConnection() == null)
            throw new Exception("No connection opened");

        stmt = this.ctx.getConnection().createStatement();

        String sql = "DELETE FROM USER WHERE ID="+id;
        stmt.executeUpdate(sql);

        stmt.close();

        return true;
    }

    public User FindById(long id)throws  Exception
    {
        Statement stmt;

        if(this.ctx.getConnection()==null)
            throw new Exception("No connection opened");

        stmt = this.ctx.getConnection().createStatement();


        String sql = "SELECT ID,NAME,PASSWORD,ROLES FROM USER WHERE ID= "+id ;
        ResultSet rs = stmt.executeQuery(sql);

        User foo;
        if(rs.next())
        {
            foo = new User();
            foo.setId(rs.getLong("ID"));
            foo.setName(rs.getString("NAME"));
            foo.setPassword(rs.getString("PASSWORD"));
            foo.setRoles(rs.getString("ROLES"));
        }
        else {

            rs.close();
            stmt.close();
            throw new Exception("Not found");

        }
        rs.close();
        stmt.close();

        return foo;

    }

    public void Update(long id, String name, String roles)throws  Exception
    {
        Statement stmt = null;

        if (this.ctx.getConnection() == null)
            throw new Exception("No connection opened");

        stmt = this.ctx.getConnection().createStatement();

        String sql = "UPDATE USER SET NAME='"+ name +"', ROLES='"+ roles  +"' WHERE ID="+ id  +";";
        stmt.executeUpdate(sql);

        stmt.close();

    }

    public List<User> FindByName(String name, int page ,int pageSize ) throws  Exception
    {
        List<User> result = new ArrayList<>();

        Statement stmt;

        if(this.ctx.getConnection()==null)
            throw new Exception("No connection opened");


        stmt = this.ctx.getConnection().createStatement();



        String sql = "SELECT ID,NAME,PASSWORD,ROLES FROM USER WHERE NAME LIKE'%"+name +"%' LIMIT "+page+", "+pageSize+";" ;
        ResultSet rs = stmt.executeQuery(sql);
        while ( rs.next() ) {
            User foo = new User();
            foo.setId(rs.getLong("ID"));
            foo.setName(rs.getString("NAME"));
            foo.setPassword(rs.getString("PASSWORD"));
            foo.setRoles(rs.getString("ROLES"));

            result.add(foo);
        }
        rs.close();

        //long totalItems = GetMaxId();

        stmt.close();

        //Pair<List<User>,Long> res = new Pair< List<User> ,Long>(result,totalItems);

        return result;
    }

    public User FindByNameAndPassword(String name, String passw)throws  Exception
    {
        Statement stmt;

        if(this.ctx.getConnection()==null)
            throw new Exception("No connection opened");

        stmt = this.ctx.getConnection().createStatement();


        String passEncript = CipherHelper.Encript(passw);
        String sql = "SELECT ID,NAME,PASSWORD,ROLES FROM USER WHERE NAME= '"+name+"' AND PASSWORD='"+passEncript+"'";
        ResultSet rs = stmt.executeQuery(sql);

        User foo;
        if(rs.next())
        {
            foo = new User();
            foo.setId(rs.getLong("ID"));
            foo.setName(rs.getString("NAME"));
            foo.setPassword(rs.getString("PASSWORD"));
            foo.setRoles(rs.getString("ROLES"));
        }
        else {

            rs.close();
            stmt.close();
            throw new Exception("Not found");

        }
        rs.close();
        stmt.close();

        return foo;

    }
}
