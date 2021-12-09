package net.codinux.log.elasticsearch.quarkus.runtime.config.fields.kubernetes;

import io.quarkus.runtime.annotations.ConfigGroup;
import io.quarkus.runtime.annotations.ConfigItem;
import io.quarkus.runtime.annotations.ConvertWith;
import net.codinux.log.elasticsearch.LoggerSettings;
import net.codinux.log.elasticsearch.quarkus.runtime.config.converter.FieldNamePrefixConverter;

@ConfigGroup
public class KubernetesAnnotationsConfig {

    /**
     * If Kubernetes annotations should be included in Elasticsearch index.
     */
    @ConfigItem(defaultValue = LoggerSettings.IncludeKubernetesAnnotationsDefaultValueString)
    public boolean include;

    /**
     * Sets a prefix for all Kubernetes annotations. Defaults to "annotation".
     *
     * Empty string or special value "off" turns prefix off.
     */
    @ConfigItem(defaultValue = LoggerSettings.KubernetesAnnotationsPrefixDefaultValue)
    @ConvertWith(FieldNamePrefixConverter.class)
    public String prefix;

}