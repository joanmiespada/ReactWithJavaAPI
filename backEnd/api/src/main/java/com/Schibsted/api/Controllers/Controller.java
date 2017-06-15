package com.Schibsted.api.Controllers;


import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.tools.javac.util.Pair;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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
    protected ResultContext GetRequest(final Map<String, List<String>> urlparams ) { throw new NotImplementedException(); }
    protected ResultContext PostRequest(final String payload ) { throw new  NotImplementedException(); }

    protected void WriteResponse(HttpExchange t, ResultContext result) throws IOException
    {
        t.sendResponseHeaders(result.value, result.message.length());
        OutputStream os = t.getResponseBody();
        os.write(result.message.getBytes());
        os.close();
    }

    protected void ProcessRequest(HttpExchange t) throws IOException
    {
        try {
            final Headers headers = t.getResponseHeaders();
            final String requestMethod = t.getRequestMethod().toUpperCase();
            ResultContext result;

            switch (requestMethod) {
                case ApiDefinitions.METHOD_GET:
                    final Map<String, List<String>> requestParameters = ApiDefinitions.getRequestParameters(t.getRequestURI());
                    result= this.GetRequest(requestParameters);
                    WriteResponse(t,result);

                    break;
                case METHOD_POST:
                    final String payload = ApiDefinitions.postRequestPayload(t.getRequestBody());
                    result= this.PostRequest(payload);
                    WriteResponse(t,result);

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


        }finally {
            t.close();
        }

    }



}
