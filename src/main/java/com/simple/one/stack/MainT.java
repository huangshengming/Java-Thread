package com.simple.one.stack;

public class MainT {

	public static void main(String[] args) {
		
		MyStack lock = new MyStack();
		
		ThreadC tc = new ThreadC(lock);
		tc.start();
		
		ThreadP tp = new ThreadP(lock);
		tp.start();
	}
}
