package com.Schibsted.api.Controllers;

import com.Schibsted.Business.Dictionaries.*;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by joanmi on 15/6/17.
 */
public class UserController implements HttpHandler {

    protected IUsers userManager;

    public static final String URL_PATH="/user";

    public UserController(IUsers users)
    {
        super();
        this.userManager = users;
    }

    @Override
    public void handle(HttpExchange t) throws IOException {
        String response = "This is the response";
        t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

}
