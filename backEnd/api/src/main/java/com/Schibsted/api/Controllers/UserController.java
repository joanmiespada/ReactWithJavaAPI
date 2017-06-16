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
    public static final String USER_NAME="user_name";
    public static final String USER_PASS="user_passw";
    public static final String USER_ROLE="user_role";
    public static final String USER_ID="user_id";

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
        }else if(uri.equals(URL_PATH+METHOD_ADD)){
            return this.Add(params);
        }else if(uri.equals(URL_PATH+METHOD_DELETE)){
            return this.Delete(params);
        }else if(uri.equals(URL_PATH+METHOD_UPDATE)){
            return this.Update(params);
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

    protected ResultContext Add(final Map<String, List<String>> params) throws Exception
    {
        long currentIdUser = Long.parseLong(LoginController.GetUserParam(params));

        String user_name  = params.get(USER_NAME).get(0);
        String user_pwd   = params.get(USER_PASS).get(0);
        String user_role   = params.get(USER_ROLE).get(0);

        User us = new User();
        us.setName(user_name);
        us.setRoles(user_role);
        us.setPassword(user_pwd);

        this.userManager.Add(currentIdUser,us );
        return new ResultContext(ApiDefinitions.STATUS_OK);
    }

    protected ResultContext Update(final Map<String, List<String>> params) throws Exception
    {
        long currentIdUser = Long.parseLong(LoginController.GetUserParam(params));

        String user_name  = params.get(USER_NAME).get(0);
        String user_role   = params.get(USER_ROLE).get(0);
        String user_id   = params.get(USER_ID).get(0);

        long user_id2 = Long.parseLong(user_id);

        this.userManager.Update(currentIdUser, user_id2, user_name, user_role);

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
