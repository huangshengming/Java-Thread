package com.demo.block;

public class MyThreadB extends Thread {

	private MyService myService;

	public MyThreadB(MyService myService) {
		this.myService = myService;
	}

	@Override
	public void run() {
		myService.getV();
	}
}
