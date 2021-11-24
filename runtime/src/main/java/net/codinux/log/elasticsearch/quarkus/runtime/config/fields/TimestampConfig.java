package net.codinux.log.elasticsearch.quarkus.runtime.config.fields;

import io.quarkus.runtime.annotations.ConfigGroup;
import io.quarkus.runtime.annotations.ConfigItem;
import io.quarkus.runtime.annotations.ConvertWith;
import net.codinux.log.elasticsearch.LoggerSettings;
import net.codinux.log.elasticsearch.TimestampResolution;
import net.codinux.log.elasticsearch.quarkus.runtime.config.converter.TimestampResolutionConverter;

@ConfigGroup
public class TimestampConfig {

    /**
     * The resolution in which timestamp gets sent to Elasticsearch, either "millis", "micros" or "nanos" for milliseconds, microseconds or nanoseconds
     * resolution.
     *
     * But for resolutions greater than milliseconds, the type of Elasticsearch index's timestamp field has to be set to "date_nanos" before the first log
     * gets sent to index, see README.md. And this field type is only supported by Elasticsearch 7.1 and above (+ Kibana 7.4 and above?).
     */
    @ConfigItem(defaultValue = TimestampResolutionConverter.DEFAULT_RESOLUTION)
    @ConvertWith(TimestampResolutionConverter.class)
    public TimestampResolution resolution;

    /**
     * The name of the timestamp field (defaults per Elasticsearch standard to @timestamp).
     */
    @ConfigItem(name = "fieldname", defaultValue = LoggerSettings.TimestampDefaultFieldName)
    public String fieldName;

}