package net.codinux.log.elasticsearch.quarkus.runtime;

import net.codinux.log.elasticsearch.JBossLoggingElasticsearchLogHandler;
import net.codinux.log.elasticsearch.LoggerSettings;
import net.codinux.log.elasticsearch.quarkus.runtime.config.ElasticsearchLoggingConfig;

public class QuarkusElasticsearchLogHandler extends JBossLoggingElasticsearchLogHandler {

    public QuarkusElasticsearchLogHandler(ElasticsearchLoggingConfig config) {
        super(mapSettings(config));
    }

    private static net.codinux.log.elasticsearch.LoggerSettings mapSettings(ElasticsearchLoggingConfig config) {
        return new LoggerSettings(
                config.enable,

                config.elasticsearchHost,

                config.indexName,

                config.message.fieldName,

                config.timestamp.fieldName,
                config.timestamp.format,

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

                LoggerSettings.MaxLogRecordsPerBatchDefaultValue,
                LoggerSettings.MaxBufferedLogRecordsDefaultValue,
                LoggerSettings.SendLogRecordsPeriodMillisDefaultValue
        );
    }

}