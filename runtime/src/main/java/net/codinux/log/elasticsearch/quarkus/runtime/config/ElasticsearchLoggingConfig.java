package net.codinux.log.elasticsearch.quarkus.runtime.config;

import io.quarkus.runtime.annotations.ConfigItem;
import io.quarkus.runtime.annotations.ConfigPhase;
import io.quarkus.runtime.annotations.ConfigRoot;
import net.codinux.log.elasticsearch.LoggerSettings;
import net.codinux.log.elasticsearch.quarkus.runtime.QuarkusElasticsearchLogHandler;
import net.codinux.log.elasticsearch.quarkus.runtime.config.fields.HostNameConfig;
import net.codinux.log.elasticsearch.quarkus.runtime.config.fields.MarkerConfig;
import net.codinux.log.elasticsearch.quarkus.runtime.config.fields.NdcConfig;
import net.codinux.log.elasticsearch.quarkus.runtime.config.fields.kubernetes.KubernetesInfoConfig;
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
    @ConfigItem(defaultValue = LoggerSettings.EnabledDefaultValueString)
    public boolean enable;

    /**
     * Elasticsearch host.
     */
    @ConfigItem(name = "host")
    public String elasticsearchHost;

    /**
     * If authentication is required: The username.
     */
    @ConfigItem(defaultValue = LoggerSettings.UsernameDefaultValueString)
    public String username;

    /**
     * If authentication is required: The password.
     */
    @ConfigItem(defaultValue = LoggerSettings.PasswordDefaultValueString)
    public String password;

    /**
     * If authentication is required: The password.
     */
    @ConfigItem(name = "disable-certificate-check", defaultValue = LoggerSettings.DisableCertificateCheckDefaultValueString)
    public Boolean disableCertificateCheck;

    /**
     * To which index to log to.
     */
    @ConfigItem(name = "index", defaultValue = LoggerSettings.IndexNameDefaultValue)
    public String indexName;

    public MessageConfig message;

    public TimestampConfig timestamp;

    /**
     * Config for the log level.
     */
    @ConfigItem(name = "level")
    public LogLevelConfig logLevel;

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

    public MarkerConfig marker;

    public NdcConfig ndc;

    /**
     * Configure which Kubernetes values to include in log.
     */
    @ConfigItem(name = "kubernetes")
    public KubernetesInfoConfig kubernetesInfo;

    /**
     * The maximum number of log records that are send in one batch to Elasticsearch.
     */
    @ConfigItem(defaultValue = "" + LoggerSettings.MaxLogRecordsPerBatchDefaultValue)
    public int maxLogRecordsPerBatch;

    /**
     * The maximum number of log records being buffered before the get dropped and therefore irrevocably get lost.
     */
    @ConfigItem(defaultValue = "" + LoggerSettings.MaxBufferedLogRecordsDefaultValue)
    public int maxBufferedLogRecords;

    /**
     * The interval in which log records get send to Elasticsearch in milliseconds.
     */
    @ConfigItem(defaultValue = "" + LoggerSettings.SendLogRecordsPeriodMillisDefaultValue)
    public int sendLogRecordsPeriodMillis;

    /**
     * The logger name under which Elasticsearch Logger logs its internal errors.
     */
    @ConfigItem(defaultValue = QuarkusElasticsearchLogHandler.ERROR_LOGGER_DEFAULT_NAME)
    public String errorLoggerName;

    /**
     * To not flood logs with errors like ConnectionException internal errors get logged only once per a configurable period (default: once per 30 minutes).
     * Accepted formats are based on the ISO-8601 duration format. The format for the value is "PnDTnHnMn.nS" where "nDT" means "n" number of 
     * Days, "nH" means "n" number of Hours, "nM" means "n" number of Minutes and "nS" means "n" number of Seconds.
     */
    @ConfigItem(defaultValue = QuarkusElasticsearchLogHandler.PERIOD_TO_LOG_ERRORS_DEFAULT_STRING)
    public String periodToLogErrors;

}