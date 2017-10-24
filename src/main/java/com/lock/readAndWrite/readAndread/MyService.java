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
		//不要试图 把 lock 放入到 try-catch 中，因为如果在获取锁时报错，会导致无故释放锁
		lock.readLock().lock();
		try {
			System.out.println("获得读锁:" + Thread.currentThread().getName() + "," + System.currentTimeMillis());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.readLock().unlock();
		}
	}

}
