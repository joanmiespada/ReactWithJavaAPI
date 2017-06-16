package com.Schibsted.Business.Service;
import com.Schibsted.Business.Entities.User;
import com.Schibsted.Business.Securities.RoleChecker;
import com.Schibsted.Business.Securities.Roles;
import com.sun.tools.javac.util.Pair;

import java.util.List;

/**
 * Created by joanmi on 16/6/17.
 */
public class Users extends com.Schibsted.Business.Dictionaries.Users implements IUsers {


  /*  public Pair<List<User>, Long> GetAllUsers(long WhoUserId, int page, int pageSize) throws Exception
    {
       User who = this.FindById(WhoUserId);
       RoleChecker.VerifyRole(who, Roles.ADMIN);
       return this.GetAllUsers(page,pageSize);
    }*/

    public User Add(long WhoUserId,User user) throws Exception
    {
       User who = this.FindById(WhoUserId);
       RoleChecker.VerifyRole(who, Roles.ADMIN);
       return this.Add(user);
    }

    public Boolean Delete(long WhoUserId,long id) throws  Exception
    {
        User who = this.FindById(WhoUserId);
        RoleChecker.VerifyRole(who, Roles.ADMIN);
        return this.Delete(id);
    }

    public void Update(long WhoUserId,long id, String name, String roles)throws  Exception
    {
        User who = this.FindById(WhoUserId);
        RoleChecker.VerifyRole(who, Roles.ADMIN);
        this.Update(id,name,roles);
    }

}
