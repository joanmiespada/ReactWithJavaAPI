import com.Schibsted.Business.Dictionaries.*;
import com.Schibsted.api.Controllers.LoginController;
import com.Schibsted.api.Controllers.UserController;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by joanmi on 15/6/17.
 */
public class main {

    private final static String HOSTNAME = "localhost";
    private final static int PORT = 8000;
    private final static int BACKLOG = 1;

    public static void main(String args[])
    {

        try {
            System.out.println("Working on: " + PORT);

            IUsers managerOfUsers = new Users();

            HttpServer server = HttpServer.create(new InetSocketAddress( HOSTNAME,PORT), BACKLOG );
            server.createContext(UserController.URL_PATH, new UserController(managerOfUsers )); //Dependency Injection
            server.createContext(LoginController.URL_PATH, new LoginController(managerOfUsers )); //Dependency Injection

            server.start();

        }catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }




    }
}
