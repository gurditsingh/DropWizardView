package dropwizard;

import com.bazaarvoice.dropwizard.assets.AssetsBundleConfiguration;
import com.bazaarvoice.dropwizard.assets.AssetsConfiguration;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by GURDIT_SINGH on 10-08-2014.
 */
public class RestServiceConfiguration extends Configuration implements AssetsBundleConfiguration {

    @Valid
    @NotNull
    @JsonProperty
    public AssetsConfiguration assets=new AssetsConfiguration();

    @Override
    public AssetsConfiguration getAssetsConfiguration() {
        return assets;
    }
}
