package net.codinux.log.elasticsearch.quarkus.runtime;

import net.codinux.log.elasticsearch.JBossLoggingElasticsearchLogHandler;
import net.codinux.log.elasticsearch.LoggerSettings;
import net.codinux.log.elasticsearch.converter.ElasticsearchIndexNameConverter;
import net.codinux.log.elasticsearch.errorhandler.JBossLoggingErrorHandler;
import net.codinux.log.elasticsearch.errorhandler.LogPerPeriodErrorHandler;
import net.codinux.log.elasticsearch.quarkus.runtime.config.ElasticsearchLoggingConfig;

import java.time.Duration;

public class QuarkusElasticsearchLogHandler extends JBossLoggingElasticsearchLogHandler {

    public static final String ERROR_LOGGER_DEFAULT_NAME = "net.codinux.log.ElasticsearchLogger";

    public static final String PERIOD_TO_LOG_ERRORS_DEFAULT_STRING = "PT30M";


    public QuarkusElasticsearchLogHandler(ElasticsearchLoggingConfig config) {
        super(new LogPerPeriodErrorHandler(Duration.parse(config.periodToLogErrors), new JBossLoggingErrorHandler(config.errorLoggerName)), mapSettings(config));
    }

    private static net.codinux.log.elasticsearch.LoggerSettings mapSettings(ElasticsearchLoggingConfig config) {
        ElasticsearchIndexNameConverter indexNameConverter = new ElasticsearchIndexNameConverter();
        String indexName = indexNameConverter.createIndexName(config.indexName, new JBossLoggingErrorHandler(config.errorLoggerName));

        return new LoggerSettings(
                config.enable,

                config.elasticsearchHost,

                indexName,

                config.message.fieldName,

                config.timestamp.resolution,
                config.timestamp.fieldName,

                config.logLevel.include,
                config.logLevel.fieldName,

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

                config.kubernetesInfo.include,
                config.kubernetesInfo.prefix,

                config.kubernetesInfo.labels.include,
                config.kubernetesInfo.labels.prefix,

                config.kubernetesInfo.annotations.include,
                config.kubernetesInfo.annotations.prefix,

                config.maxLogRecordsPerBatch,
                config.maxBufferedLogRecords,
                config.sendLogRecordsPeriodMillis
        );
    }

}