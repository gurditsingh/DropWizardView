package dropwizard.DataBase;

import com.mongodb.*;
import dropwizard.core.User;
import org.mongodb.morphia.Morphia;

import java.net.UnknownHostException;

/**
 * Created by gurdits on 8/14/2014.
 */
public class MongoDataUser extends MongoDataConnection{

    public static boolean isValidloginUser(User user){
        connect();
       if(dbCollection.findOne(new BasicDBObject("hEmail", user.getUserEmail()))!=null)
        return true;
        else
           return false;
    }

}
