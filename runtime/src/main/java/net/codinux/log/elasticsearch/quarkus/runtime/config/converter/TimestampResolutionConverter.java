package net.codinux.log.elasticsearch.quarkus.runtime.config.converter;

import net.codinux.log.elasticsearch.TimestampResolution;
import org.eclipse.microprofile.config.spi.Converter;

public class TimestampResolutionConverter implements Converter<TimestampResolution> {

    public static final String DEFAULT_RESOLUTION = net.codinux.log.elasticsearch.TimestampResolutionConverter.MillisecondsConfigValue;


    private final net.codinux.log.elasticsearch.TimestampResolutionConverter converter = new net.codinux.log.elasticsearch.TimestampResolutionConverter();


    @Override
    public TimestampResolution convert(String value) {
        return converter.convert(value);
    }

}
