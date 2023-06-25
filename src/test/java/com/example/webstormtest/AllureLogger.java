package com.example.webstormtest;

import io.qameta.allure.Step;
import org.slf4j.Logger;

public class AllureLogger {
    private Logger logger;
    public AllureLogger(Logger logger){
        this.logger =logger;
    }
    @Step("{logText}")
    public void info(String logText){
        logger.info(logText);
    }
}
