package net.codinux.quarkus.logging.elasticsearch.runtime.config;

import io.quarkus.runtime.annotations.ConfigGroup;
import io.quarkus.runtime.annotations.ConfigItem;

@ConfigGroup
public class LogLevelConfig {

    /**
     * If the log level field should be included in Elasticsearch.
     */
    @ConfigItem(defaultValue = "true")
    public boolean include;

    /**
     * The name of the log level field.
     */
    @ConfigItem(defaultValue = "level")
    public String name;

}