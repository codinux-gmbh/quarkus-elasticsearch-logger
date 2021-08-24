# Elasticsearch logging for Quarkus

Provides sending logs from Quarkus to Elasticsearch.

Just add it to your quarkus project with Maven

```
<dependency>
    <groupId>net.codinux.log</groupId>
    <artifactId>quarkus-elasticsearch-logger</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

or Gradle

```
implementation 'net.codinux.log:quarkus-elasticsearch-logger:1.0.0-SNAPSHOT'
```

## Configuration

Minimal required configuration:
```
# address of your Elasticsearch instance
quarkus.log.elasticsearch.host=http://localhost:9200
```

Preferably also set index name and depending on your setup disable logging to Elasticsearch in tests and dev mode:
```
quarkus.log.elasticsearch.host=http://localhost:9200
quarkus.log.elasticsearch.index=my-app-logs
%test.quarkus.log.elasticsearch.enable=false
```

Full list of all settings with their default value:
```
quarkus.log.elasticsearch.host=<only required configuration>

quarkus.log.elasticsearch.index=logs

# alternative value: millis
quarkus.log.elasticsearch.timestampformat=formatted

quarkus.log.elasticsearch.include.level=true
quarkus.log.elasticsearch.include.logger=true
quarkus.log.elasticsearch.include.thread=true
quarkus.log.elasticsearch.include.hostname=true
quarkus.log.elasticsearch.include.stacktrace=true
quarkus.log.elasticsearch.include.mdc=true

quarkus.log.elasticsearch.fieldname.message=message
quarkus.log.elasticsearch.fieldname.timestamp=@timestamp
quarkus.log.elasticsearch.fieldname.level=level
quarkus.log.elasticsearch.fieldname.logger=logger
quarkus.log.elasticsearch.fieldname.thread=thread
quarkus.log.elasticsearch.fieldname.hostname=host
quarkus.log.elasticsearch.fieldname.stacktrace=stacktrace
```
