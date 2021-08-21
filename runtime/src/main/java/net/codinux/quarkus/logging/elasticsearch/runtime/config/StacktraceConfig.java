package net.codinux.quarkus.logging.elasticsearch.runtime.config;

import io.quarkus.runtime.annotations.ConfigGroup;
import io.quarkus.runtime.annotations.ConfigItem;

@ConfigGroup
public class StacktraceConfig {

    /**
     * If the stacktrace field should be included in Elasticsearch.
     */
    @ConfigItem(defaultValue = "true")
    public boolean include;

    /**
     * The name of the stacktrace field.
     */
    @ConfigItem(defaultValue = "stacktrace")
    public String name;

}