package net.codinux.log.elasticsearch.quarkus.runtime.config.fields;

import io.quarkus.runtime.annotations.ConfigGroup;
import io.quarkus.runtime.annotations.ConfigItem;

@ConfigGroup
public class LogLevelConfig {

    /**
     * If the log level field should be included in Elasticsearch index.
     */
    @ConfigItem(defaultValue = "true")
    public boolean include;

    /**
     * The name of the log level field.
     */
    @ConfigItem(name = "fieldname", defaultValue = "level")
    public String fieldName;

}