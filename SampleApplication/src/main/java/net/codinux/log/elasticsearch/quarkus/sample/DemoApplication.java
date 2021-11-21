package net.codinux.log.elasticsearch.quarkus.sample;

import io.quarkus.runtime.Startup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

@Startup
@ApplicationScoped
public class DemoApplication {

    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);


    @PostConstruct
    void sampleLogOutput() {
        log.debug("My log level is too low, I will not be logged");

        log.info("Info log");

        log.warn("Warn");

        log.error("Error without Exception");
        log.error("Error with Exception", new Exception("Just a test, no animals were harmed during these tests"));
    }

}