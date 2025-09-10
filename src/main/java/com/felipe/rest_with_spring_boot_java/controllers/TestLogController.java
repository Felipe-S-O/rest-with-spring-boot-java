package com.felipe.rest_with_spring_boot_java.controllers;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/api/test/v1")
public class TestLogController {

    private Logger logger = (Logger) LoggerFactory.getLogger(TestLogController.class.getName());

    @GetMapping
    public String testLog() {
        logger.debug("This is a debug log");
        logger.info("This is an info log");
        logger.warn("This is a warn log");
        logger.trace("This is an error log");
        logger.error("This is an error log");
        return "Check the logs to see the output";
    }

}
