package net.codinux.quarkus.logging.elasticsearch.runtime;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class TestHandler extends Handler {
    @Override
    public void publish(LogRecord logRecord) {
        System.out.println("Logging " + logRecord.getMessage());
    }

    @Override
    public void flush() {

    }

    @Override
    public void close() throws SecurityException {

    }
}