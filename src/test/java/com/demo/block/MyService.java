package com.demo.block;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MyService {
	
	private BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(1);

	public void setV() {
		
		try {
			String v = System.currentTimeMillis() + "";
			System.out.println("set v = " + v);
			blockingQueue.put(v);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getV() {
		try {
			System.out.println("get v = " + blockingQueue.take());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
