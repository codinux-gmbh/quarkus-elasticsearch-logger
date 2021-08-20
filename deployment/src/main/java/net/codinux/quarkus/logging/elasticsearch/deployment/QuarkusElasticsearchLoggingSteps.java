package net.codinux.quarkus.logging.elasticsearch.deployment;

import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.annotations.ExecutionTime;
import io.quarkus.deployment.annotations.Record;
import io.quarkus.deployment.builditem.LogHandlerBuildItem;
import net.codinux.quarkus.logging.elasticsearch.runtime.ElasticsearchLoggingConfig;
import net.codinux.quarkus.logging.elasticsearch.runtime.ElasticsearchLoggingRecorder;

public class QuarkusElasticsearchLoggingSteps {

    @BuildStep
    @Record(ExecutionTime.RUNTIME_INIT)
    public LogHandlerBuildItem setUpFormatter(ElasticsearchLoggingRecorder recorder, ElasticsearchLoggingConfig config) {
        return new LogHandlerBuildItem(recorder.initializeElasticsearchLogging(config));
    }

}