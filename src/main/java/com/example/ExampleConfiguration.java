package com.example;

import com.bazaarvoice.dropwizard.assets.AssetsBundleConfiguration;
import com.bazaarvoice.dropwizard.assets.AssetsConfiguration;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class ExampleConfiguration extends com.yammer.dropwizard.config.Configuration implements AssetsBundleConfiguration {
    @Valid
    @NotNull
    @JsonProperty
    public AssetsConfiguration assets=new AssetsConfiguration();

    @Override
    public AssetsConfiguration getAssetsConfiguration() {
        return assets;
    }
}
