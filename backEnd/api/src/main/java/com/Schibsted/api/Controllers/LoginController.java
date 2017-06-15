package com.Schibsted.api.Controllers;

import com.Schibsted.Business.Dictionaries.IUsers;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;


/**
 * Created by joanmi on 15/6/17.
 */
public class LoginController extends Controller implements HttpHandler {

    public static final String URL_PATH="/login";

    public static final String USER="user";
    public static final String PASS="pass";

    protected IUsers userManager;

    public LoginController(IUsers users)
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
        String user = params.get(USER).get(0);
        String pwd  = params.get(PASS).get(0);
        ResultContext res = new ResultContext(200, "login: "+ user + " pwd: " + pwd);

        return res;
    }

    protected ResultContext PostRequest(final String payload)
    {
       return new ResultContext(200,"ok: " + payload);
    }
}
