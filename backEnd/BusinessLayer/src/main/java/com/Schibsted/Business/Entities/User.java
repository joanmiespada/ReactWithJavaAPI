package com.Schibsted.Business.Entities;

/**
 * Created by joanmi on 15/6/17.
 */
public class User {
    private String Name;

    public User(String name)
    {
        this.Name = name;
    }

    public String getName()
    {
        return this.Name;
    }

    public String ToString()
    {
        return this.Name;
    }

}
