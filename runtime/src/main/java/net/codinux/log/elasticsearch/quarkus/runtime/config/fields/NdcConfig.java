package net.codinux.log.elasticsearch.quarkus.runtime.config.fields;

import io.quarkus.runtime.annotations.ConfigGroup;
import io.quarkus.runtime.annotations.ConfigItem;
import net.codinux.log.elasticsearch.LoggerSettings;

@ConfigGroup
public class NdcConfig {

    /**
     * If NDC (Nested Diagnostic Context) should be included in Elasticsearch index.
     */
    @ConfigItem(defaultValue = LoggerSettings.IncludeNdcDefaultValueString)
    public boolean include;

    /**
     * The name of the NDC field, defaults to "ndc".
     */
    @ConfigItem(name = "fieldname", defaultValue = LoggerSettings.NdcDefaultFieldName)
    public String fieldName;

}