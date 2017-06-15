package com.Schibsted.api.Controllers;

import com.Schibsted.Business.Dictionaries.*;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by joanmi on 15/6/17.
 */
public class UserController extends Controller implements HttpHandler {

    protected IUsers userManager;

    public static final String URL_PATH="/user";

    public UserController(IUsers users)
    {
        super();
        this.userManager = users;
    }

    @Override
    public void handle(HttpExchange t) throws IOException {
        this.ProcessRequest(t);
    }
    protected ResultContext GetRequest(final Map<String, List<String>> params)
    {
        ResultContext res = new ResultContext(200,"the response");

        return res;
    }

}
