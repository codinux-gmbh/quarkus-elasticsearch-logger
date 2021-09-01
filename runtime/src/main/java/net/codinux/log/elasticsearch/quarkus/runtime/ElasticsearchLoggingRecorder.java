package net.codinux.log.elasticsearch.quarkus.runtime;

import io.quarkus.runtime.RuntimeValue;
import io.quarkus.runtime.annotations.Recorder;
import net.codinux.log.elasticsearch.quarkus.runtime.config.ElasticsearchLoggingConfig;

import java.util.Optional;
import java.util.logging.Handler;

@Recorder
public class ElasticsearchLoggingRecorder {

    public RuntimeValue<Optional<Handler>> initializeElasticsearchLogging(final ElasticsearchLoggingConfig config) {

        if (!config.enable) {
            return new RuntimeValue<>(Optional.empty());
        }

        if (config.elasticsearchHost == null || config.elasticsearchHost.isBlank()) {
            throw new IllegalArgumentException("If elasticsearch-logger is enabled, host value pointing to your Elasticsearch instance must be configured");
        }

        return new RuntimeValue<>(Optional.of(new QuarkusElasticsearchLogHandler(config)));
    }

}