package net.codinux.log.elasticsearch.quarkus.runtime.config;

import io.quarkus.runtime.annotations.ConfigItem;
import io.quarkus.runtime.annotations.ConfigPhase;
import io.quarkus.runtime.annotations.ConfigRoot;
import net.codinux.log.elasticsearch.quarkus.runtime.config.fields.HostNameConfig;
import net.codinux.log.elasticsearch.quarkus.runtime.config.fields.LogLevelConfig;
import net.codinux.log.elasticsearch.quarkus.runtime.config.fields.LoggerConfig;
import net.codinux.log.elasticsearch.quarkus.runtime.config.fields.LoggerNameConfig;
import net.codinux.log.elasticsearch.quarkus.runtime.config.fields.MdcConfig;
import net.codinux.log.elasticsearch.quarkus.runtime.config.fields.MessageConfig;
import net.codinux.log.elasticsearch.quarkus.runtime.config.fields.StacktraceConfig;
import net.codinux.log.elasticsearch.quarkus.runtime.config.fields.ThreadNameConfig;
import net.codinux.log.elasticsearch.quarkus.runtime.config.fields.TimestampConfig;

@ConfigRoot(phase = ConfigPhase.RUN_TIME, name = "log.elasticsearch")
public class ElasticsearchLoggingConfig {

    /**
     * If logging to Elasticsearch should be enabled or not.
     */
    @ConfigItem(defaultValue = "true")
    public boolean enable;

    /**
     * Elasticsearch host.
     */
    @ConfigItem(name = "host")
    public String elasticsearchHost;

    /**
     * To which index to log to.
     */
    @ConfigItem(name = "index", defaultValue = "logs")
    public String indexName;

    public MessageConfig message;

    public TimestampConfig timestamp;

    public LogLevelConfig level;

    public LoggerConfig logger;

    /**
     * Config for the logger name.
     */
    @ConfigItem(name = "loggername")
    public LoggerNameConfig loggerName;

    /**
     * Config for the host name.
     */
    @ConfigItem(name = "hostname")
    public HostNameConfig hostName;

    /**
     * Config for the thread name.
     */
    @ConfigItem(name = "threadname")
    public ThreadNameConfig threadName;

    public StacktraceConfig stacktrace;

    public MdcConfig mdc;

}