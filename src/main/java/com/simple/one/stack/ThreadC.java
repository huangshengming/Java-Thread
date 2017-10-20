package com.simple.one.stack;

public class ThreadC extends Thread {
	
	private MyStack myStack;
	
	public ThreadC(MyStack myStack) {
		this.myStack = myStack;
	}

	@Override
	public void run() {
		while(true) {
			myStack.pop();
		}
	}
}
