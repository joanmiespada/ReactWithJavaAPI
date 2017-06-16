package com.Schibsted.Business.Dictionaries;

import com.Schibsted.Business.Context.DataContext;
import com.Schibsted.Business.Context.IDataContext;

/**
 * Created by joanmi on 15/6/17.
 */
public class Dictionary {
    protected IDataContext ctx = null;

    public Dictionary()
    {
        try {
            this.ctx = new DataContext();
            ctx.Open();
        }catch (Exception ex)
        {
            System.out.println("ERROR in DB: " +ex.getMessage());
            System.exit(-1);
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        if(ctx !=null)
        {
            this.ctx.Close();
        }
    }

    public Dictionary(IDataContext ctx)
    {
        this.ctx=ctx;
    }

}
