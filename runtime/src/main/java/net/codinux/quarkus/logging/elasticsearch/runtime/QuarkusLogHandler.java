package net.codinux.quarkus.logging.elasticsearch.runtime;

import net.codinux.log.elasticsearch.JBossLoggingElasticsearchLogHandler;
import net.codinux.log.elasticsearch.LoggerSettings;
import net.codinux.quarkus.logging.elasticsearch.runtime.config.ElasticsearchLoggingConfig;

public class QuarkusLogHandler extends JBossLoggingElasticsearchLogHandler {

    public QuarkusLogHandler(ElasticsearchLoggingConfig config) {
        super(mapSettings(config));
    }

    private static net.codinux.log.elasticsearch.LoggerSettings mapSettings(ElasticsearchLoggingConfig config) {
        return new LoggerSettings(
                config.enable,

                config.elasticsearchHost,

                config.indexName,

                config.fieldname.message,

                config.fieldname.timestamp,
                config.timestampFormat,

                config.include.logLevel,
                config.fieldname.logLevel,

                config.include.loggerName,
                config.fieldname.loggerName,

                config.include.threadName,
                config.fieldname.threadName,

                config.include.hostname,
                config.fieldname.hostname,

                config.include.stacktrace,
                config.fieldname.stacktrace,

                config.include.mdc
        );
    }

}