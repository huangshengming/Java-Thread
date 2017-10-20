package com.simple.many.stack;

public class MainT {

	public static void main(String[] args) {
		
		MyStack myStack = new MyStack(); 
		
		ThreadP tp1 = new ThreadP(myStack);
		tp1.start();
//		ThreadP tp2 = new ThreadP(myStack);
//		tp2.start();
//		ThreadP tp3 = new ThreadP(myStack);
//		tp3.start();
		
		ThreadC tc1 = new ThreadC(myStack);
		tc1.start();
		ThreadC tc2 = new ThreadC(myStack);
		tc2.start();
		ThreadC tc3 = new ThreadC(myStack);
		tc3.start();
	}
}
