package com.lock;

public class LockMain {

	public static void main(String[] args) {
		
		MyLock lock = new MyLock();
		
		ThreadRead read1 = new ThreadRead(lock);
		ThreadRead read2 = new ThreadRead(lock);
		ThreadRead read3 = new ThreadRead(lock);
		
		ThreadWrite write1 = new ThreadWrite(lock);
		ThreadWrite write2 = new ThreadWrite(lock);
		ThreadWrite write3 = new ThreadWrite(lock);
		ThreadWrite write4 = new ThreadWrite(lock);
		ThreadWrite write5 = new ThreadWrite(lock);
		
		read1.start();
		read2.start();
		read3.start();
		
		write1.start();
		write2.start();
		write3.start();
		write4.start();
		write5.start();
		
		try {
			read1.wait();
			read1.sleep(1);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
