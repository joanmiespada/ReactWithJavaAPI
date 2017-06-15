package com.Schibsted.Business.Test.Dictionaries;

import com.Schibsted.Business.Dictionaries.*;
import com.Schibsted.Business.Entities.User;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

/**
 * Created by joanmi on 15/6/17.
 */
public class UsersTest {

    @Test
    public void GetAllUsers()
    {
        IUsers elems = new Users();
        List<User> result = elems.GetAllUsers();

        assertEquals(result.size(), 1);
    }
}
