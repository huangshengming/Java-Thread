package com.piped.byteT;

import java.io.PipedOutputStream;

public class ThreadWrite extends Thread {

	private DataMethod dataMethod;
	private  PipedOutputStream out;
	
	public ThreadWrite(DataMethod dataMethod, PipedOutputStream out) {
		super();
		this.dataMethod = dataMethod;
		this.out = out;
	}

	@Override
	public void run() {
		dataMethod.writeMethod(out);
	}
}
