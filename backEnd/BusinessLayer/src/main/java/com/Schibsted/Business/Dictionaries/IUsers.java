package com.Schibsted.Business.Dictionaries;

import com.Schibsted.Business.Entities.User;
import com.sun.tools.javac.util.Pair;

import java.util.List;

/**
 * Created by joanmi on 15/6/17.
 */
public interface IUsers
{
    Pair< List<User>, Long> GetAllUsers(int page, int pageSize) throws Exception;
    User Add(User user) throws Exception;
    Boolean Delete(long id) throws  Exception;
    void Update(long id, String name, String Roles)throws  Exception;
    User FindById(long id)throws  Exception;
    List<User> FindByName(String name, int page ,int pageSize)throws  Exception;
    User FindByNameAndPassword(String name, String passw)throws  Exception;

}
