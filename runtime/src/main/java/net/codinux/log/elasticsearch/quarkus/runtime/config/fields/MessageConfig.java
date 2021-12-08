package net.codinux.log.elasticsearch.quarkus.runtime.config.fields;

import io.quarkus.runtime.annotations.ConfigGroup;
import io.quarkus.runtime.annotations.ConfigItem;
import net.codinux.log.elasticsearch.LoggerSettings;

@ConfigGroup
public class MessageConfig {

    /**
     * The name of the message field.
     */
    @ConfigItem(name = "fieldname", defaultValue = LoggerSettings.MessageDefaultFieldName)
    public String fieldName;

}