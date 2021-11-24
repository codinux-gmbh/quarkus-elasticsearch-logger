# Elasticsearch logging for Quarkus

Provides sending logs from Quarkus to Elasticsearch.

Just add it to your quarkus project with Maven

```
<dependency>
    <groupId>net.codinux.log</groupId>
    <artifactId>quarkus-elasticsearch-logger</artifactId>
    <version>2.0.0-SNAPSHOT</version>
</dependency>
```

or Gradle

```
implementation 'net.codinux.log:quarkus-elasticsearch-logger:2.0.0-SNAPSHOT'
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
%dev.quarkus.log.elasticsearch.enable=false
%test.quarkus.log.elasticsearch.enable=false
```

Full list of all settings with their default value:
```
quarkus.log.elasticsearch.host=<only required configuration>

quarkus.log.elasticsearch.enable=true

quarkus.log.elasticsearch.index=logs

quarkus.log.elasticsearch.message.fieldname=message

# in which resolution timestamps should get indexed, millis, micros or nanos
quarkus.log.elasticsearch.timestamp.resolution=millis
quarkus.log.elasticsearch.timestamp.fieldname=@timestamp

quarkus.log.elasticsearch.level.include=true
quarkus.log.elasticsearch.level.fieldname=level

quarkus.log.elasticsearch.logger.include=true
quarkus.log.elasticsearch.logger.fieldname=logger

# In most cases the logger is a full qualified class name including the package names.
# If ElasticsearchLogger should try to extract the class name - that is without package name - of the logger then set this value to true
quarkus.log.elasticsearch.loggername.include=false
quarkus.log.elasticsearch.loggername.fieldname=loggername

quarkus.log.elasticsearch.threadname.include=true
quarkus.log.elasticsearch.threadname.fieldname=thread

quarkus.log.elasticsearch.hostname.include=true
quarkus.log.elasticsearch.hostname.fieldname=hos

quarkus.log.elasticsearch.stacktrace.include=true
quarkus.log.elasticsearch.stacktrace.fieldname=stacktrace

quarkus.log.elasticsearch.mdc.include=true
# set e.g. to "mdc" to have all your MDC keys prefixed with "mdc."; use special value "off" to turn prefixing field names off (=default value)
quarkus.log.elasticsearch.mdc.prefix=off

quarkus.log.elasticsearch.send-log-records-period-millis=100
quarkus.log.elasticsearch.max-log-records-per-batch=100
quarkus.log.elasticsearch.max-buffered-log-records=2000
quarkus.log.elasticsearch.period-to-log-errors=PT30M
quarkus.log.elasticsearch.error-logger-name=net.codinux.log.ElasticsearchLogger
```


# License

    Copyright 2021 codinux GmbH & Co. KG

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.