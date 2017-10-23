package com.lock.readAndWrite.readAndwrite;

public class ThreadA extends Thread {
	
	private MyService service;
	
	public ThreadA(MyService service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.read();
	}
}
