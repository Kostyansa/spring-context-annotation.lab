package org.shop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
public class LoggerAspect {

    private final Logger logger = LoggerFactory.getLogger("ServiceLogger");

    @Pointcut("within(org.shop..api.*.*)")
    public void businessService() {
    }

    @Pointcut("bean(*Repository)")
    public void repository() {
    }

    @Before("businessService()")
    public void logServiceMethod() {
        logger.trace("Started execution of service method");
    }

    @Before("repository()")
    public void logDataAccess() {
        logger.trace("Started execution of repository method");
    }

}
