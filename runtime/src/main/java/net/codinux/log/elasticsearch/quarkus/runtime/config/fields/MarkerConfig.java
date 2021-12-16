package net.codinux.log.elasticsearch.quarkus.runtime.config.fields;

import io.quarkus.runtime.annotations.ConfigGroup;
import io.quarkus.runtime.annotations.ConfigItem;
import net.codinux.log.elasticsearch.LoggerSettings;

@ConfigGroup
public class MarkerConfig {

    /**
     * If Marker should be included in Elasticsearch index.
     */
    @ConfigItem(defaultValue = LoggerSettings.IncludeMarkerDefaultValueString)
    public boolean include;

    /**
     * The name of the Marker field, defaults to "marker".
     */
    @ConfigItem(name = "fieldname", defaultValue = LoggerSettings.MarkerDefaultFieldName)
    public String fieldName;

}