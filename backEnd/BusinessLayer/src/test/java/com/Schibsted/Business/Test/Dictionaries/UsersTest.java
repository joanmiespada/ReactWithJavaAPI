package com.Schibsted.Business.Test.Dictionaries;

import com.Schibsted.Business.Context.DataContext;
import com.Schibsted.Business.Context.IDataContext;
import com.Schibsted.Business.Dictionaries.*;
import com.Schibsted.Business.Entities.User;
import com.Schibsted.Business.SeedData.SeedData;
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

        IDataContext ctx = new DataContext();
        SeedData seeddata = new SeedData(ctx);

        try {
            ctx.Open();
            seeddata.SeedData();

            IUsers elems = new Users();
            List<User> result = elems.GetAllUsers();

            ctx.Close();
            assertEquals(result.size(), 5);


        }catch (Exception ex)
        {
            assertEquals(1,0);
        }



    }
}
