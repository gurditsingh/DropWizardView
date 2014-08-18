package dropwizard.Resources;

import dropwizard.DataBase.MongoDataUser;
import dropwizard.core.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Created by gurdits on 8/12/2014.
 */
@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {


    @GET
    @Path("/sign")
    public boolean login(@QueryParam("userEmail")String uEmail,@QueryParam("password") String password){
        User user=new User(uEmail,password);
        return MongoDataUser.isValidloginUser(user);
    }
}
