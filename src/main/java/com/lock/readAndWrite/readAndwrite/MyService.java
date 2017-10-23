package com.lock.readAndWrite.readAndwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写互斥
 * @author xingwuzhao
 *
 */
public class MyService {
	
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	
	public void read() {
		try {
			lock.readLock().lock();
			System.out.println("获得写锁:" + Thread.currentThread().getName() + "," + System.currentTimeMillis());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.readLock().unlock();
		}
	}
	
	public void write() {
		try {
			lock.writeLock().lock();
			System.out.println("获得写锁:" + Thread.currentThread().getName() + "," + System.currentTimeMillis());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.writeLock().unlock();
		}
	}

}
