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

                config.message.name,

                config.timestamp.name,
                config.timestamp.format,

                config.level.include,
                config.level.name,

                config.logger.include,
                config.logger.name,

                config.thread.include,
                config.thread.name,

                config.hostname.include,
                config.hostname.name,

                config.stacktrace.include,
                config.stacktrace.name,

                config.mdc.include
        );
    }

}