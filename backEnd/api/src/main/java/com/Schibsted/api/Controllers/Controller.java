package com.Schibsted.api.Controllers;


import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.tools.javac.util.Pair;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import static com.Schibsted.api.Controllers.ApiDefinitions.*;
/**
 * Created by joanmi on 15/6/17.
 */
public abstract class Controller {

    protected class ResultContext{
        public int value;
        public String message;
        public ResultContext(){}
        public ResultContext(int val,String text){
            this.value=val;
            this.message = text;
        }
    }

    //template design pattern
    protected abstract ResultContext GetRequest(final Map<String, List<String>> params );

    protected void ProcessRequest(HttpExchange t) throws IOException
    {
        try {
            final Headers headers = t.getResponseHeaders();
            final String requestMethod = t.getRequestMethod().toUpperCase();
            switch (requestMethod) {
                case ApiDefinitions.METHOD_GET:
                    final Map<String, List<String>> requestParameters = ApiDefinitions.getRequestParameters(t.getRequestURI());
                    ResultContext result= this.GetRequest(requestParameters);
                    t.sendResponseHeaders(result.value, result.message.length());
                    OutputStream os = t.getResponseBody();
                    os.write(result.message.getBytes());
                    os.close();
                    break;
                case METHOD_OPTIONS:
                    headers.set(HEADER_ALLOW, ALLOWED_METHODS);
                    t.sendResponseHeaders(STATUS_OK, NO_RESPONSE_LENGTH);
                    break;
                default:
                    headers.set(HEADER_ALLOW, ALLOWED_METHODS);
                    t.sendResponseHeaders(STATUS_METHOD_NOT_ALLOWED, NO_RESPONSE_LENGTH);
                    break;
            }

        /*String response = "This is the response";
        t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();*/

        }finally {
            t.close();
        }

    }



}
