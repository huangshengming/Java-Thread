package com.piped.byteT;

import java.io.PipedInputStream;

public class ThreadRead extends Thread {

	private DataMethod dataMethod;
	private  PipedInputStream in;
	
	public ThreadRead(DataMethod dataMethod, PipedInputStream in) {
		this.dataMethod = dataMethod;
		this.in = in;
	}

	@Override
	public void run() {
		dataMethod.readMethod(in);
	}
}
