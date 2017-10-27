package com.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch简单的说就是一个线程等待，直到他所等待的其他线程都执行完成并且调用countDown()方法发出通知后，当前线程才可以继续执行
 * @author xingwuzhao
 *
 */
public class TestCountDownLatch {
	
	public static final CountDownLatch LATCH = new CountDownLatch(10);

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					System.out.println("线程" + Thread.currentThread().getId() + "开始出发");
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("线程" + Thread.currentThread().getId() + "已到达终点");
					LATCH.countDown();
				}
			}).start();;
		}
		try {
			LATCH.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("10个线程已经执行完毕！开始计算排名");
	}

}
