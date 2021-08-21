package net.codinux.quarkus.logging.elasticsearch.runtime.config;

import io.quarkus.runtime.annotations.ConfigItem;
import io.quarkus.runtime.annotations.ConfigPhase;
import io.quarkus.runtime.annotations.ConfigRoot;

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

    public LoggerNameConfig logger;

    public HostNameConfig hostname;

    public ThreadNameConfig thread;

    public StacktraceConfig stacktrace;

    public MdcConfig mdc;

}