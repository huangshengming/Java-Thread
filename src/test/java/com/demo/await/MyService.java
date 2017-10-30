package com.demo.await;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {

	private static List<String> l = new ArrayList<>();
	private ReentrantLock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	public void setV() {
		
		lock.lock();
		try {
			if(l.size() == 1) {
				condition.await();
			}
			String v = System.currentTimeMillis() + "";
			System.out.println("set v = " + v);
			l.add(v);
			condition.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void getV() {
		lock.lock();
		try {
			if(l.size() == 0) {
				condition.await();
			}
			System.out.println("get v = " + l.get(0));
			l.remove(0);
			condition.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
