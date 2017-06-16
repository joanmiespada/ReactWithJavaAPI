package com.Schibsted.api.Controllers;

import com.Schibsted.Business.Dictionaries.*;
import com.Schibsted.Business.Entities.User;
import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.tools.javac.util.Pair;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by joanmi on 15/6/17.
 */
public class UserController extends Controller implements HttpHandler {

    protected IUsers userManager;

    public static final String URL_PATH="/user";
    public static final String METHOD_GETALLUSERS="/getallusers";

    public UserController(IUsers users)
    {
        super();
        this.userManager = users;
    }

    @Override
    public void handle(HttpExchange t) throws IOException {
        this.ProcessRequest(t);
    }
    protected ResultContext GetRequest(final Map<String, List<String>> params,String uri) throws Exception
    {
        if(uri.equals(URL_PATH+METHOD_GETALLUSERS))
        {
            return this.GetAllUsers();
        }else{
            return new ResultContext(ApiDefinitions.NOT_IMPLEMENTED,"");
        }

    }

    protected ResultContext GetAllUsers() throws Exception
    {
        int page=0;
        int pageSize=10;
        Pair< List<User>, Long>  entities;
        entities = this.userManager.GetAllUsers(page, pageSize);

        List<com.Schibsted.api.Models.User> DTOs = MoveFromEntityUserToDTOUser(entities.fst);

        Gson gson = new Gson();
        String jsonstring = DTOs.stream().map(item -> gson.toJson(item) ).collect(Collectors.joining(","));

        String finalResult = String.format("{ totalItems: %d, items: [%s] }", entities.snd, jsonstring );
        ResultContext res = new ResultContext(ApiDefinitions.STATUS_OK, finalResult);

        return res;
    }

    protected List<com.Schibsted.api.Models.User> MoveFromEntityUserToDTOUser(List<User> lin)
    {
        List<com.Schibsted.api.Models.User> result;

        result = lin.stream().map(oldU->{
                com.Schibsted.api.Models.User newU = new  com.Schibsted.api.Models.User();
                newU.setId( oldU.getId());
                newU.setName( oldU.getName());
                newU.setRoles( oldU.getRoles());
                return newU;
            }).collect(Collectors.toList()) ;


        return result;

    }

}
