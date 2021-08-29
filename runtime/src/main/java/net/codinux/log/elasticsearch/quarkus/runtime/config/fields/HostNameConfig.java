package net.codinux.log.elasticsearch.quarkus.runtime.config.fields;

import io.quarkus.runtime.annotations.ConfigGroup;
import io.quarkus.runtime.annotations.ConfigItem;

@ConfigGroup
public class HostNameConfig {

    /**
     * If the host name field should be included in Elasticsearch index.
     */
    @ConfigItem(defaultValue = "true")
    public boolean include;

    /**
     * The name of the host name field.
     */
    @ConfigItem(name = "fieldname", defaultValue = "host")
    public String fieldName;

}