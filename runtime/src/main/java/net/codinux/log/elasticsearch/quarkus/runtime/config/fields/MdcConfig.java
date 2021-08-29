package net.codinux.log.elasticsearch.quarkus.runtime.config.fields;

import io.quarkus.runtime.annotations.ConfigGroup;
import io.quarkus.runtime.annotations.ConfigItem;

@ConfigGroup
public class MdcConfig {

    /**
     * If MDC (Mapped Diagnostic Context) should be included in Elasticsearch index.
     */
    @ConfigItem(defaultValue = "true")
    public boolean include;

}