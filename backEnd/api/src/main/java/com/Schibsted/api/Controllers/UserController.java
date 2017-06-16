package com.Schibsted.api.Controllers;

import com.Schibsted.Business.Service.*;
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
    public static final String METHOD_ADD="/add";
    public static final String METHOD_UPDATE="/update";
    public static final String METHOD_DELETE="/delete";

    public static final String DELETE_ID_USER="user_to_delete";

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
        int pos= uri.indexOf('?');
        String user;
        if(pos>0){
            uri = uri.substring(0,pos);
        }
        if(uri.equals(URL_PATH+METHOD_GETALLUSERS)) {
            return this.GetAllUsers();
        }else if(uri.equals(URL_PATH+METHOD_DELETE)){
            return this.Delete(params);
        }else{
            return new ResultContext(ApiDefinitions.NOT_IMPLEMENTED,"");
        }

    }

    protected ResultContext PostRequest(final String payload, String uri ) throws Exception {

        if(uri.equals(URL_PATH+METHOD_ADD)){
            return this.Add(payload);
        }else if(uri.equals(URL_PATH+METHOD_UPDATE)){
            return this.Update(payload);
        }else{
            return new ResultContext(ApiDefinitions.NOT_IMPLEMENTED,"");
        }
    }


    protected ResultContext Delete(final Map<String, List<String>> params) throws Exception
    {
        long currentIdUser = Long.parseLong(LoginController.GetUserParam(params));
        String uid  = params.get(DELETE_ID_USER).get(0);
        long idusertodelete = Long.parseLong(uid);

        this.userManager.Delete(currentIdUser,idusertodelete);
        return new ResultContext(ApiDefinitions.STATUS_OK);
    }

    protected class Payloader
    {
        public String id;
        public String name;
        public String password;
        public String roles;
        public String currentiduser;
    }

    protected ResultContext Add(String payload) throws Exception
    {
        Gson gson = new Gson();
        Payloader data = gson.fromJson(payload, Payloader.class );
        long currentIdUser = Long.parseLong(data.currentiduser);

        User us = new User();
        us.setName(data.name);
        us.setRoles(data.roles);
        us.setPassword(data.password);

        this.userManager.Add(currentIdUser,us );
        return new ResultContext(ApiDefinitions.STATUS_OK);
    }

    protected ResultContext Update(String payload) throws Exception
    {
        Gson gson = new Gson();
        Payloader data = gson.fromJson(payload, Payloader.class);
        long currentIdUser = Long.parseLong(data.currentiduser);
        long idusertoupdate = Long.parseLong(data.id);

        this.userManager.Update(currentIdUser, idusertoupdate , data.name, data.roles);

        return new ResultContext(ApiDefinitions.STATUS_OK);
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
