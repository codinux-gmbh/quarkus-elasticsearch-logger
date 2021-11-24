package net.codinux.log.elasticsearch.quarkus.runtime;

import net.codinux.log.elasticsearch.JBossLoggingElasticsearchLogHandler;
import net.codinux.log.elasticsearch.LoggerSettings;
import net.codinux.log.elasticsearch.errorhandler.JBossLoggingErrorHandler;
import net.codinux.log.elasticsearch.errorhandler.LogPerPeriodErrorHandler;
import net.codinux.log.elasticsearch.quarkus.runtime.config.ElasticsearchLoggingConfig;

import java.time.Duration;

public class QuarkusElasticsearchLogHandler extends JBossLoggingElasticsearchLogHandler {

    public static final String ERROR_LOGGER_DEFAULT_NAME = "net.codinux.log.ElasticsearchLogger";

    public static final String PERIOD_TO_LOG_ERRORS_DEFAULT_STRING = "PT30M";


    public QuarkusElasticsearchLogHandler(ElasticsearchLoggingConfig config) {
        super(mapSettings(config), new LogPerPeriodErrorHandler(Duration.parse(config.periodToLogErrors), new JBossLoggingErrorHandler(config.errorLoggerName)));
    }

    private static net.codinux.log.elasticsearch.LoggerSettings mapSettings(ElasticsearchLoggingConfig config) {
        return new LoggerSettings(
                config.enable,

                config.elasticsearchHost,

                config.indexName,

                config.message.fieldName,

                config.timestamp.resolution,
                config.timestamp.fieldName,

                config.level.include,
                config.level.fieldName,

                config.logger.include,
                config.logger.fieldName,

                config.loggerName.include,
                config.loggerName.fieldName,

                config.threadName.include,
                config.threadName.fieldName,

                config.hostName.include,
                config.hostName.fieldName,

                config.stacktrace.include,
                config.stacktrace.fieldName,

                config.mdc.include,
                config.mdc.prefix,

                config.maxLogRecordsPerBatch,
                config.maxBufferedLogRecords,
                config.sendLogRecordsPeriodMillis
        );
    }

}