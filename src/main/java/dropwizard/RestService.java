package dropwizard;

import com.bazaarvoice.dropwizard.assets.ConfiguredAssetsBundle;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import dropwizard.Resources.ProjectResource;
import dropwizard.Resources.SignUpResource;
import dropwizard.Resources.UserResource;
import dropwizard.Security.SecurityProvider;
import dropwizard.Security.UserAuthentication;
import dropwizard.core.UserAuth;
import dropwizard.helthcheck.DatabaseHealthCheck;

/**
 * Created by GURDIT_SINGH on 10-08-2014.
 */
public class RestService extends Service<RestServiceConfiguration> {
    @Override
    public void initialize(Bootstrap<RestServiceConfiguration> bootstrap) {
        bootstrap.addBundle(new ConfiguredAssetsBundle("/assets/","/"));
    }

    @Override
    public void run(RestServiceConfiguration configuration, Environment environment)  {
        environment.addResource(ProjectResource.class);
        environment.addResource(UserResource.class);
        environment.addResource(SignUpResource.class);
        environment.addProvider(new SecurityProvider<UserAuth>(new UserAuthentication()));
//        environment.addHealthCheck(new DatabaseHealthCheck());
    }

    public static void main(String s[]) throws Exception {
        new RestService().run(s);
    }

}
