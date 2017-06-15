package com.Schibsted.Business.Test.Dictionaries;

import com.Schibsted.Business.Context.DataContext;
import com.Schibsted.Business.Context.IDataContext;
import com.Schibsted.Business.Dictionaries.*;
import com.Schibsted.Business.Entities.User;
import com.Schibsted.Business.SeedData.SeedData;
import com.sun.tools.javac.util.Pair;
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
            Pair< List<User>, Long> result = elems.GetAllUsers(0,10);

            ctx.Close();
            assertEquals(result.fst.size(), 5);


        }catch (Exception ex)
        {
            assertEquals(1,0);
        }
    }

    @Test
    public void AddUser()
    {
        IDataContext ctx = new DataContext();
        SeedData seeddata = new SeedData(ctx);

        try {
            ctx.Open();
            seeddata.SeedData();

            User u1= new User();
            u1.setName("pepe");
            u1.setPassword("0987654321");
            u1.setRoles("page1");
            u1.setId(-1L);

            IUsers elems = new Users();
            User u2 = elems.Add(u1);

            ctx.Close();
            assertNotEquals((long)u2.getId(), (long)u1.getId());


        }catch (Exception ex)
        {
            assertEquals(1,0);
        }
    }

    @Test
    public void DeleteUser()
    {
        IDataContext ctx = new DataContext();
        SeedData seeddata = new SeedData(ctx);

        try {
            ctx.Open();
            seeddata.SeedData();

            User u1= new User();
            u1.setName("pepe");
            u1.setPassword("0987654321");
            u1.setRoles("page1");
            u1.setId(-1L);

            IUsers elems = new Users();
            User u2 = elems.Add(u1);

            elems.Delete(u2.getId());

            try {
                elems.FindById(u2.getId());
            }catch (Exception ex)
            {
               assertEquals(1,1);
            }finally {
                ctx.Close();
            }

        }catch (Exception ex)
        {
            assertEquals(1,0);
        }
    }

    @Test
    public void FindByID()
    {
        IDataContext ctx = new DataContext();
        SeedData seeddata = new SeedData(ctx);

        try {
            ctx.Open();
            seeddata.SeedData();

            IUsers elems = new Users();

            try {
                elems.FindById(123);
            }catch (Exception ex)
            {}

            User u1 = elems.FindById(1);

            ctx.Close();
            assertEquals((long)u1.getId(), 1L);


        }catch (Exception ex)
        {
            assertEquals(1,0);
        }
    }

    @Test
    public void Update()
    {
        IDataContext ctx = new DataContext();
        SeedData seeddata = new SeedData(ctx);

        try {
            ctx.Open();
            seeddata.SeedData();

            IUsers elems = new Users();
            User u1 = new User();
            try {
                u1=elems.FindById(2);
            }catch (Exception ex)
            {}
            u1.setName("cocococo");
            u1.setRoles("page1,page2,page3");
            elems.Update(u1.getId(), u1.getName(), u1.getRoles()  );
            User u2 = new User();
            try {
                u2=elems.FindById(2);
            }catch (Exception ex)
            {}

            ctx.Close();
            assertEquals(u1.getName(),u2.getName() );


        }catch (Exception ex)
        {
            assertEquals(1,0);
        }
    }

    @Test
    public void FindByName()
    {
        IDataContext ctx = new DataContext();
        SeedData seeddata = new SeedData(ctx);

        try {
            ctx.Open();
            seeddata.SeedData();

            IUsers elems = new Users();
            List<User> lus = null;
            try {
                lus =elems.FindByName("o",0,10);
            }catch (Exception ex)
            {}

            ctx.Close();
            assertEquals((long)lus.size(), 2L);


        }catch (Exception ex)
        {
            assertEquals(1,0);
        }
    }

    @Test
    public void FindByNameAndPassword()
    {
        IDataContext ctx = new DataContext();
        SeedData seeddata = new SeedData(ctx);

        try {
            ctx.Open();
            seeddata.SeedData();

            IUsers elems = new Users();
            User us = null;
            try {
                us =elems.FindByNameAndPassword("Jhon","123456");
            }catch (Exception ex)
            {}

            ctx.Close();
            assertEquals(us.getName(), "Jhon");


        }catch (Exception ex)
        {
            assertEquals(1,0);
        }
    }
}
