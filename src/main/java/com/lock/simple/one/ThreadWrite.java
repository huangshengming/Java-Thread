package com.lock.simple.one;

public class ThreadWrite extends Thread {
	
	private MyService service;
	
	public ThreadWrite(MyService service) {
		this.service = service;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			service.set();
		}
	}
}
