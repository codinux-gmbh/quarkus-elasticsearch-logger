package net.codinux.log.elasticsearch.quarkus.runtime.config.converter;

import org.eclipse.microprofile.config.spi.Converter;

public class FieldNamePrefixConverter implements Converter<String> {

    @Override
    public String convert(String value) {
        if (value == null || value.isBlank()) {
            return "";
        }

        return value.trim();
    }

}