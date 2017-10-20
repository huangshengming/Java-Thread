package com.simple.many.value;

public class ThreadP extends Thread {
	
	private P p;
	
	public ThreadP(P p) {
		this.p = p;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			p.setValue();
		}
	}
}
