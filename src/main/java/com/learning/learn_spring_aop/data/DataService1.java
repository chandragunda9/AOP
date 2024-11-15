package com.learning.learn_spring_aop.data;

import org.springframework.stereotype.Repository;

import com.learning.learn_spring_aop.annotations.TrackTime;

@Repository
public class DataService1 {

	@TrackTime
	public int[] retrieveData() {
		int[] arr = { 1, 33, 22, 66, 99, 76, 90 };
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
	}
}
