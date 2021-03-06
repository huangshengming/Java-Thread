package com.lock.simple.one;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
	
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	private boolean hasValue = true;
	
	private String v = new String();
	
	public void set() {
		//不要试图 把 lock 放入到 try-catch 中，因为如果在获取锁时报错，会导致无故释放锁
		lock.lock();
		try {
			while(hasValue) {
				condition.await();
			}
			Thread.sleep(2000);
			String value = System.currentTimeMillis() + "";
			System.out.println("set:" + value);
			v = value;
			hasValue = true;
			condition.signal();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void get() {
		//不要试图 把 lock 放入到 try-catch 中，因为如果在获取锁时报错，会导致无故释放锁
		lock.lock();
		try {
			while(!hasValue) {
				condition.await();
			}
			System.out.println("get:" + v);
			v = "";
			hasValue = false;
			condition.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

}
