package com.lock.readAndWrite.readAndwrite;

public class T {
	
	public static void main(String[] args) throws InterruptedException {
		MyService service = new MyService();
		ThreadA a = new ThreadA(service);
		ThreadB b = new ThreadB(service);
		
		//执行时间一样说明 readLock 允许同时进行
		a.start();
		b.start();
	}
}
