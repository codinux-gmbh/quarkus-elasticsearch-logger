package net.codinux.quarkus.logging.elasticsearch.runtime.config;

import net.codinux.log.elasticsearch.TimestampFormat;
import org.eclipse.microprofile.config.spi.Converter;

public class TimestampFormatConverter  implements Converter<TimestampFormat> {

    public static final String MILLIS_FIELD_VALUE = "millis";

    public static final String FORMATTED_FIELD_VALUE = "formatted";


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
