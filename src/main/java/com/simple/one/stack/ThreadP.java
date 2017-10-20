package com.simple.one.stack;

public class ThreadP extends Thread {
	
	private MyStack myStack;
	
	public ThreadP(MyStack myStack) {
		this.myStack = myStack;
	}

	@Override
	public void run() {
		while(true) {
			myStack.push();
		}
	}
}
