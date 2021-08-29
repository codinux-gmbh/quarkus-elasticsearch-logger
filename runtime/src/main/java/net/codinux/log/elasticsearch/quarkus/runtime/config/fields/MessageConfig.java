package net.codinux.log.elasticsearch.quarkus.runtime.config.fields;

import io.quarkus.runtime.annotations.ConfigGroup;
import io.quarkus.runtime.annotations.ConfigItem;

@ConfigGroup
public class MessageConfig {

    /**
     * The name of the message field.
     */
    @ConfigItem(name = "fieldname", defaultValue = "message")
    public String fieldName;

}