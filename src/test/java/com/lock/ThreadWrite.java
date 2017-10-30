package com.lock;

public class ThreadWrite extends Thread {
	
	private MyLock lock;
	
	public ThreadWrite(MyLock lock) {
		super();
		this.lock = lock;
	}

	@Override
	public void run() {
		lock.write();
	}
}
