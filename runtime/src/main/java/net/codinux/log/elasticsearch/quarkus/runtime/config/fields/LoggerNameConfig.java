package net.codinux.log.elasticsearch.quarkus.runtime.config.fields;

import io.quarkus.runtime.annotations.ConfigGroup;
import io.quarkus.runtime.annotations.ConfigItem;
import net.codinux.log.elasticsearch.LoggerSettings;

@ConfigGroup
public class LoggerNameConfig {

    /**
     * In most cases the logger is a full qualified class name including the package names.
     * If Elasticsearch logger should try to extract the class name - that is without package name - of the logger and include it in Elasticsearch index.
     */
    @ConfigItem(defaultValue = LoggerSettings.IncludeLoggerNameDefaultValueString)
    public boolean include;

    /**
     * In most cases the logger is a full qualified class name including the package names.
     * Elasticsearch logger can try to extract class' name from full qualified logger and log this.
     * This is the field name for this.
     */
    @ConfigItem(name = "fieldname", defaultValue = LoggerSettings.LoggerNameDefaultFieldName)
    public String fieldName;

}