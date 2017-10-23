package com.lock.simple.many;

public class TMain {
	
	public static void main(String[] args) {
		MyService service = new MyService();
		for (int i = 0; i < 2; i++) {
			ThreadRead read = new ThreadRead(service);
			read.start();
		}
		
		for (int i = 0; i < 2; i++) {
			ThreadWrite write = new ThreadWrite(service);
			write.start();
		}
	}
}
