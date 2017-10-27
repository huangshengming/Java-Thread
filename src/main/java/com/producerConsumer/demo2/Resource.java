package com.producerConsumer.demo2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Resource {

	//相当于仓库
	private List<String> list = new ArrayList<>();
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	public void push() {
		lock.lock();
		try {
			while(list.size() == 1) {
				condition.await();
			}
			Thread.sleep(200);
			String v = System.currentTimeMillis() + "";
			list.add(v);
			System.out.println(Thread.currentThread().getName() + ",放入 v=" + v);
			condition.signalAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void pop() {
		lock.lock();
		try {
			while(list.size() == 0) {
				condition.await();
			}
			System.out.println(Thread.currentThread().getName() + ",取出 v=" + list.get(0));
			list.remove(0);
			condition.signalAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
