package dropwizard.DataBase;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import org.mongodb.morphia.Morphia;

import java.net.UnknownHostException;

/**
 * Created by gurdits on 8/14/2014.
 */
public class MongoDataConnection {

    public static MongoClient mongoClient;
    public static DB db;
    public static DBCollection dbCollection;
    public static Morphia morphia;

    public static void connect(){
        try {

            mongoClient=new MongoClient("localhost",27017);
            db=mongoClient.getDB("Demo");
            dbCollection=db.getCollection("House");
            morphia=new Morphia();

        } catch (UnknownHostException e) {
            System.out.print("Not Connected");
        }
        catch (MongoException me){
            System.out.print("Not ");
        }
    }
}
