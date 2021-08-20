package net.codinux.quarkus.logging.elasticsearch.runtime;

import io.quarkus.runtime.RuntimeValue;
import io.quarkus.runtime.annotations.Recorder;

import java.util.Optional;
import java.util.logging.Handler;

@Recorder
public class ElasticsearchLoggingRecorder {

    public RuntimeValue<Optional<Handler>> initializeElasticsearchLogging(final ElasticsearchLoggingConfig config) {
        System.out.println("Config: enabled = " + config.enable + ", host = " + config.host + ", index = " + config.indexName);

        if (!config.enable) {
            return new RuntimeValue<>(Optional.empty());
        }

        return new RuntimeValue<>(Optional.of(new TestHandler()));
    }

}