package net.codinux.log.elasticsearch.quarkus.runtime.config.fields;

import io.quarkus.runtime.annotations.ConfigGroup;
import io.quarkus.runtime.annotations.ConfigItem;
import net.codinux.log.elasticsearch.LoggerSettings;

@ConfigGroup
public class ThreadNameConfig {

    /**
     * If the thread name field should be included in Elasticsearch index.
     */
    @ConfigItem(defaultValue = "true")
    public boolean include;

    /**
     * The name of the thread name field.
     */
    @ConfigItem(name = "fieldname", defaultValue = LoggerSettings.ThreadNameDefaultFieldName)
    public String fieldName;

}