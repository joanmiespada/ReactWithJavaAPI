package com.Schibsted.Business.Securities;

import com.Schibsted.Business.Entities.User;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Created by joanmi on 16/6/17.
 */


public class RoleChecker {

    public static boolean VerifyRole(User u, String roles)
    {
        return u.getRoles().indexOf(roles) == 0 ? true: false;
    }

}
