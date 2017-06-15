package com.Schibsted.Business.Entities;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by joanmi on 15/6/17.
 */
@ToString(callSuper=true, includeFieldNames=true)
public class User {

    @Getter @Setter private String Name;
    @Getter @Setter private Long Id;
    @Getter @Setter private String Password;
    @Getter @Setter private String Roles;

    public User(){}
    public User(User copy)
    {
        this.Name=copy.Name;
        this.Id = copy.Id;
        this.Password=copy.Password;
        this.Roles=copy.Roles;
    }
}
