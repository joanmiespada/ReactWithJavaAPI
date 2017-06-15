package com.Schibsted.api.Controllers;

import com.Schibsted.Business.Dictionaries.IUsers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;


/**
 * Created by joanmi on 15/6/17.
 */
public class LoginController implements HttpHandler {

    public static final String URL_PATH="/login";
    protected IUsers userManager;

    public LoginController(IUsers users)
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
