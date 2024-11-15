package com.learning.learn_spring_aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class PerformanceTrackingAspect {

	Logger logger = LoggerFactory.getLogger(getClass());

//	@Around("execution(* com.learning.learn_spring_aop.*.*.*(..))")
//	@Around("com.learning.learn_spring_aop.aspects.CommonPointcutConfig.businessAndDataPackageConfig()")
	@Around("com.learning.learn_spring_aop.aspects.CommonPointcutConfig.trackTimeAnnotation()")
	Object findExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

		long startTime = System.currentTimeMillis();
		
		Object returnVal = joinPoint.proceed();

		long endTime = System.currentTimeMillis();

		logger.info("Around aspect method: {} - execution time: {}", joinPoint, endTime - startTime);
		
		return returnVal;
	}

}
