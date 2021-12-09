package net.codinux.log.elasticsearch.quarkus.runtime.config.fields.kubernetes;

import io.quarkus.runtime.annotations.ConfigGroup;
import io.quarkus.runtime.annotations.ConfigItem;
import io.quarkus.runtime.annotations.ConvertWith;
import net.codinux.log.elasticsearch.LoggerSettings;
import net.codinux.log.elasticsearch.quarkus.runtime.config.converter.FieldNamePrefixConverter;

@ConfigGroup
public class KubernetesLabelsConfig {

    /**
     * If Kubernetes labels should be included in Elasticsearch index.
     */
    @ConfigItem(defaultValue = LoggerSettings.IncludeKubernetesLabelsDefaultValueString)
    public boolean include;

    /**
     * Sets a prefix for all Kubernetes labels. Defaults to "label".
     *
     * Empty string or special value "off" turns prefix off.
     */
    @ConfigItem(defaultValue = LoggerSettings.KubernetesLabelsPrefixDefaultValue)
    @ConvertWith(FieldNamePrefixConverter.class)
    public String prefix;

}