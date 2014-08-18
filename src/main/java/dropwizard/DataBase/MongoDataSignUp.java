package dropwizard.DataBase;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import dropwizard.core.Member;
import dropwizard.core.SignUp;

/**
 * Created by GURDIT_SINGH on 15-08-2014.
 */
public class MongoDataSignUp extends MongoDataConnection implements ContainKeys{

    public static void signupHouse(SignUp signUp){
        connect();
        dbCollection.save(morphia.toDBObject(signUp));
    }

    public static void signupMember(String email,Member member){
        connect();
        DBObject query=new BasicDBObject("$addToSet",new BasicDBObject(MEMBERS,morphia.toDBObject(member)));
        dbCollection.update(new BasicDBObject(HEMAIL,email),query,true,false);
    }



}
