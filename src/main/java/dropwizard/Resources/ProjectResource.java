package dropwizard.Resources;

import com.example.core.User;
import com.yammer.dropwizard.auth.Auth;
import dropwizard.DataBase.MongoDataProject;
import dropwizard.core.Project;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by GURDIT_SINGH on 09-08-2014.
 */
@Path("/user")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class ProjectResource {



    @GET
    @Path("/add")
    public void add(@QueryParam("fname")String fname,@QueryParam("lname")String lname,@QueryParam("phone")String phone,@QueryParam("email")String email)
    {
        Project project =new Project(fname,lname,phone,email);
        MongoDataProject.adduser(project);
    }

    @GET
    @Path("/show")
    public List<Project> show(){
        return MongoDataProject.getUsers();
    }

    @GET
    @Path("/delete/{id}")
    public void delete(@PathParam("id") String id){
        MongoDataProject.deluser(id);
    }

    @GET
    @Path("/find/{id}")
    public Project findUser(@PathParam("id") String id){
       return MongoDataProject.findUser(id);
    }

    @GET
    @Path("/update")
    public void update(@QueryParam("fname")String fname,@QueryParam("lname")String lname,@QueryParam("phone")String phone,@QueryParam("email")String email,@QueryParam("UID")String UID)
    {
        Project project =new Project(UID,fname,lname,phone,email);
        MongoDataProject.updateUser(project);
    }
    @GET
    @Path("/count")
    public long count()
    {
       return MongoDataProject.userCount();
    }

    @GET
    @Path("/search/{name}")
    public List<Project> searchUsers(@PathParam("name") String name){
        return MongoDataProject.search(name);
    }
}
