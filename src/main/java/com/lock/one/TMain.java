package com.lock.one;

public class TMain {
	
	public static void main(String[] args) {
		MyService service = new MyService();
		ThreadRead read = new ThreadRead(service);
		ThreadWrite write = new ThreadWrite(service);
		
		read.start();
		write.start();
	}
}
