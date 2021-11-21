package net.codinux.log.elasticsearch.quarkus.runtime.config.converter;

import net.codinux.log.elasticsearch.quarkus.runtime.config.DefaultConfigValues;
import org.eclipse.microprofile.config.spi.Converter;

public class FieldNamePrefixConverter implements Converter<String> {

    @Override
    public String convert(String value) {
        if (value == null || value.isBlank() || DefaultConfigValues.DisableFieldNamePrefix.equalsIgnoreCase(value)) {
            return "";
        }

        return value.trim();
    }

}