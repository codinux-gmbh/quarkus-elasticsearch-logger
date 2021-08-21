package net.codinux.quarkus.logging.elasticsearch.runtime.config;

import io.quarkus.runtime.annotations.ConfigGroup;
import io.quarkus.runtime.annotations.ConfigItem;

@ConfigGroup
public class LoggerNameConfig {

    /**
     * If the logger name field should be included in Elasticsearch.
     */
    @ConfigItem(defaultValue = "true")
    public boolean include;

    /**
     * The name of the logger name field.
     */
    @ConfigItem(defaultValue = "logger")
    public String name;

}