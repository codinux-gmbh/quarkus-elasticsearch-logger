package net.codinux.log.elasticsearch.quarkus.deployment;

import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.FeatureBuildItem;

class QuarkusElasticsearchLoggingProcessor {

    private static final String FEATURE = "logging-elasticsearch";


    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }

}