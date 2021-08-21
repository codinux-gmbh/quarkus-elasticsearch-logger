package net.codinux.quarkus.logging.elasticsearch.runtime.config;

import io.quarkus.runtime.annotations.ConfigGroup;
import io.quarkus.runtime.annotations.ConfigItem;

@ConfigGroup
public class MessageConfig {

    /**
     * The name of the message field.
     */
    @ConfigItem(defaultValue = "message")
    public String name;

}