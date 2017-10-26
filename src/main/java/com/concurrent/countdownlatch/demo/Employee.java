package com.concurrent.countdownlatch.demo;

import java.util.concurrent.CountDownLatch;

/**
 * 分布式工作线程
 * @author xingwuzhao
 *
 */
public class Employee implements Runnable {
	
	//员工ID
	private int employeeIndex;
	private CountDownLatch latch;
	
	public Employee(int employeeIndex, CountDownLatch latch) {
		super();
		this.employeeIndex = employeeIndex;
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			System.out.println("员工：" + employeeIndex + "：到门口了");
			Thread.sleep(10);
			System.out.println("员工："+employeeIndex+"，已到达。");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//每次减1，直到为0
			latch.countDown();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("员工：" + employeeIndex + "：拍照，喝水，做游戏");
		}
	}
}
