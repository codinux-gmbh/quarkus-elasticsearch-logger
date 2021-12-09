package net.codinux.log.elasticsearch.quarkus.runtime.config.fields;

import io.quarkus.runtime.annotations.ConfigGroup;
import io.quarkus.runtime.annotations.ConfigItem;
import io.quarkus.runtime.annotations.ConvertWith;
import net.codinux.log.elasticsearch.LoggerSettings;
import net.codinux.log.elasticsearch.quarkus.runtime.config.converter.FieldNamePrefixConverter;

@ConfigGroup
public class KubernetesInfoConfig {

    /**
     * If Pod and Kubernetes info should be included in Elasticsearch index.
     */
    @ConfigItem(defaultValue = LoggerSettings.IncludeKubernetesInfoDefaultValueString)
    public boolean include;

    /**
     * Sets a prefix for all Kubernetes info keys. Defaults to "k8s".
     *
     * Empty string or special value "off" turns prefix off.
     */
    @ConfigItem(defaultValue = LoggerSettings.KubernetesFieldsPrefixDefaultValue)
    @ConvertWith(FieldNamePrefixConverter.class)
    public String prefix;

}