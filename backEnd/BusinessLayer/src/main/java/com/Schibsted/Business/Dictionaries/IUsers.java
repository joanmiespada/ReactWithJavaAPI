package com.Schibsted.Business.Dictionaries;

import com.Schibsted.Business.Entities.User;

import java.util.List;

/**
 * Created by joanmi on 15/6/17.
 */
public interface IUsers
{
    List<User> GetAllUsers() throws Exception;
    /*void Add(User user);
    void Delete(int id);
    void Update(int id, User user);
    User FindById(int id);
    List<User> FindByName(String name);*/
}
