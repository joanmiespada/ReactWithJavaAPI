package com.Schibsted.Business.Dictionaries;

import com.Schibsted.Business.Entities.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joanmi on 15/6/17.
 */
public class Users implements IUsers {

    public List<User> GetAllUsers()
    {
        User foo = new User("foo");
        ArrayList<User> result = new ArrayList<>();
        result.add(foo);

        return result;
    }



}
