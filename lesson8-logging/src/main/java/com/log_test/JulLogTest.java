package com.log_test;

//import java.util.logging.Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JulLogTest {
    // private static final Logger logger = Logger.getLogger(JulLogTest.class.getName());
    private static final Logger logger = LoggerFactory.getLogger(JulLogTest.class.getName());

    public static void main(String[] args) {
        logger.info("info");
        logger.info("very important info");
        logger.info("simple info");
        logger.info("AAAAA IMPORTANT AHTUNG");
    }
}
