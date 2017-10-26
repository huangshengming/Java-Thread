package com.concurrent.countdownlatch.demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Company {

	public static void main(String[] args) {
		
		//员工数量
		int count = 5;
		CountDownLatch countDownLatch = new CountDownLatch(count);
		
		ExecutorService threadPool =  Executors.newFixedThreadPool(count);
		
		try {
			for (int i = 0; i < count; i++) {
				Thread.sleep(10);
				threadPool.execute(new Employee(i + 1, countDownLatch));
			}
			Thread.sleep(20);
			//等待计数器为0
			countDownLatch.await();
			System.out.println("人全到了，出发啦");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			threadPool.shutdown();
		}
	}

}
