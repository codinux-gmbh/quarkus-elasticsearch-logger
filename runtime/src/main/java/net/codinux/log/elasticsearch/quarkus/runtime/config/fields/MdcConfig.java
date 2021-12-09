package net.codinux.log.elasticsearch.quarkus.runtime.config.fields;

import io.quarkus.runtime.annotations.ConfigGroup;
import io.quarkus.runtime.annotations.ConfigItem;
import io.quarkus.runtime.annotations.ConvertWith;
import net.codinux.log.elasticsearch.LoggerSettings;
import net.codinux.log.elasticsearch.quarkus.runtime.config.converter.FieldNamePrefixConverter;

@ConfigGroup
public class MdcConfig {

    /**
     * If MDC (Mapped Diagnostic Context) should be included in Elasticsearch index.
     */
    @ConfigItem(defaultValue = LoggerSettings.IncludeMdcDefaultValueString)
    public boolean include;

    /**
     * Sets a prefix for all MDC keys.
     *
     * E.g. prefix is set to "mdc", then the MDC gets stored as:
     *  mdc.key_1=value_1
     *  mdc.key_2=value_2
     *
     * instead of:
     *  key_1=value_1
     *  key_2=value_2
     */
    @ConfigItem(defaultValue = LoggerSettings.MdcFieldsPrefixDefaultValue)
    @ConvertWith(FieldNamePrefixConverter.class)
    public String prefix;

}