package net.codinux.quarkus.logging.elasticsearch.runtime.config;

import io.quarkus.runtime.annotations.ConfigGroup;
import io.quarkus.runtime.annotations.ConfigItem;
import net.codinux.log.elasticsearch.LoggerSettings;

@ConfigGroup
public class IncludeConfig {

    /**
     * If the log level field should be included in Elasticsearch.
     */
    @ConfigItem(name = "level", defaultValue = "" + LoggerSettings.IncludeLogLevelDefaultValue)
    public boolean logLevel;

    /**
     * If the logger name field should be included in Elasticsearch.
     */
    @ConfigItem(name = "logger", defaultValue = "" + LoggerSettings.IncludeLoggerNameDefaultValue)
    public boolean loggerName;

    /**
     * If the thread name field should be included in Elasticsearch.
     */
    @ConfigItem(name = "thread", defaultValue = "" + LoggerSettings.IncludeThreadNameDefaultValue)
    public boolean threadName;

    /**
     * If the hostname field should be included in Elasticsearch.
     */
    @ConfigItem(defaultValue = "" + LoggerSettings.IncludeHostNameDefaultValue)
    public boolean hostname;

    /**
     * If the stacktrace field should be included in Elasticsearch.
     */
    @ConfigItem(defaultValue = "" + LoggerSettings.IncludeStacktraceDefaultValue)
    public boolean stacktrace;

    /**
     * If MDC (Mapped Diagnostic Context) should be included in Elasticsearch.
     */
    @ConfigItem(defaultValue = "" + LoggerSettings.IncludeMdcDefaultValue)
    public boolean mdc;

}