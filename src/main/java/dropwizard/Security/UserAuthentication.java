package dropwizard.Security;

import com.google.common.base.Optional;
import com.yammer.dropwizard.auth.AuthenticationException;
import com.yammer.dropwizard.auth.Authenticator;
import dropwizard.core.UserAuth;

import java.util.UUID;

/**
 * Created by gurdits on 8/14/2014.
 */
public class UserAuthentication implements Authenticator<Credentials,UserAuth> {


    @Override
    public Optional<UserAuth> authenticate(Credentials credentials) throws AuthenticationException {
        if(credentials.getToken().startsWith("fail")){
            throw new AuthenticationException("invalid credientials");
        }
        else {
            UserAuth userAuth=new UserAuth();
                    userAuth.setUserName("user "+credentials.getToken());
                    userAuth.setPassword(UUID.randomUUID().toString());
                    userAuth.setUserRole((credentials.getToken()=="Admin"?UserAuth.ROLE_ADMIN:UserAuth.ROLE_EDITOR));
            return Optional.fromNullable(userAuth);
        }

    }
}
