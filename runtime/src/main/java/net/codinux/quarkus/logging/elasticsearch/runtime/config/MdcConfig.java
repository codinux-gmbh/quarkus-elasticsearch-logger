package net.codinux.quarkus.logging.elasticsearch.runtime.config;

import io.quarkus.runtime.annotations.ConfigGroup;
import io.quarkus.runtime.annotations.ConfigItem;

@ConfigGroup
public class MdcConfig {

    /**
     * If MDC (Mapped Diagnostic Context) should be included in Elasticsearch.
     */
    @ConfigItem(defaultValue = "true")
    public boolean include;

}