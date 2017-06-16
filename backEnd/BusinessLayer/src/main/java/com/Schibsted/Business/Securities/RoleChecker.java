package com.Schibsted.Business.Securities;

import com.Schibsted.Business.Entities.User;
import com.Schibsted.Business.Exceptions.NotRoleAllowedException;


/**
 * Created by joanmi on 16/6/17.
 */

//The best way is use it through Interception methods, for example, AOP Spring...
public class RoleChecker {

    public static boolean VerifyRole(User u, String roles) throws NotRoleAllowedException
    {
        boolean res;
        res = u.getRoles().indexOf(roles) == 0 ? true : false;
        if(!res)
            throw new NotRoleAllowedException();
        return res;
    }

}
