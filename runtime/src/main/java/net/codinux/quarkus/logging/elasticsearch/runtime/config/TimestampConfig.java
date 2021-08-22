package net.codinux.quarkus.logging.elasticsearch.runtime.config;

import io.quarkus.runtime.annotations.ConfigGroup;
import io.quarkus.runtime.annotations.ConfigItem;
import io.quarkus.runtime.annotations.ConvertWith;
import net.codinux.log.elasticsearch.TimestampFormat;
import org.eclipse.microprofile.config.spi.Converter;

@ConfigGroup
public class TimestampConfig {

    public static final String MILLIS_FIELD_VALUE = "millis";

    public static final String FORMATTED_FIELD_VALUE = "formatted";


    /**
     * The name of the timestamp field (defaults per Elasticsearch standard to @timestamp).
     */
    @ConfigItem(defaultValue = "@timestamp")
    public String name;

    /**
     * The format in which timestamp gets logged, either "millis" (= millis since epoch) or "formatted" (formats the timestamp as 'yyyy-MM-dd'T'HH:mm:ss.SSSZ').
     */
    @ConfigItem(defaultValue = FORMATTED_FIELD_VALUE)
    @ConvertWith(TimestampFormatConverter.class)
    public TimestampFormat format;


    public static class TimestampFormatConverter implements Converter<TimestampFormat> {

        @Override
        public TimestampFormat convert(String value) {
            String lowerCase = value.toLowerCase();

            if (MILLIS_FIELD_VALUE.equals(lowerCase)) {
                return TimestampFormat.MILLIS_SINCE_EPOCH;
            } else if (FORMATTED_FIELD_VALUE.equals(lowerCase)) {
                return TimestampFormat.FORMATTED_DATE_TIME;
            }

            return TimestampFormat.valueOf(value.toUpperCase());
        }

    }

}