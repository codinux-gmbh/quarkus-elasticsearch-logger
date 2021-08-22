package net.codinux.log.elasticsearch.quarkus.deployment;

import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.annotations.ExecutionTime;
import io.quarkus.deployment.annotations.Record;
import io.quarkus.deployment.builditem.LogHandlerBuildItem;
import net.codinux.log.elasticsearch.quarkus.runtime.config.ElasticsearchLoggingConfig;
import net.codinux.log.elasticsearch.quarkus.runtime.ElasticsearchLoggingRecorder;

public class QuarkusElasticsearchLoggingSteps {

    @BuildStep
    @Record(ExecutionTime.RUNTIME_INIT)
    public LogHandlerBuildItem setUpFormatter(ElasticsearchLoggingRecorder recorder, ElasticsearchLoggingConfig config) {
        return new LogHandlerBuildItem(recorder.initializeElasticsearchLogging(config));
    }

}