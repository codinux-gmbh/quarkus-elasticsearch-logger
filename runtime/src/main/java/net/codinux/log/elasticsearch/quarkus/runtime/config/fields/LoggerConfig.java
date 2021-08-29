package net.codinux.log.elasticsearch.quarkus.runtime.config.fields;

import io.quarkus.runtime.annotations.ConfigGroup;
import io.quarkus.runtime.annotations.ConfigItem;

@ConfigGroup
public class LoggerConfig {

    /**
     * If the full qualified name of the logger should be included in Elasticsearch.
     */
    @ConfigItem(defaultValue = "true")
    public boolean include;

    /**
     * The name of the logger field (that is the full qualified logger name which includes in most cases the package names).
     */
    @ConfigItem(name = "fieldname", defaultValue = "logger")
    public String fieldName;

}