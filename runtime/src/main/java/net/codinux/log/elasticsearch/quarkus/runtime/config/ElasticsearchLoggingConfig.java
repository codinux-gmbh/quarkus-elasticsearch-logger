package net.codinux.log.elasticsearch.quarkus.runtime.config;

import io.quarkus.runtime.annotations.ConfigItem;
import io.quarkus.runtime.annotations.ConfigPhase;
import io.quarkus.runtime.annotations.ConfigRoot;
import io.quarkus.runtime.annotations.ConvertWith;
import net.codinux.log.elasticsearch.TimestampFormat;

@ConfigRoot(phase = ConfigPhase.RUN_TIME, name = "log.elasticsearch")
public class ElasticsearchLoggingConfig {

    /**
     * If logging to Elasticsearch should be enabled or not.
     */
    @ConfigItem(defaultValue = "true")
    public boolean enable;

    /**
     * Elasticsearch host.
     */
    @ConfigItem(name = "host")
    public String elasticsearchHost;

    /**
     * To which index to log to.
     */
    @ConfigItem(name = "index", defaultValue = "logs")
    public String indexName;

    /**
     * The format in which timestamp gets logged, either "millis" (= millis since epoch) or "formatted" (formats the timestamp as 'yyyy-MM-dd'T'HH:mm:ss.SSSZ').
     */
    @ConfigItem(name = "timestampformat", defaultValue = TimestampFormatConverter.FORMATTED_FIELD_VALUE)
    @ConvertWith(TimestampFormatConverter.class)
    public TimestampFormat timestampFormat;

    public IncludeConfig include;

    public FieldNameConfig fieldname;

}