package net.codinux.quarkus.logging.elasticsearch.runtime.config;

import io.quarkus.runtime.annotations.ConfigGroup;
import io.quarkus.runtime.annotations.ConfigItem;

@ConfigGroup
public class HostNameConfig {

    /**
     * If the host name field should be included in Elasticsearch.
     */
    @ConfigItem(defaultValue = "true")
    public boolean include;

    /**
     * The name of the host name field.
     */
    @ConfigItem(defaultValue = "host")
    public String name;

}