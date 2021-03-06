package net.codinux.log.elasticsearch.quarkus.sample;

import io.quarkus.runtime.Startup;
import org.jboss.logging.NDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.slf4j.MarkerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@Startup
@ApplicationScoped
public class DemoApplication {

    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);


    @PostConstruct
    void sampleLogOutput() {
        MDC.put("traceId", UUID.randomUUID().toString()); // as a sample adds a traceId to all logs below

        log.debug("My log level is too low, I will not be logged");

        log.info("Info log");

        log.warn("Warn");

        log.error("Error without Exception");
        log.error("Error with Exception", new Exception("Just a test, no animals were harmed during these tests"));

        MDC.put("key1", "value1");
        log.info("With second MDC value");

        NDC.push("NDC 1");
        NDC.push("NDC 2");
        log.info("Message with NDC");
        NDC.clear();

        // Marker seems not to be supported by JBoss Logging, will have no effect
        log.info(MarkerFactory.getMarker("ImportantMarker"), "Message with marker, but will have no effect in JBoss Logging");
    }

}