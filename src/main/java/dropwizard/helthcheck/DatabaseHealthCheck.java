package dropwizard.helthcheck;

import com.yammer.metrics.core.HealthCheck;
import dropwizard.DataBase.MongoDataProject;

/**
 * Created by gurdits on 8/11/2014.
 */
public class DatabaseHealthCheck extends HealthCheck {

    protected DatabaseHealthCheck() {
        super("Mongo");
    }

    @Override
    protected Result check() throws Exception {
        if(MongoDataProject.isAlive())
            return Result.unhealthy("not Connected");
        else
        return Result.healthy();
    }
}
