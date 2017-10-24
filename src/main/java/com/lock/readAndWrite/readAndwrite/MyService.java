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
			try {
				lock.readLock().lock();
				System.out.println("获得写锁:" + Thread.currentThread().getName() + "," + System.currentTimeMillis());
			} finally {
				lock.readLock().unlock();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void write() {
		try {
			try {
				lock.writeLock().lock();
				System.out.println("获得写锁:" + Thread.currentThread().getName() + "," + System.currentTimeMillis());
			}  finally {
				lock.writeLock().unlock();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
