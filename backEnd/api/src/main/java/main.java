import com.Schibsted.Business.Context.DataContext;
import com.Schibsted.Business.Context.IDataContext;
import com.Schibsted.Business.Service.IUsers;
import com.Schibsted.Business.Service.Users;
import com.Schibsted.Business.SeedData.SeedData;
import com.Schibsted.api.Controllers.LoginController;
import com.Schibsted.api.Controllers.UserController;
import com.sun.net.httpserver.HttpServer;

import java.net.InetSocketAddress;

/**
 * Created by joanmi on 15/6/17.
 */
public class Main {

    private final static String HOSTNAME = "localhost";
    private final static int PORT = 8000;
    private final static int BACKLOG = 1;

    protected static void SetupDatabase() throws Exception
    {

        IDataContext ctx = new DataContext();
        SeedData seeddata = new SeedData(ctx);
        ctx.Open();
        seeddata.SeedData();
        ctx.Close();

    }

    public static void main(String args[])
    {

        try {
            SetupDatabase();
            IUsers managerOfUsers = new Users();

            HttpServer server = HttpServer.create(new InetSocketAddress( HOSTNAME,PORT), BACKLOG );
            server.createContext(UserController.URL_PATH, new UserController(managerOfUsers )); //Dependency Injection
            server.createContext(LoginController.URL_PATH, new LoginController(managerOfUsers )); //Dependency Injection

            System.out.println("Working on: " + PORT);
            server.start();

        }catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }




    }
}
