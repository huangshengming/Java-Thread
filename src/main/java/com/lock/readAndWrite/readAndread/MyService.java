package com.lock.readAndWrite.readAndread;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读读共享
 * @author xingwuzhao
 *
 */
public class MyService {
	
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	
	public void read() {
		try {
			lock.readLock().lock();
			System.out.println("获得读锁:" + Thread.currentThread().getName() + "," + System.currentTimeMillis());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.readLock().unlock();
		}
	}

}
