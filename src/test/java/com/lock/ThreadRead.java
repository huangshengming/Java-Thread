package com.lock;

public class ThreadRead extends Thread {
	
	private MyLock lock;
	
	public ThreadRead(MyLock lock) {
		super();
		this.lock = lock;
	}

	@Override
	public void run() {
		lock.read();
	}
}
