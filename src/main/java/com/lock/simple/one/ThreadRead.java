package com.lock.simple.one;

public class ThreadRead extends Thread {
	
	private MyService service;
	
	public ThreadRead(MyService service) {
		this.service = service;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			service.get();
		}
	}
}
