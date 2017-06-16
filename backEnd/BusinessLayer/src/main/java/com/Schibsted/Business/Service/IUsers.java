package com.Schibsted.Business.Service;

import com.Schibsted.Business.Entities.User;
import com.sun.tools.javac.util.Pair;

import java.util.List;

/**
 * Created by joanmi on 16/6/17.
 */
public interface IUsers extends com.Schibsted.Business.Dictionaries.IUsers {

    //Pair<List<User>, Long> GetAllUsers(long WhoUserId, int page, int pageSize) throws Exception;
    User Add(long WhoUserId,User user) throws Exception;
    Boolean Delete(long WhoUserId,long id) throws  Exception;
    void Update(long WhoUserId,long id, String name, String Roles)throws  Exception;
}
