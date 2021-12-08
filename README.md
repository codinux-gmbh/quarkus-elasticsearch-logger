# Elasticsearch logging for Quarkus

Provides sending logs from Quarkus to Elasticsearch.

## Features

- Nanoseconds timestamp resolution (if supported by system), see set-up below
- Supports MDC (Mapped Diagnostic Context)

## Setup

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

# at which resolution timestamps should get indexed, millis, micros or nanos
# see remarks below to enable resolutions higher than milliseconds in Elasticsearch
quarkus.log.elasticsearch.timestamp.resolution=millis
quarkus.log.elasticsearch.timestamp.fieldname=@timestamp

quarkus.log.elasticsearch.level.include=true
quarkus.log.elasticsearch.level.fieldname=level

quarkus.log.elasticsearch.logger.include=true
quarkus.log.elasticsearch.logger.fieldname=logger

# In most cases the logger is a full qualified class name including the package name.
# If ElasticsearchLogger should try to extract the class name - that is without package name - of the logger then set this value to true
quarkus.log.elasticsearch.loggername.include=false
quarkus.log.elasticsearch.loggername.fieldname=loggername

quarkus.log.elasticsearch.threadname.include=true
quarkus.log.elasticsearch.threadname.fieldname=thread

quarkus.log.elasticsearch.hostname.include=true
quarkus.log.elasticsearch.hostname.fieldname=host

quarkus.log.elasticsearch.stacktrace.include=true
quarkus.log.elasticsearch.stacktrace.fieldname=stacktrace

# if MDC (Mapped Diagnostic Context) should be included in Elasticsearch index.
quarkus.log.elasticsearch.mdc.include=true
# set e.g. to "mdc" to have all your MDC keys prefixed with "mdc."; use special value "off" to turn prefixing field names off
quarkus.log.elasticsearch.mdc.prefix=mdc

# includes info about current pod in logs if running in a Kubernetes environment (will be ignored if application does not run in Kubernetes)
quarkus.log.elasticsearch.kubernetes.include=false
# the value all Kubernetes info keys will be prefixed with. Use empty string or special value "off" to turn prefixing field names off
quarkus.log.elasticsearch.kubernetes.prefix=k8s

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