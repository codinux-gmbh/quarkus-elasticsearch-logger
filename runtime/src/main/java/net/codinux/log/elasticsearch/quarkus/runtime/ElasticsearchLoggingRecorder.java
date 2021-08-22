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

        return new RuntimeValue<>(Optional.of(new QuarkusLogHandler(config)));
    }

}