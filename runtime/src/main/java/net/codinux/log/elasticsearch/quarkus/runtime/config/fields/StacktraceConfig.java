package net.codinux.log.elasticsearch.quarkus.runtime.config.fields;

import io.quarkus.runtime.annotations.ConfigGroup;
import io.quarkus.runtime.annotations.ConfigItem;
import net.codinux.log.elasticsearch.LoggerSettings;

@ConfigGroup
public class StacktraceConfig {

    /**
     * If the stacktrace field should be included in Elasticsearch index.
     */
    @ConfigItem(defaultValue = LoggerSettings.IncludeStacktraceDefaultValueString)
    public boolean include;

    /**
     * The name of the stacktrace field.
     */
    @ConfigItem(name = "fieldname", defaultValue = LoggerSettings.StacktraceDefaultFieldName)
    public String fieldName;

    /**
     * The name of the stacktrace field.
     */
    @ConfigItem(name = "maxFieldLength", defaultValue = LoggerSettings.StacktraceMaxFieldLengthDefaultValueString)
    public int maxFieldLength;

}