package dropwizard.Security;

import com.sun.jersey.api.core.HttpContext;
import com.sun.jersey.core.spi.component.ComponentContext;
import com.sun.jersey.core.spi.component.ComponentScope;
import com.sun.jersey.server.impl.inject.AbstractHttpContextInjectable;
import com.sun.jersey.spi.inject.Injectable;
import com.sun.jersey.spi.inject.InjectableProvider;
import com.yammer.dropwizard.auth.Auth;
import com.yammer.dropwizard.auth.AuthenticationException;
import com.yammer.dropwizard.auth.Authenticator;
import com.google.common.base.Optional;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.lang.reflect.Parameter;


/**
 * Created by gurdits on 8/14/2014.
 */
public class SecurityProvider<T> implements InjectableProvider<Auth,Parameter> {

    public final static String CUSTOME_HEADER="user_header";
    public final Authenticator<Credentials,T> authenticator;

    public SecurityProvider(Authenticator<Credentials, T> authenticator) {
        this.authenticator = authenticator;
    }

    @Override
    public ComponentScope getScope() {
        return ComponentScope.PerRequest;
    }

    @Override
    public Injectable getInjectable(ComponentContext componentContext, Auth auth, Parameter parameter) {
        return new SecurityInjectable<T>(authenticator,auth.required());
    }


    private static class SecurityInjectable<T> extends AbstractHttpContextInjectable<T>{

        public final Authenticator<Credentials,T> authenticator;
        public final boolean required;

        private SecurityInjectable(Authenticator<Credentials, T> authenticator, boolean required) {
            this.authenticator = authenticator;
            this.required = required;
        }


        @Override
        public T getValue(HttpContext httpContext) {

            final String header= httpContext.getRequest().getHeaderValue(CUSTOME_HEADER);
            try{
               if(header!=null){
                   /*Optional<T> result=authenticator.authenticate(new Credentials(CUSTOME_HEADER));
                    if(result.isPresent())
                        return result.get();*/

               }
            } catch (Exception e) {
                throw new WebApplicationException(Response.Status.UNAUTHORIZED);
            }
            if(required)
                throw new WebApplicationException(Response.Status.UNAUTHORIZED);


            return null;
        }
    }
}
