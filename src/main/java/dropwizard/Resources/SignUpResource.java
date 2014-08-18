package dropwizard.Resources;

import dropwizard.DataBase.MongoDataSignUp;
import dropwizard.core.Member;
import dropwizard.core.SignUp;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by GURDIT_SINGH on 15-08-2014.
 */
@Path("/signup")
@Produces(MediaType.APPLICATION_JSON)
public class SignUpResource {

        @POST
        @Path("/house")
        public void signup(@QueryParam("hName")String hName,@QueryParam("hEmail")String hEmail,@QueryParam("hPassword") String hPassword){
            SignUp signUp=new SignUp(hName,hEmail,hPassword);
            System.out.println(hName+"  "+hEmail+"   "+hPassword);
            MongoDataSignUp.signupHouse(signUp);
        }
        @POST
        @Path("/member")
        public void memeberSignup(@QueryParam("mName")String mName,@QueryParam("mEmail")String mEmail,@QueryParam("mPassword") String mPassword,@QueryParam("hEmail") String hEmail){
            Member member=new Member(mName, mEmail, mPassword);
            MongoDataSignUp.signupMember(hEmail,member);
        }

}
