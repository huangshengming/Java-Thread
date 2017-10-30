package com.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyLock {
	
	ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	
	public void read() {
		
		readWriteLock.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName() + " read!!! " + + System.currentTimeMillis());
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			readWriteLock.readLock().unlock();
		}
	}
	
	public void write() {
		readWriteLock.writeLock().lock();
		try {
			System.out.println(Thread.currentThread().getName() + " write!!! " + + System.currentTimeMillis());
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			readWriteLock.writeLock().unlock();
		}
	}
}
