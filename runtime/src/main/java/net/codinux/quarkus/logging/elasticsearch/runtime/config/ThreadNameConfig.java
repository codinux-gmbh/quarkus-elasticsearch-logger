package net.codinux.quarkus.logging.elasticsearch.runtime.config;

import io.quarkus.runtime.annotations.ConfigGroup;
import io.quarkus.runtime.annotations.ConfigItem;

@ConfigGroup
public class ThreadNameConfig {

    /**
     * If the thread name field should be included in Elasticsearch.
     */
    @ConfigItem(defaultValue = "true")
    public boolean include;

    /**
     * The name of the thread name field.
     */
    @ConfigItem(defaultValue = "thread")
    public String name;

}