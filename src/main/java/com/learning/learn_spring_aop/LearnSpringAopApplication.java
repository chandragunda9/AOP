package com.learning.learn_spring_aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learning.learn_spring_aop.business.BusinessService1;

@SpringBootApplication
public class LearnSpringAopApplication implements CommandLineRunner {
	
	Logger logger=LoggerFactory.getLogger(getClass());

	@Autowired
	BusinessService1 businessLayer1;

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("value returned: {}", businessLayer1.calculateMax());
	}

}
