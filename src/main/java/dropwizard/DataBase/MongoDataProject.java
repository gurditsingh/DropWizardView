package dropwizard.DataBase;

import com.mongodb.*;
import dropwizard.core.Project;
import org.mongodb.morphia.Morphia;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;


public class MongoDataProject extends MongoDataConnection{


    public static boolean isAlive()  {
        connect();
            try{
            db.getCollectionNames();
            }
            catch (MongoException me) {
                return false;
            }
        return true;
    }

    public static void adduser(Project project){
        connect();
        dbCollection.save(morphia.toDBObject(project));
    }

    public static List<Project> getUsers()
    {
        connect();
        List<Project> projectList =new ArrayList<Project>();
        DBCursor dbUsers=dbCollection.find();
        DBObject dbObject;
        while (dbUsers.hasNext())
        {
             dbObject=dbUsers.next();
            Project project =new Project(
                    dbObject.get("UID").toString()
                    ,dbObject.get("fname").toString()
                    ,dbObject.get("lname").toString()
                    ,dbObject.get("phone").toString()
                    ,dbObject.get("email").toString()
            );
            projectList.add(project);
        }
        return projectList;
    }


    public static void deluser(String id) {
        connect();
        dbCollection.remove(new BasicDBObject("UID",id));
    }


    public static Project findUser(String id){
        connect();
        DBObject dbObject= dbCollection.findOne(new BasicDBObject("UID",id));
        Project project =new Project(
                dbObject.get("UID").toString()
                ,dbObject.get("fname").toString()
                ,dbObject.get("lname").toString()
                ,dbObject.get("phone").toString()
                ,dbObject.get("email").toString()
        );
       return project;
    }

    public static void updateUser(Project project){
        connect();

        BasicDBObject query=new BasicDBObject("$set",morphia.toDBObject(project));
        dbCollection.update(new BasicDBObject("UID", project.getUID()),query);
    }

    public static long userCount(){
        connect();
        return dbCollection.count();
    }


    public static List<Project> search(String name){
        connect();
        String firstname;
        DBObject dbObject;
        List<Project> projectList =new ArrayList<Project>();
        DBCursor users=dbCollection.find();
        while (users.hasNext()) {
            dbObject = users.next();
            firstname = dbObject.get("fname").toString();
            firstname = firstname.substring(0, name.length());
            if (firstname.equalsIgnoreCase(name)) {
                Project project =new Project(
                        dbObject.get("UID").toString()
                        ,dbObject.get("fname").toString()
                        ,dbObject.get("lname").toString()
                        ,dbObject.get("phone").toString()
                        ,dbObject.get("email").toString()
                );
                projectList.add(project);
            }
        }
        return projectList;
    }



    public static void main(String s[]){
        System.out.print(isAlive());
    }

}
