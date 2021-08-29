package net.codinux.log.elasticsearch.quarkus.runtime.config.fields;

import io.quarkus.runtime.annotations.ConfigGroup;
import io.quarkus.runtime.annotations.ConfigItem;
import io.quarkus.runtime.annotations.ConvertWith;
import net.codinux.log.elasticsearch.TimestampFormat;

@ConfigGroup
public class TimestampConfig {

    /**
     * The format in which timestamp gets logged, either "millis" (= millis since epoch) or "formatted" (formats the timestamp as 'yyyy-MM-dd'T'HH:mm:ss.SSSZ').
     */
    @ConfigItem(defaultValue = TimestampFormatConverter.FORMATTED_FIELD_VALUE)
    @ConvertWith(TimestampFormatConverter.class)
    public TimestampFormat format;

    /**
     * The name of the timestamp field (defaults per Elasticsearch standard to @timestamp).
     */
    @ConfigItem(name = "fieldname", defaultValue = "@timestamp")
    public String fieldName;

}