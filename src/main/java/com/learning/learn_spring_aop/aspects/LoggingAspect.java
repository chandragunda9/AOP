package com.learning.learn_spring_aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggingAspect {

	Logger logger = LoggerFactory.getLogger(getClass());

//	@Before("execution(* com.learning.learn_spring_aop.*.*.*(..))")
//	@Before("com.learning.learn_spring_aop.aspects.CommonPointcutConfig.businessAndDataPackageConfig()")
	@Before("com.learning.learn_spring_aop.aspects.CommonPointcutConfig.allPackageConfigUsingBean()")
	void beforeMethodCall(JoinPoint joinpoint) {
		logger.info("Before aspect: method: {} intercepted with args {}", joinpoint, joinpoint.getArgs());
	}

//	@After("execution(* com.learning.learn_spring_aop.*.*.*(..))")
	@After("com.learning.learn_spring_aop.aspects.CommonPointcutConfig.businessPackageConfig()")
	void afterMethodCall(JoinPoint joinpoint) {
		logger.info("After aspect: method: {} executed..", joinpoint);
	}

	@AfterThrowing(pointcut = "com.learning.learn_spring_aop.aspects.CommonPointcutConfig.businessAndDataPackageConfig()", throwing = "exception")
	void afterThrowingMethodCall(JoinPoint joinpoint, Exception exception) {
		logger.info("AfterThrowing aspect: method: {} got exception: {}", joinpoint, exception.getMessage());
	}

	@AfterReturning(pointcut = "com.learning.learn_spring_aop.aspects.CommonPointcutConfig.dataPackageConfig()", returning = "resultVal")
	void afterReturningMethodCall(JoinPoint joinpoint, Object resultVal) {
		logger.info("AfterReturning aspect: method: {} executed successfully.. value retuned is: {}", joinpoint,
				resultVal);
	}
	
	

}
