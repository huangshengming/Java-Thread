package com.concurrent.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class Runner implements Runnable {
	
	private String name;
	private CyclicBarrier cyclicBarrier;
	
	public Runner(CyclicBarrier cyclicBarrier, String name) {
		this.cyclicBarrier = cyclicBarrier;
		this.name = name;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(100);
			System.out.println(name + ",已经准备好了");
			cyclicBarrier.await();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(name + ",出发");
	}
}
