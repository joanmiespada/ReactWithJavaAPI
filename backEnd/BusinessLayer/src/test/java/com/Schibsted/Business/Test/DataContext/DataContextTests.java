package com.Schibsted.Business.Test.DataContext;

/**
 * Created by joanmi on 15/6/17.
 */

import com.Schibsted.Business.Context.DataContext;
import com.Schibsted.Business.Context.IDataContext;
import com.Schibsted.Business.SeedData.SeedData;
import org.junit.Test;
import static org.junit.Assert.*;

public class DataContextTests {

    @Test
    public void TestSetup()
    {
        IDataContext ctx = new DataContext();
        SeedData seeddata = new SeedData(ctx);

        try {
            ctx.Open();
            seeddata.SeedData();
            ctx.Close();
            assertEquals(1,1);

        }catch (Exception ex)
        {
            assertEquals(1,0);
        }



    }
}
