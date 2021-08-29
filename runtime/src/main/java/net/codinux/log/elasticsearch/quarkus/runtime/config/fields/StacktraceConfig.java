package net.codinux.log.elasticsearch.quarkus.runtime.config.fields;

import io.quarkus.runtime.annotations.ConfigGroup;
import io.quarkus.runtime.annotations.ConfigItem;

@ConfigGroup
public class StacktraceConfig {

    /**
     * If the stacktrace field should be included in Elasticsearch index.
     */
    @ConfigItem(defaultValue = "true")
    public boolean include;

    /**
     * The name of the stacktrace field.
     */
    @ConfigItem(name = "fieldname", defaultValue = "stacktrace")
    public String fieldName;

}