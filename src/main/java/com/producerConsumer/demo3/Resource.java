package com.producerConsumer.demo3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Resource {

	private BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(2);
	
	public void push() {
		try {
			Thread.sleep(200);
			String v = System.currentTimeMillis() + "";
			System.out.println(Thread.currentThread().getName() + ",放入 v=" + v);
			blockingQueue.put(v);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public void pop() {
		try {
			System.out.println(Thread.currentThread().getName() + ",取出 v=" + blockingQueue.take());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
