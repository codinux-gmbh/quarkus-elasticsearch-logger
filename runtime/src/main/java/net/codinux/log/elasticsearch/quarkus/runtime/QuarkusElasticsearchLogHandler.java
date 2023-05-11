package net.codinux.log.elasticsearch.quarkus.runtime;

import kotlin.text.MatchResult;
import net.codinux.log.elasticsearch.JBossLoggingElasticsearchLogHandler;
import net.codinux.log.elasticsearch.LoggerSettings;
import net.codinux.log.elasticsearch.converter.ElasticsearchIndexNameConverter;
import net.codinux.log.elasticsearch.errorhandler.JBossLoggingErrorHandler;
import net.codinux.log.elasticsearch.errorhandler.LogPerPeriodErrorHandler;
import net.codinux.log.elasticsearch.quarkus.runtime.config.ElasticsearchLoggingConfig;

import java.time.Duration;
import java.util.List;

public class QuarkusElasticsearchLogHandler extends JBossLoggingElasticsearchLogHandler {

    public static final String ERROR_LOGGER_DEFAULT_NAME = "net.codinux.log.ElasticsearchLogger";

    public static final String PERIOD_TO_LOG_ERRORS_DEFAULT_STRING = "PT30M";


    public QuarkusElasticsearchLogHandler(ElasticsearchLoggingConfig config) {
        super(new LogPerPeriodErrorHandler(Duration.parse(config.periodToLogErrors), new JBossLoggingErrorHandler(config.errorLoggerName)), mapSettings(config));
    }

    private static net.codinux.log.elasticsearch.LoggerSettings mapSettings(ElasticsearchLoggingConfig config) {
        ElasticsearchIndexNameConverter indexNameConverter = new ElasticsearchIndexNameConverter();
        String indexNamePattern = indexNameConverter.buildIndexName(config.indexName, new JBossLoggingErrorHandler(config.errorLoggerName));
        List<MatchResult> patterns = indexNameConverter.getIncludedPatterns(indexNamePattern);

        return new LoggerSettings(
                config.enable,

                config.elasticsearchHost,

                getNullableString(config.username), // the default value is the string "null" -> convert it to null if necessary
                getNullableString(config.password), // the default value is the string "null" -> convert it to null if necessary

                config.disableCertificateCheck,

                indexNamePattern,
                patterns,

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
                config.stacktrace.maxFieldLength,

                config.mdc.include,
                config.mdc.prefix,

                config.marker.include,
                config.marker.fieldName,

                config.ndc.include,
                config.ndc.fieldName,

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


    private static String getNullableString(String string) {
        if (string.isBlank() || "null".equals(string)) {
            return null;
        }

        return string;
    }

}