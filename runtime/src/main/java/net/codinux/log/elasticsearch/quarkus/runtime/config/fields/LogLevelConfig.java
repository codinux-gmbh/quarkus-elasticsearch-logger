package net.codinux.log.elasticsearch.quarkus.runtime.config.fields;

import io.quarkus.runtime.annotations.ConfigGroup;
import io.quarkus.runtime.annotations.ConfigItem;
import net.codinux.log.elasticsearch.LoggerSettings;

@ConfigGroup
public class LogLevelConfig {

    /**
     * If the log level field should be included in Elasticsearch index.
     */
    @ConfigItem(defaultValue = LoggerSettings.IncludeLogLevelDefaultValueString)
    public boolean include;

    /**
     * The name of the log level field.
     */
    @ConfigItem(name = "fieldname", defaultValue = LoggerSettings.LogLevelDefaultFieldName)
    public String fieldName;

}