package com.jailmango.spring.boot.redis.configuration;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * ServiceLogAop
 *
 * @author jailmango
 * @CreateDate 2019-01-31
 * @see com.jailmango.java.spring.boot.redis.configuration
 * @since R9.0
 */
@Component
@Aspect
public class ServiceLogAopConfiguration {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ServiceLogAopConfiguration.class);

    /**
     * 开始日志模板
     */
    private static final String SERVICE_LOG_TEMPLATE = "Service: [{}]. Cost: [{}]ms";

    /**
     * flag
     */
    private static final String FLAG = "==================================";

    /**
     * serviceLogAspect
     */
    @Pointcut("(@annotation(com.jailmango.spring.boot.redis.annotation.ServiceLog)) && (execution(public * *..*.*(..)))")
    public void serviceLogAspect() {

    }

    /**
     * recordServiceLog
     * 
     * @param point ProceedingJoinPoint
     * @return Object
     */
    @Around("serviceLogAspect()")
    private Object recordServiceLog(ProceedingJoinPoint point) {
        Object result = null;
        Long startTime = System.currentTimeMillis();
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        String methodName = methodSignature.getMethod().getName();

        try {
            result = point.proceed(point.getArgs());
        }
        catch (Throwable throwable) {
            logger.error(throwable.getLocalizedMessage());
        }
        finally {
            logger.info(FLAG);
            Long endTime = System.currentTimeMillis();
            logger.info(SERVICE_LOG_TEMPLATE, methodName, (endTime - startTime));
            logger.info(FLAG);
        }

        return result;
    }
}
