package com.piped.charT;

import java.io.PipedReader;

public class ThreadRead extends Thread {

	private DataMethod dataMethod;
	private  PipedReader in;
	
	public ThreadRead(DataMethod dataMethod, PipedReader in) {
		this.dataMethod = dataMethod;
		this.in = in;
	}

	@Override
	public void run() {
		dataMethod.readMethod(in);
	}
}
