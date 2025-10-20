package org.ferggx.SpringProject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LogTestService {
    private static final Logger log = LoggerFactory.getLogger(LogTestService.class);

    public void testLogs() {
        log.trace("Trace log");
        log.debug("Debug log");
        log.info("Info log");
        log.warn("Warn log");
        log.error("Error log");
    }

}
