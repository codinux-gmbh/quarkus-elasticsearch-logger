package net.codinux.quarkus.logging.elasticsearch.runtime;

import io.quarkus.runtime.annotations.ConfigItem;
import io.quarkus.runtime.annotations.ConfigPhase;
import io.quarkus.runtime.annotations.ConfigRoot;

@ConfigRoot(phase = ConfigPhase.RUN_TIME, name = "log.elasticsearch")
public class ElasticsearchLoggingConfig {

    /**
     * If logging to Elasticsearch should be enabled or not.
     */
    @ConfigItem(name = ConfigItem.PARENT, defaultValue = "true")
    boolean enable;

    /**
     * Elasticsearch host.
     */
    @ConfigItem()
    String host;

    /**
     * To which index to log to.
     */
    @ConfigItem(name = "index", defaultValue = "logs")
    String indexName;

}