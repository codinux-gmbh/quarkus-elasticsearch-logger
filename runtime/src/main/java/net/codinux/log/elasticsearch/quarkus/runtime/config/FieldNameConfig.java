package net.codinux.log.elasticsearch.quarkus.runtime.config;

import io.quarkus.runtime.annotations.ConfigGroup;
import io.quarkus.runtime.annotations.ConfigItem;
import net.codinux.log.elasticsearch.LoggerSettings;

@ConfigGroup
public class FieldNameConfig {

    /**
     * The name of the message field.
     */
    @ConfigItem(defaultValue = LoggerSettings.MessageDefaultFieldName)
    public String message;

    /**
     * The name of the timestamp field (defaults per Elasticsearch standard to @timestamp).
     */
    @ConfigItem(defaultValue = LoggerSettings.TimestampDefaultFieldName)
    public String timestamp;

    /**
     * The name of the log level field.
     */
    @ConfigItem(name = "level", defaultValue = LoggerSettings.LogLevelDefaultFieldName)
    public String logLevel;

    /**
     * The name of the logger field (that is the full qualified logger name which includes in most cases the package names).
     */
    @ConfigItem(name = "logger", defaultValue = LoggerSettings.LoggerDefaultFieldName)
    public String logger;

    /**
     * In most cases the logger is a full qualified class name including the package names.
     * Elasticsearch logger can try to extract only class' name from full qualified logger and log this.
     * This is the field name for this.
     */
    @ConfigItem(name = "loggername", defaultValue = LoggerSettings.LoggerNameDefaultFieldName)
    public String loggerName;

    /**
     * The name of the thread name field.
     */
    @ConfigItem(name = "thread", defaultValue = LoggerSettings.ThreadNameDefaultFieldName)
    public String threadName;

    /**
     * The name of the hostname field.
     */
    @ConfigItem(defaultValue = LoggerSettings.HostNameDefaultFieldName)
    public String hostname;

    /**
     * The name of the stacktrace field.
     */
    @ConfigItem(defaultValue = LoggerSettings.StacktraceDefaultFieldName)
    public String stacktrace;

}