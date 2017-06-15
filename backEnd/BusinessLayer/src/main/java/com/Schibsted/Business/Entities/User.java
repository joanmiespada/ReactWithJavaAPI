package com.Schibsted.Business.Entities;


import lombok.Getter;
import lombok.Setter;

/**
 * Created by joanmi on 15/6/17.
 */
public class User {

    @Getter @Setter private String Name;
    @Getter @Setter private Integer  Id;
    @Getter @Setter private String Password;
    @Getter @Setter private String Roles;

    @Override public String toString() {
        return String.format("Name: %s Id: %d Roles: %s Password: %s", Name, Id,Roles, Password);
    }
}
