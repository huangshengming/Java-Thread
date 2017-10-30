package com.demo.await;

public class AwaitMain {
	
	public static void main(String[] args) {
		
		MyService myService = new MyService();
		
		MyThreadA a = new MyThreadA(myService);
		MyThreadB b = new MyThreadB(myService);
		
		Thread t1 = new Thread(a);
		t1.start();
		
		Thread t2 = new Thread(b);
		t2.start();
	}

}
