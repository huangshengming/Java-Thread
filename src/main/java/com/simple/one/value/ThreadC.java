package com.simple.one.value;

public class ThreadC extends Thread {
	
	private C c;
	
	public ThreadC(C c) {
		this.c = c;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			c.getValue();
		}
	}
}
