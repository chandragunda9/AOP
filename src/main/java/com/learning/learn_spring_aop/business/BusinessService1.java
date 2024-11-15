package com.learning.learn_spring_aop.business;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.learn_spring_aop.annotations.TrackTime;
import com.learning.learn_spring_aop.data.DataService1;

@Service
public class BusinessService1 {

	@Autowired
	DataService1 dataLayer1;

	@TrackTime
	public int calculateMax() {
		int[] data = dataLayer1.retrieveData();
		
//		throw new RuntimeException("some error");
		return Arrays.stream(data).max().orElse(0);
	}

}
