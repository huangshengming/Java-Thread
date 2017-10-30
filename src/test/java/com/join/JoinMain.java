package com.join;

public class JoinMain {

	public static void main(String[] args) throws InterruptedException {
		ThreadA a = new ThreadA();
		ThreadB b = new ThreadB();
		ThreadC c = new ThreadC();
		
		a.start();
		a.join();
		b.start();
		b.join();
		c.start();
		c.join();
	}
}
